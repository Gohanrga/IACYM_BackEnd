package com.acym.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.acym.entity.CuentaContable;
import com.acym.entity.IngresoEgreso;

public interface CuentaContableDao extends JpaRepository<CuentaContable, String>{
	@Query("SELECT u FROM CuentaContable u WHERE u.codigo = :codigo")
	CuentaContable buscaCuenta(@Param("codigo") String codigo);
	
	@Query("SELECT u FROM CuentaContable u WHERE u.tipoCuenta = :tipo")
	List<CuentaContable> obtieneCuentasByTipo(@Param("tipo")String tipo);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CuentaContable u WHERE  u.codigo = :codigo")
	void eliminaCuenta(@Param("codigo") String codigo);
	
	@Query("SELECT u FROM IngresoEgreso u WHERE u.cuentaContable.codigo = :codigo")
	IngresoEgreso buscaEnIngresoEgreso(@Param("codigo")String codigo);
}
