package com.spring.service;

import com.spring.dao.CarDao;
import com.spring.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    final private CarDao carDao;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

//    public CustomerDto saveCustomer(CustomerDto customerDto,String userName){
//        return customerDao.saveCustomer(customerDto,userName);
//    }

    public List<CarDto> getAllCarParking(CarDto carDto){
        return carDao.getAllCarParking();
    }

    public List<CarDto> getCarParkingByFloor(String floor){
        return carDao.getCarParkingByFloor(floor);
    }
}
