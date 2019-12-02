package com.acym.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acym.entity.Hoja;
import com.acym.entity.IngresoEgreso;

public interface IngresoEgresoDao extends JpaRepository<IngresoEgreso, Long>{
	@Query("SELECT u from IngresoEgreso u "
			+ "where u.fechaRegistro >= :fechaInicio and "
				  + "u.fechaRegistro <= :fechaFin and "
				  + "u.tipocuenta = :tipoCuenta")
	List<IngresoEgreso> getIngresosEgresosByFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechafin, @Param("tipoCuenta")String tipoCuenta);
	
	@Query("SELECT u from IngresoEgreso u "
			+ "where u.idIngresoEgreso = ( "
			+ "SELECT max(a.idIngresoEgreso) from IngresoEgreso a "
			+ "where a.tipocuenta = :tipoCuenta "
			+ "and a.estado = 1 "
			+ ") "
			+ "and u.estado = 1")
	IngresoEgreso getMaximoHoja(@Param("tipoCuenta")String tipoCuenta);
}
