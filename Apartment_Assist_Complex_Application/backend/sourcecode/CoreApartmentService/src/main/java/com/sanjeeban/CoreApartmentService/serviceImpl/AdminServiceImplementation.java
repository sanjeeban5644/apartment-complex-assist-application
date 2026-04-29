package com.sanjeeban.CoreApartmentService.serviceImpl;

import com.sanjeeban.CoreApartmentService.entity.ApartmentTypeMaster;
import com.sanjeeban.CoreApartmentService.repository.ApartmentTypeMasterRepository;
import com.sanjeeban.CoreApartmentService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService {

    @Autowired
    ApartmentTypeMasterRepository apartmentTypeMasterRepository;


    @Override
    public List<ApartmentTypeMaster> getAllApartmentTypes() {
        return apartmentTypeMasterRepository.findAll();
    }
}
