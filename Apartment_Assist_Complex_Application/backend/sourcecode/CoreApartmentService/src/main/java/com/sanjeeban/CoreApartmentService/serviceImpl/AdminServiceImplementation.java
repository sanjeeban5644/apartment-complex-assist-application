package com.sanjeeban.CoreApartmentService.serviceImpl;

import com.sanjeeban.CoreApartmentService.customException.InvalidCredentialsException;
import com.sanjeeban.CoreApartmentService.dto.*;
import com.sanjeeban.CoreApartmentService.entity.ApartmentTypeMaster;
import com.sanjeeban.CoreApartmentService.entity.UserInfo;
import com.sanjeeban.CoreApartmentService.entity.UserMapping;
import com.sanjeeban.CoreApartmentService.entity.UserTypeMaster;
import com.sanjeeban.CoreApartmentService.repository.ApartmentTypeMasterRepository;
import com.sanjeeban.CoreApartmentService.repository.UserInfoRepository;
import com.sanjeeban.CoreApartmentService.repository.UserMappingRepository;
import com.sanjeeban.CoreApartmentService.repository.UserTypeMasterRepository;
import com.sanjeeban.CoreApartmentService.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminServiceImplementation implements AdminService {

    @Autowired
    private ApartmentTypeMasterRepository apartmentTypeMasterRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMappingRepository userMappingRepository;

    @Autowired
    UserTypeMasterRepository userTypeMasterRepository;

    @Override
    public List<ApartmentTypeMaster> getAllApartmentTypes() {
        return apartmentTypeMasterRepository.findAll();
    }

    @Override
    public SaveNewUserResponse createNewUser(SaveNewUserRequest request) {
        SaveNewUserResponse response = new SaveNewUserResponse();

        // Parameter Value extraction
        String aadhar = request.getAadhar();
        String mobile = request.getMobile();
        String email = request.getEmail();
        String rawPassword = request.getPassword();

        // Parameter values validation.
        if(checkIsNullOrBlank(aadhar)) throw new InvalidCredentialsException("Aadhar is invalid or Blank");
        if(checkIsNullOrBlank(mobile)) throw new InvalidCredentialsException("Mobile is Invalid or Blank");
        if(checkIsNullOrBlank(email)) throw new InvalidCredentialsException("Email is Invalid or Blank");

        // Parameter unique constraint check.
        if (userInfoRepository.existsByEmail(email)) {
            throw new InvalidCredentialsException("Email already exists.");
        }

        if (userInfoRepository.existsByMobile(mobile)) {
            throw new InvalidCredentialsException("Mobile already exists.");
        }

        if (userInfoRepository.existsByAadhar(aadhar)) {
            throw new InvalidCredentialsException("Aadhar already exists.");
        }


        String uniqueUserNumber = generateUniqueUserNumber();
        String encodedPassword = passwordEncoder.encode(rawPassword);

//        if (passwordEncoder.matches(rawPassword, storedPassword)) {
//            // success
//        }

        UserInfo userInfoObj = modelMapper.map(request, UserInfo.class);
        userInfoObj.setUniqueUserNumber(uniqueUserNumber);
        userInfoObj.setPassword(encodedPassword);

        userInfoObj.setCreatedAt(LocalDateTime.now());
        userInfoObj.setCreatedBy("SYSTEM ADMIN");

        userInfoRepository.save(userInfoObj);


        response.setUniqueUserNumber(uniqueUserNumber);
        response.setRemarks("User Saved Successfully");

        return response;
    }

    @Override
    public SaveNewUserRequest getUser(String uniqueNumber) {
        SaveNewUserRequest response = new SaveNewUserRequest();

        if(checkIsNullOrBlank(uniqueNumber)) throw new InvalidCredentialsException("Unique User Number cannot be blank.");

        UserInfo userObj = userInfoRepository.findByUniqueUserNumber(uniqueNumber)
                .orElseThrow(() -> new InvalidCredentialsException("Unique User Number does not exist."));

        response = modelMapper.map(userObj, SaveNewUserRequest.class);
        response.setPassword("");
        return response;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        RegisterUserResponse response = new RegisterUserResponse();

        String uniqueUserNumber = request.getUniqueUserNumber();
        String registerCode = request.getRegisterTo();

        if(checkIsNullOrBlank(uniqueUserNumber)) throw new InvalidCredentialsException("Unique User Number is mandatory");
        if(checkIsNullOrBlank(registerCode)) throw new InvalidCredentialsException("Registration Code is mandatory");

        UserInfo userObj = userInfoRepository.findByUniqueUserNumber(uniqueUserNumber)
                .orElseThrow(() -> new InvalidCredentialsException("Unique User Number does not exist"));


        userMappingRepository.findByUniqueUserNumber(uniqueUserNumber)
                .ifPresent(u -> {
                    throw new InvalidCredentialsException("User is already registered.");
                });


        if(!checkDomainValueForUserType(registerCode)){
            throw new InvalidCredentialsException("Registration Code is Invalid.");
        }



        String savedUniqueNumber = userObj.getUniqueUserNumber();
        String code = registerCode.substring(0,3);
        String newUniqueNumber = savedUniqueNumber.substring(0,savedUniqueNumber.length()-3)+code;
        userObj.setUniqueUserNumber(newUniqueNumber);
        userObj.setUpdatedAt(LocalDateTime.now());
        userObj.setUpdatedBy("ADMIN REGISTER");
        userInfoRepository.save(userObj);


        UserMapping userMappingObj = new UserMapping();
        userMappingObj.setUniqueUserNumber(newUniqueNumber);
        userMappingObj.setTypeCode(registerCode);
        userMappingObj.setCreatedAt(LocalDateTime.now());
        userMappingObj.setCreatedBy("SYSTEM ADMIN");
        userMappingRepository.save(userMappingObj);

        response.setRegisteredTo(registerCode);
        response.setUniqueUserNumber(newUniqueNumber);
        response.setRemarks("User Registered Successfully");

        return response;
    }

    @Override
    public UserTypeMasterResponse getUserTypes() {
        UserTypeMasterResponse response = new UserTypeMasterResponse();
        List<UserTypeMaster> list = userTypeMasterRepository.findAll();

        Map<String,String> typeMap = list
                .stream()
                .collect(Collectors.toMap(
                        UserTypeMaster::getTypeCode,
                        UserTypeMaster::getTypeDesc,
                        (existing,replacement) -> existing
                ));

        response.setUserTypeMasterMap(typeMap);
        return response;
    }

    @Override
    public String getUserType(String userName) {
        String userType = "";

        if(checkIsNullOrBlank(userName)) throw new InvalidCredentialsException("User name is Blank.");

        final String sql = """
                select um.type_code from apt_core.t_user_info ui,apt_core.t_user_type_master utm,
                apt_core.t_user_mapping um
                where ui.email = ?
                and ui.unique_user_number = um.unique_user_number
                and um.type_code = utm.type_code
                """;

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,userName);

            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()) userType = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(checkIsNullOrBlank(userType)) throw new InvalidCredentialsException("Username is invalid.");
        return userType;
    }

    private boolean checkDomainValueForUserType(String registerCode) {

        int count = 0;
        final String sql = """
                select  count(*) from  apt_core.t_user_type_master t\s
                where t.type_code = ?
                """;

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

        ){
            ps.setString(1,registerCode);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count > 0;
    }

    private String generateUniqueUserNumber() {
        String sequence = userInfoRepository.getNextUserSequence();
        String initialUserMapping = "000";
        int currentYear = LocalDate.now().getYear();
        String strCurrentYear = String.valueOf(currentYear);
        return strCurrentYear+sequence+initialUserMapping;
    }

    private boolean checkIsNullOrBlank(String value){
        if(value ==null || value.isBlank()) return true;
        return false;
    }
}
