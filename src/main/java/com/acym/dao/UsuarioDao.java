package com.acym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acym.entity.Usuarios;
import org.springframework.data.repository.query.Param;
public interface UsuarioDao extends JpaRepository<Usuarios, Long>{
	@Query("SELECT u FROM Usuarios u "
			+ "where u.usuario = :usuario and "
			+ "u.password = :password and "
			+ "u.estado = 1")
	Usuarios verificaUsuario(@Param("usuario") String usuario, @Param("password")String password );
}
