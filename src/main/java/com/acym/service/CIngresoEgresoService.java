package com.acym.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.CuentaContableDao;
import com.acym.dao.CultoDao;
import com.acym.dao.IngresoEgresoDao;
import com.acym.dao.MiembroDao;
import com.acym.dao.TipoConceptoDao;
import com.acym.entity.CuentaContable;
import com.acym.entity.Culto;
import com.acym.entity.Hoja;
import com.acym.entity.IngresoEgreso;
import com.acym.entity.Miembro;
import com.acym.entity.TipoConcepto;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.TransaccionNoExiste;

@Service
public class CIngresoEgresoService implements IIngresoEgresoService{
	@Autowired
	private IngresoEgresoDao ingresoEgresoDao;
	@Autowired
	private CuentaContableDao cuentaContableDao;
	@Autowired
	private TipoConceptoDao tipoConceptoDao;
	@Autowired
	private CultoDao cultoDao;
	@Autowired
	private MiembroDao miembroDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IngresoEgreso> getIngresosEgresosByFecha(Date fechaInicio, Date fechaFin, String tipoCuenta) {
		return (List<IngresoEgreso>) ingresoEgresoDao.getIngresosEgresosByFecha(fechaInicio, fechaFin, tipoCuenta);
	}

	@Override
	public IngresoEgreso getIngresoEgresoById(Long id) {
		return ingresoEgresoDao.findById(id).orElse(null);
	}

	@Override
	public IngresoEgreso registraIngresoEgreso(IngresoEgreso transaccion) throws CampoVacio {
		if(transaccion.getMontoBs() == 0 && transaccion.getMontoUsd() == 0)
			throw new CampoVacio("monto en bolivianos o dolares");
		
		if(transaccion.getCuentaContable()==null)
			throw new CampoVacio("cuenta contable");
		if(transaccion.getTipoConcepto()==null)
			throw new CampoVacio("concepto");
		
		CuentaContable cuentaContable = cuentaContableDao.buscaCuenta(transaccion.getCuentaContable().getCodigo());
		transaccion.setCuentaContable(cuentaContable);
		Optional<TipoConcepto> optionaTipoConcepto = tipoConceptoDao.findById(transaccion.getTipoConcepto().getIdTipoConcepto());
		TipoConcepto tipoConcepto = optionaTipoConcepto.get();
		transaccion.setTipoConcepto(tipoConcepto);
		
		if(transaccion.getCulto().getIdCulto()!=0) {
			Optional<Culto> optionalCulto = cultoDao.findById(transaccion.getCulto().getIdCulto());
			Culto culto = optionalCulto.get();
			transaccion.setCulto(culto);
		}
		else
			transaccion.setCulto(null);
		
		if(transaccion.getMiembro().getIdMiembro()!=0) {
			Optional<Miembro> optionalMiembro = miembroDao.findById(transaccion.getMiembro().getIdMiembro());
			Miembro miembro = optionalMiembro.get();
			transaccion.setMiembro(miembro);
		}
		else
			transaccion.setMiembro(null);
		
		transaccion.setFechaRegistro(transaccion.getFechaRegistro());
		transaccion.setFechaCreacion(new Date());
		int nroHoja = 0;
		if(transaccion.getTipocuenta().equals("I"))
			nroHoja = this.generaHojaIngreso(transaccion.getTipocuenta(), transaccion.getFechaRegistro());
		else
			nroHoja = this.generaHojaEgreso(transaccion.getTipocuenta(), transaccion.getFechaRegistro());
		transaccion.setHoja(nroHoja);
		transaccion.setEstado(1);
		return ingresoEgresoDao.save(transaccion);
	}
	
	/**
	 * Genera el numero de hoja egreso un incremental, se reinicia al cambiar el año 
	 * */
	private int generaHojaEgreso(String tipoCuenta, Date fechaRegistro) {
		IngresoEgreso ingresoEgreso = ingresoEgresoDao.getMaximoHoja(tipoCuenta);
		int nroHoja = 0;
		if(ingresoEgreso!=null) {
			if(fechaRegistro.getYear()>ingresoEgreso.getFechaRegistro().getYear())
				nroHoja = 1;
			else
				nroHoja = ingresoEgreso.getHoja()+1;
		}
		else
			nroHoja = 1;
		return nroHoja;
	}
	
	/**
	 * Genera el numero de hoja ingreso un incremental
	 * Cuando es el mismo dia se mantiene el numero
	 * se reinicia al cambiar el año 
	 * */
	private int generaHojaIngreso(String tipoCuenta, Date fechaRegistro) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		IngresoEgreso ingresoEgreso = ingresoEgresoDao.getMaximoHoja(tipoCuenta);
		int nroHoja = 0;
		try {
			if(ingresoEgreso!=null) {
				if(fechaRegistro.getYear()>ingresoEgreso.getFechaRegistro().getYear())
					nroHoja = 1;
				else{
					if(formatter.parse(formatter.format(fechaRegistro)).equals(formatter.parse(formatter.format(ingresoEgreso.getFechaRegistro()))))
						nroHoja = ingresoEgreso.getHoja();
					else
						nroHoja = ingresoEgreso.getHoja()+1;
				}
			}
			else
				nroHoja=1;
		}
		catch(Exception e) {
			
		}
		return nroHoja;
	}
	
	@Override
	public IngresoEgreso modificacionIngresoEgreso(IngresoEgreso transaccion) throws CampoVacio, TransaccionNoExiste {
		Optional<IngresoEgreso> optionalIngresoEgreso = ingresoEgresoDao.findById(transaccion.getIdIngresoEgreso());
		if(!optionalIngresoEgreso.isPresent())
			throw new TransaccionNoExiste();
		
		if(transaccion.getMontoBs() == 0 && transaccion.getMontoUsd() == 0)
			throw new CampoVacio("monto en bolivianos o dolares");
		
		if(transaccion.getCuentaContable()==null)
			throw new CampoVacio("cuenta contable");
		if(transaccion.getTipoConcepto()==null)
			throw new CampoVacio("concepto");
		
		IngresoEgreso auxTransaccion = optionalIngresoEgreso.get();
		
		CuentaContable cuentaContable = cuentaContableDao.buscaCuenta(transaccion.getCuentaContable().getCodigo());
		auxTransaccion.setCuentaContable(cuentaContable);
		Optional<TipoConcepto> optionaTipoConcepto = tipoConceptoDao.findById(transaccion.getTipoConcepto().getIdTipoConcepto());
		TipoConcepto tipoConcepto = optionaTipoConcepto.get();
		auxTransaccion.setTipoConcepto(tipoConcepto);
		
		if(transaccion.getCulto().getIdCulto()!=0) {
			Optional<Culto> optionalCulto = cultoDao.findById(transaccion.getCulto().getIdCulto());
			Culto culto = optionalCulto.get();
			auxTransaccion.setCulto(culto);
		}else
			auxTransaccion.setCulto(null);
		
		if(transaccion.getMiembro().getIdMiembro()!=0) {
			Optional<Miembro> optionalMiembro = miembroDao.findById(transaccion.getMiembro().getIdMiembro());
			Miembro miembro = optionalMiembro.get();
			auxTransaccion.setMiembro(miembro);
		}else
			auxTransaccion.setMiembro(null);
		
		if(transaccion.getFechaRegistro()!=null)
			auxTransaccion.setFechaRegistro(transaccion.getFechaRegistro());
				
		auxTransaccion.setMontoBs(transaccion.getMontoBs());
		auxTransaccion.setMontoUsd(transaccion.getMontoUsd());
		
		auxTransaccion.setDescripcion(transaccion.getDescripcion());
		auxTransaccion.setFechaModificacion(new Date());

		return ingresoEgresoDao.save(auxTransaccion);
	}

	@Override
	public boolean eliminacionIngresoEgreso(Long id) {
		Optional<IngresoEgreso> optionalIngresoEgreso = ingresoEgresoDao.findById(id);
		if(!optionalIngresoEgreso.isPresent())
			return false;
		ingresoEgresoDao.deleteById(id);
		return true;
	}

	@Override
	public boolean inactivaEstado(Long id) {
		Optional<IngresoEgreso> optionalIngresoEgreso = ingresoEgresoDao.findById(id);
		if(!optionalIngresoEgreso.isPresent())
			return false;
		IngresoEgreso ingresoEgreso = optionalIngresoEgreso.get();
		ingresoEgreso.setEstado(0);
		ingresoEgresoDao.save(ingresoEgreso);
		return true;
		
	}

}
