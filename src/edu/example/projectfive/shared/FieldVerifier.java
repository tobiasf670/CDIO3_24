package edu.example.projectfive.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client-side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 * 
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
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
