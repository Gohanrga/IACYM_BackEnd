package com.acym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acym.entity.Miembro;

public interface MiembroDao extends JpaRepository<Miembro, Long>{
	@Query("SELECT u from Miembro where u.nombre like :nombre or u.idDiezmo = :id")
	Miembro buscaMiembros(@Param("nombre")String nombre, @Param("id")int id);
}
