package com.rocket.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/equipamiento/{id}")
	public Equipamiento getById(int id) {
		return equipamientoRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/equipamiento")
	public Equipamiento add(Equipamiento equipamiento) {
		return equipamientoRepository.save(equipamiento);
	}
	
	/*
	 * Indeed, updating and inserting elements has the same behavior because if the object doesn't exist,
	 * it will put on a new record (unless we agree to do not do this)
	 */
	@PutMapping("/equipamiento")
	public Equipamiento update(Equipamiento equipamiento) {
		return add(equipamiento);
	}
	
	@DeleteMapping("/equipamiento")
	public void delete(int id) {
		equipamientoRepository.deleteById(id);
	}
}
