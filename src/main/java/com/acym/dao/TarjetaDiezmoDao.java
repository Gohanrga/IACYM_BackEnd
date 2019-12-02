package com.acym.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.acym.entity.TarjetaDiezmo;

public interface TarjetaDiezmoDao extends JpaRepository<TarjetaDiezmo, Long>{
	@Query("SELECT u from TarjetaDiezmo u where u.estado=0")
	List<TarjetaDiezmo> obtieneTarjetasDiezmo();
	
	@Transactional
	@Modifying
	@Query("UPDATE TarjetaDiezmo u set u.estado = :estado where u.idDiezmo=:id")
	void actualizaEstado(@Param("estado") int estado, @Param("id") Long id);
}
