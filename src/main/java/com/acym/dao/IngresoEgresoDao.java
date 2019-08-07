package com.acym.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acym.entity.IngresoEgreso;

public interface IngresoEgresoDao extends JpaRepository<IngresoEgreso, Long>{
	@Query("SELECT u IngresoEgreso u where u.fechaRegistro > :fechaInicio and u.fechaRegistro < :fechaFin")
	IngresoEgresoDao getIngresosEgresosByFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechafin);
}
