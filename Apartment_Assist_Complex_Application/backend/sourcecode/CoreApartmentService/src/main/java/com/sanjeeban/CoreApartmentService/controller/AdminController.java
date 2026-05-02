package com.sanjeeban.CoreApartmentService.controller;

import com.sanjeeban.CoreApartmentService.dto.*;
import com.sanjeeban.CoreApartmentService.entity.ApartmentTypeMaster;
import com.sanjeeban.CoreApartmentService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/getAllApartmentTypes")
    public List<ApartmentTypeMaster> getAllApartmentTypes(){
        List<ApartmentTypeMaster> list = adminService.getAllApartmentTypes();
        return list;
    }

    @GetMapping("/hello")
    public String getHello(@RequestParam("msg") String text) {
        return "hello world -> " + text;
    }


    @PostMapping(value = "/saveNewUser",produces = "application/json", consumes = "application/json")
    public ResponseEntity<GenericApiResponse<SaveNewUserResponse>> saveNewUser(@RequestBody SaveNewUserRequest request){
        SaveNewUserResponse response = new SaveNewUserResponse();
        response = adminService.createNewUser(request);
        return ResponseEntity.ok(GenericApiResponse.success(response));
    }

    @GetMapping(value = "/getUserByUniqueNumber", produces = "application/json")
    public ResponseEntity<GenericApiResponse<SaveNewUserRequest>> getUser(@RequestParam("uniqueNumber") String uniqueNumber){
        SaveNewUserRequest response = new SaveNewUserRequest();
        response = adminService.getUser(uniqueNumber);
        return ResponseEntity.ok(GenericApiResponse.success(response));
    }


    @PostMapping(value = "/registerUser", consumes = "application/json",produces = "application/json")
    public ResponseEntity<GenericApiResponse<RegisterUserResponse>> registerUser(@RequestBody RegisterUserRequest request){
        RegisterUserResponse response = new RegisterUserResponse();
        response = adminService.registerUser(request);
        return ResponseEntity.ok(GenericApiResponse.success(response));
    }

    @GetMapping(value = "/getUserTypes",produces = "application/json")
    public ResponseEntity<GenericApiResponse<UserTypeMasterResponse>> getUserTypes(){
        UserTypeMasterResponse response = new UserTypeMasterResponse();
        response = adminService.getUserTypes();
        return ResponseEntity.ok(GenericApiResponse.success(response));
    }


    ///admin/getUsernameType?username=${usern

    @GetMapping(value = "/getUsernameType")
    public ResponseEntity<GenericApiResponse<String>> getUserNameTypes(@RequestParam String userName){
        String userType = adminService.getUserType(userName);
        return ResponseEntity.ok(GenericApiResponse.success(userType));
    }



}
