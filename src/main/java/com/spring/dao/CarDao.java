package com.spring.dao;

import com.spring.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDao {

    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CarDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public List<CarDto> getAllCarParking() {

        StringBuilder sql = new StringBuilder();

        sql.append("select floor, quantity, remain from car_park_intelligent.car_parking");

        List<CarDto> result = namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper(CarDto.class));

        return result;

    }

    public List<CarDto> getCarParkingByFloor(String floor) {

        StringBuilder sql = new StringBuilder();

        sql.append("select floor, quantity, remain from car_park_intelligent.car_parking where floor = :floor");
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("floor", floor);

        List<CarDto> result = namedParameterJdbcTemplate.query(sql.toString(), namedParameters, new BeanPropertyRowMapper(CarDto.class));
        return result;

    }
}
