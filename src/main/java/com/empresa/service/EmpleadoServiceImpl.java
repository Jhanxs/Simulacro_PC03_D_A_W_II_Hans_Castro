package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Empleado;
import com.empresa.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository repository;

	@Override
	public List<Empleado> listaEmpleado() {
		return repository.findAll();
	}

	@Override
	public Empleado insertaActualizaEmpleado(Empleado obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaEmpleado(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Empleado> listaEmpleadoPorNombreLike(String filtro) {
		return repository.listaEmpleadoPorNombreLike(filtro);
	}

	@Override
	public Optional<Empleado> obtienePorId(int idEmpleado) {
		return repository.findById(idEmpleado);
	}

	@Override
	public List<Empleado> listaPorDni(String dni) {
		return repository.findByDni(dni);
	}

	@Override
	public List<Empleado> listaPorDni(String dni, int idEmpleado) {
		return repository.findByDniAndIdEmpleadoNot(dni, idEmpleado);
	}

}
