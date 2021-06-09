package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService service;

	@GetMapping
	public ResponseEntity<List<Empleado>> lista(){
		log.info(">>> lista ");
		return ResponseEntity.ok(service.listaEmpleado());
	}
	
	@PostMapping
	public ResponseEntity<Empleado> registra(@RequestBody Empleado obj){
		log.info(">>> registra " + obj.getIdEmpleado());
		return ResponseEntity.ok(service.insertaActualizaEmpleado(obj));
	}
	
	@PutMapping
	public ResponseEntity<Empleado> actualiza(@RequestBody Empleado obj){
		log.info(">>> actualiza " + obj.getIdEmpleado());
		Optional<Empleado> optEmpleado =   service.obtienePorId(obj.getIdEmpleado());
		if (optEmpleado.isPresent()) {
			return ResponseEntity.ok(service.insertaActualizaEmpleado(obj));	
		}else {
			log.error(">>> actualiza " + obj.getIdEmpleado() + " no encontrado");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Empleado> elimina(@PathVariable("id") int idEmpleado){
		log.info(">>> elimina " + idEmpleado);
		Optional<Empleado> optEmpleado =   service.obtienePorId(idEmpleado);
		if (optEmpleado.isPresent()) {
			service.eliminaEmpleado(idEmpleado);
			return ResponseEntity.ok(optEmpleado.get());
		}else {
			log.error(">>> elimina " + idEmpleado + " no encontrado");
			return ResponseEntity.notFound().build();
		}
	}

}
