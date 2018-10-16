import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.NumberFormatException;

/**
 * Clase que determina las caracteristicas del dueño
 */
public class Owner{
	/*El id, unico, del dueño*/
	private int id;
	/*El nombre del dueño*/
	private String name;
	/*Los apellidos del dueño*/
	private String lastName;
	/*Propiedades que posee*/
	private List<Integer> idProps;
	/*Instancia que asigna, adecuadamente, el id del dueño*/
	private Assigner assigner;

	/**
	 * Constructor de la clase. Este se usara para crear objetos, de tipo 
	 * owner, con base en informacion dada
	 * @param s, todos los datos que debe tener el dueño
	 */
	public Owner(String s){
		List<String> tokens = new ArrayList<String>();
		tokens = Arrays.asList(s.split(","));
		String str = tokens.get(0);
		if(!tokens.get(0).equals(""))
			id = Integer.valueOf(tokens.get(0));
		name = tokens.get(1);
		lastName = tokens.get(2);
		s = s.substring(s.indexOf('[')+1,s.indexOf(']'));
		tokens = Arrays.asList(s.split(","));
		idProps = new ArrayList<Integer>();
		normalizeIdProps(tokens);
	}

	/**
	 * Constructor de la clase, sin parametros
	 */
	public Owner(){
		assigner = new Assigner("owner");
		id = assigner.getId();
	}

	/**
	 * Establece el nombre del dueño
	 * @param name, nombre del dueño
	 */
	public void setName (String name){
		this.name = name;
	}

	/**
	 * Establece los apellidos del dueño
	 * @param lastName, apellidos del dueño
	 */
	public void setLastName (String lastName){
		this.lastName = lastName;
	}

	/**
	 * Establece las propiedades que posee
	 * @param props, lista de los id's de las propiedades
	 */
	public void setPropertiesOwned (List<Integer> props){
		idProps = props;
	}

	/**
	 * Regresa las propiedades que posee
	 * @return idProps, lista de las propiedades que posee
	 */
	public List<Integer> getPropertiesOwned (){
		return idProps;
	}

	/**
	 * Regresa el id del dueño
	 * @return id, id del dueño
	 */
	public int getId (){
		return id;
	}

	/**
	 * Regresa la representacion, en cadena, del dueño
	 * @return s, la representacion del dueño.
	 */
	public String print(){
		String s;
		s = id + "," + name + "," + lastName + "," + printProps();
		return s;
	}

	/*
	 * Establece los id's con el tipo correspondiente
	 */
	private void normalizeIdProps(List<String> list) throws 
		NumberFormatException{

		for (String s : list) {
			if(!s.equals(""))
				idProps.add(Integer.valueOf(s));
		}
	}

	/*
	 * Regresa una representacion de la lista.
	 */
	private String printProps(){
		if(idProps.isEmpty())
			return "[]";
		String s="[";
		for (int i : idProps) {
			s += i + ",";
		}
		s = s.substring(0,s.length()-1);
		return s + "]";
	}
}