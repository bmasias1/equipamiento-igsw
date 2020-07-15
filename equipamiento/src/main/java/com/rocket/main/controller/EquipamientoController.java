package com.rocket.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocket.main.dao.EquipamientoRepository;
import com.rocket.main.model.Equipamiento;

@RestController
public class EquipamientoController {
	@Autowired
	EquipamientoRepository equipamientoRepository;
	
	@GetMapping("/equipamiento")
	public List<Equipamiento> getAll() {
		return equipamientoRepository.findAll();
	}
}
