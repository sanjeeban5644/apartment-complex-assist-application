package com.sanjeeban.CoreApartmentService.controller;


import com.sanjeeban.CoreApartmentService.dto.GenericApiResponse;
import com.sanjeeban.CoreApartmentService.dto.ResidentDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/resident")
@RestController
public class ResidentController {

    @GetMapping(value = "/getResidentDetail", produces = "application/json", consumes = "application/json")
    public GenericApiResponse<ResponseEntity<ResidentDetailResponse>> getResidentDetail(@RequestParam("uniqueNumber") String uniqueNumber){
        return null;
    }


}
