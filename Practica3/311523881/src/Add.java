import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * Clase que agrega/captura los datos de un dueño o una propiedad al archivo
 * correspondiente.
 */
public class Add{
	/*utilizamos el manejador de datos*/
	private DataManager dataManager;
	/*dueño, temporal, que agregaremos*/
	private Owner owner;
	/*generamos un lector global*/
	private Scanner reader;
	/*Propiedad, temporal, que agregaremos*/
	private Property property;

	/**
     * Constructor de la clase
     * @param i, la opcion que se eligio del menu de agregar.
     */
	public Add(int i) throws InputMismatchException, ExceptionIdInvalid,
		ExceptionOptionInvalid, IOException, NumberFormatException,
		ArrayIndexOutOfBoundsException{

		reader = new Scanner(System.in);
		switch(i){
			case 0: Menu.backToPrincipal();
					break;

			case 1: addOwner();
					Menu.backToPrincipal();
					break;

			case 2: addProperty();
					Menu.backToPrincipal();
					break;
		}
	}

	/*
     * Solicita la informacion, necesaria, para agregar a un dueño.
     */
	private void addOwner () throws InputMismatchException, 
		ExceptionIdInvalid, IOException{

		owner = new Owner();
		int i;
		String s;
		List<Integer> props = new ArrayList<Integer>();

		System.out.println("Por favor ingresa los siguientes datos ("+
							"ingresar la bandera '-j' si no desea "+
							"porporcionar esa informacion):\n");
		owner.setName(nameOwner());

		System.out.println("-Apellidos: ");
		s = reader.next();
		if(s.equals("-j"))
			owner.setLastName(null);
		else{
			s += " "+reader.next();
			owner.setLastName(s);
		}

		System.out.println("\n-El id de las propiedades que posee "+
							"(ingresar '-1' para terminar)");
		while((i = reader.nextInt()) != -1){
			if(i<0)
				throw new ExceptionIdInvalid();
			props.add(i);
		}
		owner.setPropertiesOwned(props);

		DataManager.addOwner(owner);
	}

	/*
	 * No permite que el campo del nombre, del dueño, quede vacio
	 */
	private String nameOwner(){
		String s;
		do{
			System.out.println("-Nombre del dueño (obligatorio):");
			s = reader.next();
		}while(s.equals("-j"));
		return s;
	}

	/*
     * Solicita la informacion, necesaria, para agregar a una propiedad.
     */
	private void addProperty () throws  ExceptionIdInvalid, IOException, 
		NumberFormatException, ArrayIndexOutOfBoundsException{

		property = new Property();
		int i;
		String s;

		System.out.println("Por favor ingresa los siguientes datos ("+
							"ingresar la bandera '-j' si no desea "+
							"porporcionar esa informacion):\n");
		s = propAddress();
		property.setAddress(s);

		List<Integer> owners = new ArrayList<Integer>();
		System.out.println("\n-El id de los dueños que la poseen"+
							"(ingresar '-1' para terminar)");
		while((i = reader.nextInt()) != -1){
			if(i<0)
				throw new ExceptionIdInvalid();
			owners.add(i);
		}
		property.setValidOwners(owners);

		System.out.println("\n-Antiguedad de la propiedad (años): ");
		s = reader.next();
		if(!s.equals("-j"))
			property.setAntiquity(Integer.parseInt(s));

		System.out.println("\n-Tamaño de la propiedad (m2)");
		s = reader.next();
		if(!s.equals("-j"))
			property.setSize(Integer.parseInt(s));

		System.out.println("\n-Tipo de la propiedad");
		s = reader.next();
		if(!s.equals("-j"))
			property.setType(s);
		else
			property.setType(null);

		DataManager.addProperty(property);
	}

	/*
	 * No permite que el campo de direccion, de la propiedad, quede vacio
	 */
	private String propAddress(){
		String s = "-j";
		do{
			System.out.println("-Direccion de la propiedad (obligatorio)."+
								"\nFormato: Calle, numero, colonia, "+
								"delegacion, codigo postal, estado, ciudad, pais");
			if(reader.hasNextLine());
				s = reader.nextLine();
		}while(s.equals("-j"));
		return s;
	}
}