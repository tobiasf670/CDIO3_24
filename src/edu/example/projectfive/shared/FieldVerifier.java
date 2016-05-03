package edu.example.projectfive.shared;

import edu.example.projectfive.client.service.PersonServiceClientImpl;

//Denne klasse er taget fra kursets google drive mappe.
public class FieldVerifier {

	PersonServiceClientImpl clientImpl;
	
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		if (name.length() == 0)
			return false;
		// max 30 karakterer
		return name.length() <= 30;
	}
	
	public static boolean isValidOprId(String id){
		if (id.matches ("\\d")|| id.matches ("\\d\\d") ) {
            return true ;
        }
		else return false ;
	}
	public static boolean isValidIni(String Ini){
		if (Ini.length() == 2){
			return true;
		}
		else return false;
	}
	
	public static boolean isValidCpr (String cpr){
		String subs1 = cpr.substring(0, 6);
		String subs2 = cpr.substring(7, 11);
		String subs3 = cpr.substring(6,7);
		
		if(cpr.length()>11){
			return false;
		}
		if(!subs1.matches("\\d\\d\\d\\d\\d\\d")){
			return false;
		}
		if (!subs2.matches("\\d\\d\\d\\d")){
			return false;
		}
		if (!subs3.matches("\\W")){
			return false;
		}
		return true;
	}
	
	public static boolean isVaildPassword (String password){
		if (password.length() == 0){
			return false;
		}
		else  return true;
	}
	
	public static boolean isValidRolle(String rolle) {
		if (rolle.equals("true") || rolle.equals("false"))
			// max 100 år
			return true;
		else
			return false;	
	}
}
