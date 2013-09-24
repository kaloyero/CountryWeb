package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.form.InfraccionForm;
import com.country.hibernate.dao.InfractionDao;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Infraccion;
import com.country.hibernate.model.LiquidacionCargo;
import com.country.hibernate.model.Tarifa;
import com.country.hibernate.model.Unidad;
import com.country.hibernate.model.UnidadConcepto;
import com.country.mappers.InfraccionMapper;
import com.country.services.ConceptUnitManager;
import com.country.services.InfractionManager;
import com.country.services.LiquidationChargeManager;
import com.country.services.PriceManager;
import com.country.services.TypeInfractionManager;
import com.country.session.SessionUsr;

@Service("infractionManager")
public class InfractionManagerImpl extends AbstractManagerImpl<Infraccion> implements InfractionManager{

	@Autowired
    private InfractionDao infractionDao;
	
	@Autowired
    private PriceManager priceManager;
	
	@Autowired
    private TypeInfractionManager typeInfractionManager;

	
	@Autowired
    private ConceptUnitManager conceptUnitManager;

	@Autowired
    private LiquidationChargeManager liquidationChargeManager;

	
	protected GenericDao<Infraccion, Integer> getDao() {
		return infractionDao;
	}

	@Transactional
	private Infraccion findById(Integer id) {
		Infraccion dto = infractionDao.findById(id);
		return dto;
	}

	
	@Transactional
	public InfraccionForm findFormById(Integer id) {
		InfraccionForm form = new InfraccionForm();
		
		Infraccion infraccion = findById(id);
		//Toma la ultima tarifa
		Tarifa tarifa = priceManager.getLastPriceByConcept(infraccion.getTipoInfraccion().getConcepto().getId());
		
		form = (InfraccionForm) InfraccionMapper.getForm(infraccion, tarifa);
		return form;	
	}

	@Transactional
	public void save(InfraccionForm form) {
		Infraccion entity = InfraccionMapper.getInfraccion(form);
		
		infractionDao.save(entity);
		
		/* Agrego el cargo a la unidad y el cargo a liquidar */
		
		Concepto concepto = new Concepto();
		concepto.setId(typeInfractionManager.findById(entity.getTipoInfraccion().getId()).getConcepto().getId());
		Unidad unit = new Unidad();
		unit.setId(form.getUnidadId());
		//UNIDAD CONCEPTO
		UnidadConcepto unitConcept =new UnidadConcepto();
		unitConcept.setConcepto(concepto);
		unitConcept.setFechaComienzo(DateUtil.convertStringToDate(form.getFecha()));
		unitConcept.setFechaFin(null);
		unitConcept.setUnidad(unit);
		conceptUnitManager.save(unitConcept);
		//LIQUIDACION CARGO
		LiquidacionCargo liqCharge =new LiquidacionCargo();
		liqCharge.setConcepto(concepto);
		liqCharge.setFecha(DateUtil.convertStringToDate(form.getFecha()));
		liqCharge.setInfraccion(entity);
		liqCharge.setMonto(entity.getMonto());
		liqCharge.setUnidad(entity.getUnidad());
		liqCharge.setUnidadconcepto(unitConcept);
		liquidationChargeManager.save(liqCharge);
		/* FIN Agrego el cargo a la unidad y el cargo a liquidar */

		
	}

	@Transactional
	public void update(InfraccionForm form) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public List<InfraccionForm> listAllForms() {
		List<InfraccionForm> list = new ArrayList<InfraccionForm>();
		List<Infraccion> infracciones = infractionDao.findAll(false);
		Tarifa tarifa ;
		
		for (Infraccion infraccion : infracciones) {
			//Toma la ultima tarifa
			tarifa = priceManager.getLastPriceByConcept(infraccion.getTipoInfraccion().getConcepto().getId());

			InfraccionForm form = (InfraccionForm) InfraccionMapper.getForm(infraccion, tarifa);

			list.add(form);
		}
		return list;

	}	

	
	public Integer getNumInfraccionesByUnidad(){
		return infractionDao.getNumInfraccionesByUnidad(SessionUsr.User().getUnidad().getId());
		
	}
}
