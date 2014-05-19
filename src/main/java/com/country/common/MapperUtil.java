package com.country.common;


public class MapperUtil {

	/**
	 * Este metodo trae S o N, segun reciva true(S) o false(N) 
	 * 
	 * @param value
	 * @return
	 */
	public static boolean getStatusForm(String value) {
		boolean result = false;
		
		if (Constants.TRUE.equals(value)){
			result = true;	
		} else {
			result = false;
		}
		
		return result;
	}    

	/**
	 * Este metodo trae true o false, segun reciva S(true) o N(false)
	 * 
	 * @param value
	 * @return
	 */
	public static String getStatusEntity(boolean value) {
		String result = Constants.FALSE;
		
		if (value){
			result = Constants.TRUE;
		} else {
			result = Constants.FALSE;
		}
		
		return result;
	}    

	public static boolean getStatusUserForm(String value) {
		boolean result = false;
		
		if (Constants.PERSONA_EMPLEADO.equals(value)){
			result = true;	
		} else {
			result = false;
		}
		
		return result;
	}    

	public static String getStatusUserEntity(boolean value) {
		String result = Constants.PERSONA_INTEGRANTE;
		
		if (value){
			result = Constants.PERSONA_EMPLEADO;
		} else {
			result = Constants.PERSONA_INTEGRANTE;
		}
		
		return result;
	}  
	
	public static boolean getStatusValueForm(String value,String CompareTrue) {
		boolean result = false;
		
		if (CompareTrue.equals(value)){
			result = true;	
		} else {
			result = false;
		}
		
		return result;
	}    
	
	public static String getStatusValueEntity(boolean value,String CompareTrue,String CompareFalse) {
		String result = CompareFalse;
		
		if (value){
			result = CompareTrue;
		} else {
			result = CompareFalse;
		}
		
		return result;
	}    

    
}
