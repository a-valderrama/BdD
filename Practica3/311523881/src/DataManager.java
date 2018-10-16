import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Clase que se encarga de la interaccion con los datos, en los archivos 
 */
public class DataManager{
	/*Contiene la informacion de todos los dueños*/
	private List<String> listOwners;

	/**
	 * Constructor de la clase
	 */
	public DataManager(){
		listOwners = new ArrayList<String>();
	}

	/**
	 * Checa el numero de dueños en el archivo, para asi establecer
	 * un id valido
	 * @return i, el siguiente id valido
	 */
	public static int nextValidId(int op) throws IOException{
		switch(op){
			case 1: return ownerId();

			case 2: return propId();
		}
		//this case never happens
		return 0;
	}

	/**
	 * Crea o abre el archivo, dueños.csv, y agrega el nuevo dueño.
	 * @param owner, el dueño que se agregara
	 */
	public static void addOwner(Owner owner) throws IOException, 
		FileNotFoundException{
			
		if(owner.getId() == 0){
			File file = new File("dueños.csv");
			PrintWriter writer = new PrintWriter("dueños.csv", "UTF-8");
			writer.println(owner.print());
			writer.close();
			return;
		}
		//el valor de verdad provoca que se agregue al final del archivo
        FileWriter fw = new FileWriter("dueños.csv",true); 
    	fw.write("\n" + owner.print());
    	fw.close();
	}

	/**
	 * Crea o abre el archivo, propiedades.csv, y agrega la nueva propiedad.
	 * @param property, la propiedad que se agregara
	 */
	public static void addProperty(Property property) throws IOException, 
		FileNotFoundException{
			
		if(property.getId() == 0){
			File file = new File("propiedades.csv");
			PrintWriter writer = new PrintWriter("propiedades.csv", "UTF-8");
			writer.println(property.print());
			writer.close();
			return;
		}
		//el valor de verdad provoca que se agregue al final del archivo
        FileWriter fw = new FileWriter("propiedades.csv",true); 
    	fw.write("\n" + property.print());
    	fw.close();
	}

	/**
	 * Regresa la informacion de todos los dueños
	 * @return ownersData, la informacion de todos los dueños
	 * @throws FileNotFoundException, el archivo no existe
	 * @throws IOException
	 */
	public static List<Owner> ownersData() throws FileNotFoundException, IOException{
		List<Owner> ownersData = new ArrayList<Owner>();
		Owner owner;
		String line;
		BufferedReader in =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("dueños.csv")));
        while ((line = in.readLine()) != null){
        	owner = new Owner(line);
        	ownersData.add(owner);
        }
        return ownersData;
	}

	/**
	 * Regresa la informacion de todas las propiedades
	 * @return propertysData, la informacion de todas las propiedades
	 * @throws FileNotFoundException, el archivo no existe
	 * @throws IOException
	 */
	public static List<Property> propertysData() throws FileNotFoundException, IOException{
		List<Property> propertysData = new ArrayList<Property>();
		Property property;
		String line;
		BufferedReader in =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("propiedades.csv")));
        while ((line = in.readLine()) != null){
        	property = new Property(line);
        	propertysData.add(property);
        }
        return propertysData;
	}

	/**
	 * Guarda la informacion, actualizada, de los dueños.
	 * @param ownersData, la informacion de todos los dueños, actualizada
	 */
	public static void saveOwnersData(List<Owner> ownersData) throws 
		FileNotFoundException, UnsupportedEncodingException{

		File file = new File("dueños.csv");
		PrintWriter writer = new PrintWriter("dueños.csv", "UTF-8");
		for (Owner o : ownersData) {
			writer.println(o.print());	
		}
		writer.close();
		return;
	}

	/**
	 * Guarda la informacion, actualizada, de las propiedades.
	 * @param propertysData, la informacion de todas las propiedades, actualizada.
	 */
	public static void savePropertysData(List<Property> propertysData) throws 
		FileNotFoundException, UnsupportedEncodingException{

		File file = new File("propiedades.csv");
		PrintWriter writer = new PrintWriter("propiedades.csv", "UTF-8");
		for (Property p : propertysData) {
			writer.println(p.print());	
		}
		writer.close();
		return;
	}

	/*
	 * Auxiliar para determinar el id del dueño
	 */
	private static int ownerId() throws FileNotFoundException, IOException{
		String line, last="";
		int i = 0;
		BufferedReader in =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("dueños.csv")));
	    while ((line = in.readLine()) != null)
	    	last = line;
	    Owner owner = new Owner(last);
		return owner.getId()+1;
	}

	/*
	 * Auxiliar para determinar el id de la propiedad
	 */
	private static int propId() throws FileNotFoundException, IOException{
		String line;
		int i = 0;
		BufferedReader in =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("propiedades.csv")));
	    while ((line = in.readLine()) != null)
	        i++;
	    return i;
	}
}