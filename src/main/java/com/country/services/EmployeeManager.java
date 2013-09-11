package com.country.services;

import com.country.hibernate.model.Empleado;

public interface EmployeeManager extends AbstractManager<Empleado>{
	
	/**
	 * Este metodo devuelve el empleado filtrando por el userId
	 * 
	 * @param userId
	 * @return
	 */
	public Empleado getEmployeeByIdUser(int userId);
}
