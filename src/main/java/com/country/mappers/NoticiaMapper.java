package com.country.mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.country.common.DateUtil;
import com.country.form.Form;
import com.country.form.NoticiaForm;
import com.country.hibernate.model.Noticia;
import com.country.hibernate.model.NoticiaAdjunto;
import com.country.hibernate.model.NoticiaCategorias;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class NoticiaMapper {

	public static Noticia getNoticia(Form form)
			throws ParseException {
		
		Noticia	dto = new Noticia();
		dto.setId(((NoticiaForm) form).getId());
		dto.setEstado(((NoticiaForm) form).getEstado());
		dto.setFecha(DateUtil.convertStringToDate(((NoticiaForm) form).getFecha()));
		NoticiaCategorias notCat = new NoticiaCategorias();
		notCat.setId(((NoticiaForm) form).getCategoria());
		dto.setCategoria(notCat);
		dto.setFechaDesde(DateUtil.convertStringToDate(((NoticiaForm) form).getFechaDesde()));
		dto.setFechaHasta(DateUtil.convertStringToDate(((NoticiaForm) form).getFechaHasta()));
		dto.setTexto(((NoticiaForm) form).getTexto());
		dto.setTitulo(((NoticiaForm) form).getTitulo());
		
//		Map<Integer,String> list = new HashMap<Integer, String>();
//		list.put(1, "sara");
//		list.put(2, "zaza");
//		((NoticiaForm) form).setAdjuntos(list);
		
		dto.setAdjuntos(setAdjuntos(((NoticiaForm) form).getAdjuntos(),((NoticiaForm) form).getId()));
		
		return dto;
	
	}
	
	public static NoticiaForm getForm(Noticia dto)
			throws ParseException {
		
		NoticiaForm form=new NoticiaForm();
		form.setId(dto.getId());
		form.setCategoria(dto.getCategoria().getId());
		form.setEstado(dto.getEstado());
		form.setFecha(DateUtil.convertDateToString(dto.getFecha()));
		form.setFechaDesde(DateUtil.convertDateToString(dto.getFechaDesde()));
		form.setFechaHasta(DateUtil.convertDateToString(dto.getFechaHasta()));
		form.setTexto(dto.getTexto());
		form.setTitulo(dto.getTitulo());
		form.setAdjuntos(getAdjuntos(dto.getAdjuntos()));
		
		
		return form;
	
	}

	private static Map<Integer, String> getAdjuntos(List<NoticiaAdjunto> adjuntos) {
		Map<Integer, String> lista = new HashMap<Integer, String>();
		for (NoticiaAdjunto newAtt : adjuntos) {
			lista.put(newAtt.getId(), newAtt.getAdjunto());
		}
		
		return lista;
	}

	private static List<NoticiaAdjunto> setAdjuntos(Map<Integer, String> adjuntos, int idNoticia) {
		List<NoticiaAdjunto> adj = new ArrayList<NoticiaAdjunto>();
			
		Iterator it = adjuntos.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry element = (Map.Entry) it.next();
			NoticiaAdjunto dto = new NoticiaAdjunto();
			
			dto.setId((Integer) element.getKey());
			dto.setAdjunto((String) element.getValue());
			dto.setNoticia(idNoticia);
			
			adj.add(dto);
		}
			return adj;
			
	}

}
