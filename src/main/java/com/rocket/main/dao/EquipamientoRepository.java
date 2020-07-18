package com.rocket.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocket.main.model.Equipamiento;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, Integer> {

}
