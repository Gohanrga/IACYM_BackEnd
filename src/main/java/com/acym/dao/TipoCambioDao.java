package com.acym.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acym.entity.TipoCambio;

public interface TipoCambioDao extends JpaRepository<TipoCambio, Long>{

	@Query("SELECT u from TipoCambio u where u.fecha = :fecha")
	TipoCambio verificaExistencia(@Param("fecha") Date fecha);
}
