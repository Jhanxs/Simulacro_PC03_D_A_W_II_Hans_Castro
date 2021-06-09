package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Empleado;

public interface EmpleadoService {
	
	public abstract List<Empleado> listaEmpleado();
	public abstract Empleado insertaActualizaEmpleado(Empleado obj);
	public abstract Optional<Empleado> obtienePorId(int idEmpleado);
	public abstract void eliminaEmpleado(int id);
	public abstract List<Empleado> listaEmpleadoPorNombreLike(String filtro);
	public abstract List<Empleado> listaPorDni(String dni);
	public abstract List<Empleado> listaPorDni(String dni, int idEmpleado);

}
