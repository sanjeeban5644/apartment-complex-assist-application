package com.sanjeeban.CoreApartmentService.service;

import com.sanjeeban.CoreApartmentService.dto.*;
import com.sanjeeban.CoreApartmentService.entity.ApartmentTypeMaster;

import java.util.List;

public interface AdminService {

    public List<ApartmentTypeMaster> getAllApartmentTypes();

    public SaveNewUserResponse createNewUser(SaveNewUserRequest request);

    public SaveNewUserRequest getUser(String uniqueNumber);

    public RegisterUserResponse registerUser(RegisterUserRequest request);

    public UserTypeMasterResponse getUserTypes();
}
