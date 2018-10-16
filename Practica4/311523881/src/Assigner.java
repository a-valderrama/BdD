import java.io.File;
import java.io.IOException;


/**
 * Clase asigna los id's correspondientes (sea propiedad o dueño)
 */
public class Assigner{
	/*El id que se asignara*/
	private int id;
	
	/**
	 * Constructor de la clase
	 * @param type, a que tipo se le asignara el id
	 */
	public Assigner (String type){
		if(type.equals("owner"))
			assignId(1);
		else
			assignId(2);
	}

	/**
	 * Regresa el id
	 * @return id, el id.
	 */
	public int getId(){
		return id;
	}

	/*
	 * Funcion auxiliar que lee el archivo, correspondiente para 
	 * verificar el id por asignar.
	 * Nota: i = 1 -> dueño
	 *		 i = 2 -> propiedad
	 */
	private void assignId (int i){
		switch(i){
			case 1:	File f = new File("dueños.csv");
					try{
						if(f.exists() && !f.isDirectory())
				    		id = DataManager.nextValidId(1);
						else
							id = 0;
					}catch(IOException e){
						System.err.println("Hubo un problema al leer el archivo");
					}
					break;
			case 2: File f1 = new File("propiedades.csv");
					try{
						if(f1.exists() && !f1.isDirectory())
				    		id = DataManager.nextValidId(2);
						else
							id = 0;
					}catch(IOException e){
						System.err.println("Hubo un problema al leer el archivo");
					}
					break;
		}
	}	
}