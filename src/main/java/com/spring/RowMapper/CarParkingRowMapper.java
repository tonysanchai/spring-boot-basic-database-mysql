package com.spring.RowMapper;

import com.spring.dto.CarDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CarParkingRowMapper implements RowMapper<CarDto> {

    public CarDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Employee employee = new Employee();
//        CarDto employee = new Employee();
        CarDto car = new CarDto();

        car.setFloor(rs.getString("FLOOR"));
        car.setQuantity(rs.getString("QUANTITY"));

        return car;
    }

}