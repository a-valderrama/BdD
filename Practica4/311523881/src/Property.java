import java.util.ArrayList;
import java.util.List;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Arrays;

/**
 * Clase que determina las caracteristicas de la propiedad
 */
public class Property{
	/*El id, unico, de la propiedad*/
	private int id;
	/*La direccion de la propiedad*/
	private Address address;
	/*lista de los dueños de esta propiedad*/
	private List<Integer> owners;
	/*Antiguedad de la propiedad*/
	private int antiquity;
	/*Tamaño de la propiedad*/
	private int size;
	/*Tipo de la propiedad*/
	private String type;
	/*Instancia que asigna, adecuadamente, el id de la propiedad*/
	private Assigner assigner;

	/**
	 * Constructor de la clase. Este se usara para crear objetos, de tipo 
	 * owner, con base en informacion dada
	 * @param s, todos los datos que debe tener la propiedad
	 */
	public Property(String s){
		List<String> tokens = new ArrayList<String>();
		String str = s.substring(s.indexOf('[')+1,s.indexOf(']'));
		s = s.substring(0,s.indexOf('[')) + s.substring(s.indexOf(']')+1, s.length());
		tokens = Arrays.asList(s.split(","));
		if(!tokens.get(0).equals(""))
			id = Integer.valueOf(tokens.get(0));
		address = new Address ();
		address.establishData(tokens.get(1));
		antiquity = Integer.valueOf(tokens.get(3));
		size = Integer.valueOf(tokens.get(4));
		type = tokens.get(5);
		tokens = Arrays.asList(str.split(","));
		owners = new ArrayList<Integer>();
		normalizeOwners(tokens);
	}

	/**
	 * Constructor de la clase, sin parametros
	 */
	public Property(){
		assigner = new Assigner("prop");
		id = assigner.getId();
	}

	/**
	 * Regresa el id del dueño
	 * @return id, id del dueño
	 */
	public int getId (){
		return id;
	}

	/**
	 * Establece la direccion de la propiedad.
	 * @param s, la direccion de la propiedad.
	 * @throws ArrayIndexOutOfBoundsException, si no se proporciona la 
	 *		   direccion completa
	 */
	public void setAddress(String s) throws ArrayIndexOutOfBoundsException{
		address = new Address(s);
	}

	/**
	 * Hace lo mismo que setAddress, pero recibe una string con oto formato
	 * @param s, la direccion de la propiedad
	 */
	public void establishAddress(String s) throws ArrayIndexOutOfBoundsException{
		address = new Address();
		address.establishData(s);
	}

	/**
	 * Establece los dueños de esta propiedad
	 * @param owners, los dueños de esta propiedad
	 */
	public void setValidOwners (List<Integer> owners){
		this.owners = owners;
	}

	/**
	 * Establece la antiguedad de la propiedad
	 * @param antiguedad, la antiguedad de la propiedad
	 */
	public void setAntiquity(int antiquity){
		this.antiquity = antiquity;
	}

	/**
	 * Establece el tamaño de la propiedad
	 * @param size, el tamaño de la propiedad
	 */
	public void setSize (int size){
		this.size = size;
	}

	/**
	 * Establece el tipo de la propiedad
	 * @param type, el tipo de la propiedad
	 */
	public void setType (String type){
		this.type = type;
	}

	/**
	 * Regresa todos los dueños de esta propiedad
	 * @return owner, todos los dueños de esta propiedad
	 */
	public List<Integer> getOwners (){
		return owners;
	}


	/**
	 * Regresa la representacion, en cadena, de la propiedad
	 * @return s, la representacion, en cadena, de la propiedad.
	 */
	public String print(){
		String s;
		s = id + "," + address.print() + "," + printOwners() +  "," + 
			antiquity + "," + size + "," + type;
		return s;
	}

	/*
	 * Establece los los dueños de esta propiedad
	 */
	private void normalizeOwners(List<String> list) throws 
		NumberFormatException{

		for (String s : list) {
			if(!s.equals(""))
				owners.add(Integer.valueOf(s));
		}
	}

	/*
	 * Regresa una representacion de la lista.
	 */
	private String printOwners(){
		if(owners.isEmpty())
			return "[]";
		String s="[";
		for (int i : owners) {
			s += i + ",";
		}
		s = s.substring(0,s.length()-1);
		return s + "]";
	}
}