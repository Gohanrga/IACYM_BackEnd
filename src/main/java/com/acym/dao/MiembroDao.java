package com.acym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acym.entity.Miembro;
import com.acym.entity.TarjetaDiezmo;

public interface MiembroDao extends JpaRepository<Miembro, Long>{
	@Query("SELECT u from Miembro u where u.nombre like :nombre or u.tarjetaDiezmo.idDiezmo = :id")
	Miembro buscaMiembros(@Param("nombre")String nombre, @Param("id")int id);
	
	@Query("SELECT u from TarjetaDiezmo u where u.idDiezmo = :id and u.estado=0")
	TarjetaDiezmo verificaDisponibilidad(@Param("id")long id);
}
