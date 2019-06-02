package com.spring.dao;

import com.spring.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDao {

    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CarDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    public List<CarDto> findAllCar() {

        StringBuilder sql = new StringBuilder();

        sql.append("select floor, quantity from car_park_intelligent.car_amount_park");

        List<CarDto> result = namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper(CarDto.class));

        return result;

    }
}
