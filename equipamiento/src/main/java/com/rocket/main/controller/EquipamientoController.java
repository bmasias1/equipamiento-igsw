package com.rocket.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rocket.main.dao.EquipamientoRepository;
import com.rocket.main.model.Equipamiento;
import com.rocket.main.model.Reserva;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/equipamiento")
public class EquipamientoController {
	@Autowired
	EquipamientoRepository equipamientoRepository;

	public int getEstado(int equipamientoId) {
		// Modificar con URI del microservicio Reservas
		final String uri = "https://api.agify.io/?name={name}";
		// final String uri = "https://example.com/{name}";

		// Modificar parametros necesarios, como el id del equipamiento
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "michel");
		//params.put("id", equipamientoId);

		RestTemplate restTemplate = new RestTemplate();
		try {
			// Modificar campos de reserva en el modelo
			Reserva reserva = restTemplate.getForObject(uri, Reserva.class, params);
			return reserva.getCount();
		} catch (Exception e) {
			// Si la solicitud no funciona, el estado se asume como disponible
			return 0;
		}
	}

	@GetMapping(path={"/", ""}, produces="application/json")
	public List<Equipamiento> getAll() {
		List<Equipamiento> equipamientos = equipamientoRepository.findAll();
		equipamientos.forEach((equipamiento -> equipamiento.setEstado(getEstado(equipamiento.getId()))));
		return equipamientos;
	}

	@GetMapping(path="/{id}", produces="application/json")
	public Equipamiento getById(@PathVariable int id) {
		Equipamiento equipamiento = equipamientoRepository.findById(id).orElse(null);
		if (equipamiento != null) {
			equipamiento.setEstado(getEstado(equipamiento.getId()));
		}
		return equipamiento;
	}

	@PostMapping(path={"/", ""},  consumes="application/json", produces="application/json")
	public Equipamiento add(@RequestBody Equipamiento equipamiento) {
		return equipamientoRepository.save(equipamiento);
	}

	@PutMapping(path={"/", ""}, consumes="application/json", produces="application/json")
	public Equipamiento update(@RequestBody Equipamiento equipamiento) {
		return add(equipamiento);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable int id) {
		equipamientoRepository.deleteById(id);
	}
}
