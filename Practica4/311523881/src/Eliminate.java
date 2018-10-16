import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.lang.IndexOutOfBoundsException;

/**
 * Clase que elimina los datos de un dueño o una propiedad del archivo
 * correspondiente.
 */
public class Eliminate{
	/*generamos un lector global*/
	private Scanner reader;

	/**
	 * Constructor de la clase
	 * @param op, la opcion que se eligio del menu de eliminar.
	 */
	public Eliminate(int op) throws InputMismatchException, 
		ExceptionOptionInvalid, FileNotFoundException, IOException, 
		IndexOutOfBoundsException{

		reader = new Scanner(System.in);
		switch(op){
			case 0: Menu.backToPrincipal();
					break;

			case 1: removeOwner(ownerToRemove());
					Menu.backToPrincipal();
					break;

			case 2: removeProperty(propertyToRemove());
					Menu.backToPrincipal();
					break;
		}
	}

	/*
	 * Nos dice que dueño tenemos que remover
	 */
	private int ownerToRemove () throws InputMismatchException{
		System.out.println("Indica el id del dueño que quieres remover...");
		return reader.nextInt();
	}

	/*
	 * Nos dice que dueño tenemos que remover
	 */
	private int propertyToRemove () throws InputMismatchException{
		System.out.println("Indica el id de la propiedad que quieras remover...");
		return reader.nextInt();
	}

	/*
	 * Remueve al dueño en cuestion
	 */
	private void removeOwner(int id) throws FileNotFoundException, IOException,
		UnsupportedEncodingException, IndexOutOfBoundsException{

		int index = 0;
		Owner removed = new Owner();
		List<Owner> ownersData = DataManager.ownersData();
		for (Owner o : ownersData) {
			if(o.getId() == id)
				break; 
			index++;
		}
		removed = ownersData.remove(index);
		System.out.println("\nEl dueño: \n" + removed.print() +
							"\nHa sido removido.\n");
		DataManager.saveOwnersData(ownersData);

		removeOwnerFromProperties(id);
	}

	/*
	 * Remueve al dueño, en cuestion, de todas las propiedades que posee
	 */
	private void removeOwnerFromProperties(Integer id) throws FileNotFoundException,
		IOException{

		List<Property> propertysData = DataManager.propertysData();
		List<Integer> aux = new ArrayList<Integer>();
		for (Property p : propertysData) {
			aux = p.getOwners();
			aux.remove(id);
			System.out.println(aux);
		}
		DataManager.savePropertysData(propertysData);
	}

	/*
	 * Remueve a la propiedad en cuestion
	 */
	private void removeProperty (int id) throws FileNotFoundException, IOException,
		UnsupportedEncodingException, IndexOutOfBoundsException{

		int index = 0;
		Property removed = new Property();
		List<Property> propertysData = DataManager.propertysData();
		for (Property p : propertysData) {
			if(p.getId() == id)
				break;
			index++;
		}
		removed = propertysData.remove(index);
		System.out.println("\nLa propiedad: \n" + removed.print() +
							"\nHa sido removido.\n");
		DataManager.savePropertysData(propertysData);

		removePropertyFromOwners(id);		
	}

	/*
	 * Remueve a la propiedades, en cuestion, de todos los dueños que la poseen
	 */
	private void removePropertyFromOwners(Integer id) throws FileNotFoundException,
		IOException{

		List<Owner> ownersData = DataManager.ownersData();
		List<Integer> aux = new ArrayList<Integer>();
		for (Owner o : ownersData) {
			aux = o.getPropertiesOwned();
			aux.remove(id);
		}
		DataManager.saveOwnersData(ownersData);
	}
}