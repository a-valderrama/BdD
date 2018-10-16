import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * Clase que establece la direccion de una propiedad
 */
public class Address{
	/*Nombre de la calle*/
	private String street;
	/*Numero exterior*/
	private String number;
	/*Colonia*/
	private String suburb;
	/*Delegacion*/
	private String district;
	/*Codigo postal*/
	private String zc;
	/*Estado*/ 
	private String state;
	/*Ciudad*/
	private String city;
	/*Pais*/
	private String country;
	/*Lista auxiliar para organizar la direecion*/
	private List<String> address;

	/**
	 * Constructor de la clase
	 * @param s, direccion de la propiedad
	 * @throws ArrayIndexOutOfBoundsException, si no se proporciona la 
	 *		   direccion completa
	 */
	public Address(String s) throws ArrayIndexOutOfBoundsException{
		tideAddress(s);
		street = address.get(0);
		number = address.get(1);
		suburb = address.get(2);
		district = address.get(3);
		zc = address.get(4);
		state = address.get(5);
		city = address.get(6);
		country = address.get(7);
	}

	/**
	 * Constructor de la clase, sin parametros.
	 */
	public Address(){
		address = new ArrayList<String>();
	}

	/**
	 * Organiza los datos, necesarios, de la direccion
	 * @param s, los datos necesarios para la propiedad
	 * @throws ArrayIndexOutOfBoundsException, si no se proporciona la 
	 *		   direccion completa
	 */
	public void establishData(String s){	
		address = Arrays.asList(s.split("/"));
		street = address.get(0);
		number = address.get(1);
		suburb = address.get(2);
		district = address.get(3);
		zc = address.get(4);
		state = address.get(5);
		city = address.get(6);
		country = address.get(7);
	}

	/**
	 * Regresa una representacion de la dirrecion en cadena
	 * @return s, representacion de la dirrecion en cadena
	 */
	public String print(){
		String s;
		s = street + "/" + number + "/" + suburb + "/" + district + 
			"/" + zc + "/" + state + "/" + city + "/" + country;
		return s;
	}

	/*
	 * Organiza la direccion, para asi tener el valor por separado
	 * de cada elemento de la direccion
	 */
	private void tideAddress(String s){
		address = Arrays.asList(s.split(","));
	}
}