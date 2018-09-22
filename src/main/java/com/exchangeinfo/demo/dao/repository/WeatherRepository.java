package com.exchangeinfo.demo.dao.repository;

import com.exchangeinfo.demo.dao.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
}
