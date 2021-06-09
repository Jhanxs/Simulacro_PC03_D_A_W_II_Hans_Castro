package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	@Query("Select a from Empleado a where nombre like :fil")
	public abstract List<Empleado> listaEmpleadoPorNombreLike(@Param("fil") String filtro);
	public abstract List<Empleado> findByDni(String dni);
	public abstract List<Empleado> findByDniAndIdEmpleadoNot(String dni, int idEmpleado);

}
