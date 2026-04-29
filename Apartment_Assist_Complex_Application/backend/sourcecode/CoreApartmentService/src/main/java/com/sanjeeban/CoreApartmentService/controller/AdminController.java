package com.sanjeeban.CoreApartmentService.controller;

import com.sanjeeban.CoreApartmentService.entity.ApartmentTypeMaster;
import com.sanjeeban.CoreApartmentService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
