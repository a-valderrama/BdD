import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Clase que modifica los datos de un dueño o una propiedad.
 */
public class Modify{
	/*generamos un lector global*/
	private Scanner reader;

	/**
	 * Constructor de la clase
	 * @param op, la opcion que se eligio del menu de eliminar.
	 */
	public Modify(int op) throws InputMismatchException, ExceptionIdInvalid,
		ExceptionOptionInvalid, FileNotFoundException, IOException{

		reader = new Scanner(System.in);
		switch(op){
			case 0: Menu.backToPrincipal();
					break;

			case 1: modifyOwnersOptions();
					modifyOwner(reader.nextInt());
					Menu.backToPrincipal();
					break;

			case 2: modifyPropertiesOptions();
					modifyProperty(reader.nextInt());
					Menu.backToPrincipal();
					break;
		}
	}

	/*
	 * Indica la modifiacion que desea realizar
	 */
	private void modifyOwner(int op) throws ExceptionIdInvalid, 
		InputMismatchException, ExceptionOptionInvalid, FileNotFoundException,
		IOException{

		switch(op){
			case 0: Menu.backToPrincipal();
					break;

			case 1: modifyName();
					break;

			case 2: modifyLastName();
					break;
			
			case 3: modifyProperties();
					break;

		}
	}

	/*
	 * Despliega las opciones de las modificaciones a dueños que se pueden 
	 * hacer
	 */
	private void modifyOwnersOptions (){
		System.out.println("Que desas modificar...\n"+
							"0. Regresar al menu principal\n"+
							"1. Nombre\n"+
							"2. Apellidos\n"+
							"3. Lista de propiedades\n");
	}

	/*
	 * Modifica el nombre del dueño.
	 */
	private void modifyName () throws ExceptionIdInvalid, InputMismatchException,
		FileNotFoundException, IOException, UnsupportedEncodingException{

		System.out.println("Ingresa el id del dueño que deseas modificar...");
		int id = reader.nextInt();
		System.out.println("Ingresa el nuevo nombre...");
		String newName = reader.next();

		List<Owner> ownersData = DataManager.ownersData();
		for (Owner o : ownersData) {
			if(o.getId() == id)
				o.setName(newName);
		}
		DataManager.saveOwnersData(ownersData);
	}

	/*
	 * Modifica los apellidos del dueño.
	 */
	private void modifyLastName () throws ExceptionIdInvalid, InputMismatchException,
		FileNotFoundException, IOException, UnsupportedEncodingException{

		System.out.println("Ingresa el id del dueño que deseas modificar...");
		int id = reader.nextInt();
		System.out.println("Ingresa los nuevos apellidos...");
		String newLastName = reader.next();
		newLastName += " " + reader.next();

		List<Owner> ownersData = DataManager.ownersData();
		for (Owner o : ownersData) {
			if(o.getId() == id)
				o.setLastName(newLastName);
		}
		DataManager.saveOwnersData(ownersData);
	}

	/*
	 * Modifica las propiedades del dueño.
	 */
	private void modifyProperties () throws ExceptionIdInvalid, 
		InputMismatchException, FileNotFoundException, IOException{

		System.out.println("Ingresa el id del dueño que deseas modificar...");
		int id = reader.nextInt(), i;
		List<Integer> newProps = new ArrayList<Integer>();
		System.out.println("Ingresa el id de las propiedades que posee "+
							"(ingresar '-1' para terminar)");
		while((i = reader.nextInt()) != -1){
			if(i<0)
				throw new ExceptionIdInvalid();
			newProps.add(i);
		}

		List<Owner> ownersData = DataManager.ownersData();
		for (Owner o : ownersData) {
			if(o.getId() == id)
				o.setPropertiesOwned(newProps);
		}
		DataManager.saveOwnersData(ownersData);
	}

	/*
	 * Despliega las opciones de las modificaciones a propiedades que se pueden
	 * hacer
	 */
	private void modifyPropertiesOptions (){
		System.out.println("Que desas modificar...\n"+
							"0. Regresar al menu principal\n"+
							"1. Direccion\n"+
							"2. Dueños de esta propiedad\n"+
							"3. Antiguedad\n"+
							"4. Tamaño\n"+
							"5. Tipo\n");
	}

	/*
	 * Indica la modifiacion que desea realizar
	 */
	private void modifyProperty(int op) throws ExceptionIdInvalid, 
		InputMismatchException, ExceptionOptionInvalid, FileNotFoundException,
		IOException{

		switch(op){
			case 0: Menu.backToPrincipal();
					break;

			case 1: modifyAddress();
					break;

			case 2: modifyOwners();
					break;
			
			case 3: modifyAntiquity();
					break;

			case 4: modifySize();
					break;

			case 5: modifyType();
					break;
		}
	}

	/*
	 * Modifica la direccion de la propiedad.
	 */
	private void modifyAddress () throws ExceptionIdInvalid, InputMismatchException,
		FileNotFoundException, IOException, UnsupportedEncodingException{

		System.out.println("Ingresa el id de la propiedad que deseas modificar...");
		int id = reader.nextInt();
		System.out.println("Ingresa la nueva direccion..."+
							"\nFormato: Calle, numero, colonia, "+
							"delegacion, codigo postal, estado, ciudad, pais");
		String newAddress;
		do{
			if(reader.hasNextLine());
				newAddress = reader.nextLine();
		}while(newAddress.equals(""));

		List<Property> propertysData = DataManager.propertysData();
		for (Property p : propertysData) {
			if(p.getId() == id)
				p.setAddress(newAddress);
		}
		DataManager.savePropertysData(propertysData);
	}

	/*
	 * Modifica los dueños de la propiedad.
	 */
	private void modifyOwners () throws ExceptionIdInvalid, 
		InputMismatchException, FileNotFoundException, IOException{

		System.out.println("Ingresa el id de la propiedad que deseas modificar...");
		int id = reader.nextInt(), i;
		List<Integer> newOwners = new ArrayList<Integer>();
		System.out.println("Ingresa el id de los dueños que la poseen "+
							"(ingresar '-1' para terminar)");
		while((i = reader.nextInt()) != -1){
			if(i<0)
				throw new ExceptionIdInvalid();
			newOwners.add(i);
		}

		List<Property> propertysData = DataManager.propertysData();
		for (Property p : propertysData) {
			if(p.getId() == id)
				p.setValidOwners(newOwners);
		}
		DataManager.savePropertysData(propertysData);
	}

	/*
	 * Modifica la antiguedad de la propiedad.
	 */
	private void modifyAntiquity () throws ExceptionIdInvalid, InputMismatchException,
		FileNotFoundException, IOException, UnsupportedEncodingException{

		System.out.println("Ingresa el id de la propiedad que deseas modificar...");
		int id = reader.nextInt();
		System.out.println("Ingresa la nueva antiguedad...");
		int newAntiquity = reader.nextInt();

		List<Property> propertysData = DataManager.propertysData();
		for (Property p : propertysData) {
			if(p.getId() == id)
				p.setAntiquity(newAntiquity);
		}
		DataManager.savePropertysData(propertysData);
	}

	/*
	 * Modifica el tamaño de la propiedad.
	 */
	private void modifySize () throws ExceptionIdInvalid, InputMismatchException,
		FileNotFoundException, IOException, UnsupportedEncodingException{

		System.out.println("Ingresa el id de la propiedad que deseas modificar...");
		int id = reader.nextInt();
		System.out.println("Ingresa el nuevo tamaño (m2)...");
		int newSize = reader.nextInt();

		List<Property> propertysData = DataManager.propertysData();
		for (Property p : propertysData) {
			if(p.getId() == id)
				p.setSize(newSize);
		}
		DataManager.savePropertysData(propertysData);
	}

	/*
	 * Modifica el tipo de la propiedad.
	 */
	private void modifyType () throws ExceptionIdInvalid, InputMismatchException,
		FileNotFoundException, IOException, UnsupportedEncodingException{

		System.out.println("Ingresa el id de la propiedad que deseas modificar...");
		int id = reader.nextInt();
		System.out.println("Ingresa el nuevo tipo...");
		String newType = reader.next();

		List<Property> propertysData = DataManager.propertysData();
		for (Property p : propertysData) {
			if(p.getId() == id)
				p.setType(newType);
		}
		DataManager.savePropertysData(propertysData);
	}
}