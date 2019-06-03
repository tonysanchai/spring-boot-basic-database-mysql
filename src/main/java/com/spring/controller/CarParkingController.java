package com.spring.controller;

import com.spring.dto.CarDto;
import com.spring.service.CarService;
import com.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CarParkingController {

    final private CarService carService;

    @Autowired
    public CarParkingController(CustomerService customerService, CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/getAllCarParking", method = RequestMethod.GET)
    public ResponseEntity<List<CarDto>> getAllCarParking(@ModelAttribute CarDto carDto) {
        return ResponseEntity.ok(carService.getAllCarParking(carDto));
    }

    @RequestMapping(value = "/getCarParkingByFloor", method = RequestMethod.GET)
    public ResponseEntity<List<CarDto>> getCarParkingByFloor(@RequestParam(name = "floor", required = false, defaultValue = "1") String floor) {

        return ResponseEntity.ok(carService.getCarParkingByFloor(floor));

    }


}
