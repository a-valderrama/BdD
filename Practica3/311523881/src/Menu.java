import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.IndexOutOfBoundsException;
import java.io.IOException;

/**
 * Clase que crea el menu para el usuario.
 */
public class Menu{

	/**
     * Despliega el menu principal.
     * @return option, la opcion elegida.
     */
	public static void greetings(){
		System.out.println("Bienvenido, desea: \n"+
							"0. Salir\n"+
							"1. Agregar \n"+
							"2. Modificar\n"+
							"3. Eliminar");

	}

	/**
     * Se ejecuta alguna de las opciones posibles
     * @param option, la option del menu a ejecutar
     * @throws InputMismatchException, si la opcion ingresada no es un entero
     * @throws ExceptionOptionInvalid, si la opcion no es valida
     */
	public static void actions (int option) throws InputMismatchException,
		ExceptionOptionInvalid, NumberFormatException, IOException{

		Scanner reader = new Scanner(System.in);
		int choice;
		switch(option){
			case 0: System.out.println("Hasta luego");
					System.exit(0);

			case 1: add();
					choice = reader.nextInt();
					if(choice<0 || choice>2)
						throw new ExceptionOptionInvalid();

					try{
						Add adder = new Add (choice);
					}catch(InputMismatchException e){
						System.err.println("Debe ingresar un entero");
					}catch(ExceptionIdInvalid e){
						System.err.println("Debe ingresar un id valido");
					}catch(ExceptionOptionInvalid e){
						System.err.println("Debe escoger una opcion valida");
					}catch(IOException e){
						System.err.println("Algo salio mal");
					}catch (NumberFormatException e){
						System.err.println("Se debe ingresar un entero");
					}catch (ArrayIndexOutOfBoundsException e){
						System.err.println("Se debe ingresar la direccion completa");
					}
					break;

			case 2: modify();
					choice = reader.nextInt();
					if(choice<0 || choice>2)
						throw new ExceptionOptionInvalid();
					try{
						Modify modify = new Modify(choice);
					}catch(ExceptionIdInvalid e){
						System.err.println("Debe ingresar un id valido");
					}catch(InputMismatchException e){
						System.err.println("Debe ingresar un entero");
					}catch(ExceptionOptionInvalid e){
						System.err.println("Debe escoger una opcion valida");
					}catch(FileNotFoundException e){
						System.err.println("No se encontro el archivo");
					}
					break;

			case 3: eliminate();
					choice = reader.nextInt();
					if(choice<0 || choice>2)
						throw new ExceptionOptionInvalid();
					try{
						Eliminate eliminate = new Eliminate(choice);
					}catch(InputMismatchException e){
						System.err.println("Debe ingresar un entero");
					}catch(ExceptionOptionInvalid e){
						System.err.println("Debe escoger una opcion valida");
					}catch(IOException e){
						System.err.println("Algo salio mal");
					}catch(IndexOutOfBoundsException e){
						System.err.println("El ID ingresado no existe...");
					}
					break;

		}
	}

	/*
	 * Regresa al menu principal
	 */
	public static void  backToPrincipal() throws InputMismatchException, 
		ExceptionOptionInvalid, IOException{

		System.out.println();
		Scanner reader = new Scanner(System.in);
		greetings();
		int op = reader.nextInt();
		actions(op);
	}

	/*
     * Menu de captura
     */
	private static void add(){
		System.out.println("\nQue desea agregar: \n"+
							"0. Regresar al menu principal\n"+
							"1. Dueño \n"+
							"2. Propiedad\n");
	}

	/*
     * Menu de modificacion
     */
	private static void modify(){
		System.out.println("\nQue desea modificar: \n"+
							"0. Regresar al menu principal\n"+
							"1. Dueño \n"+
							"2. Propiedad\n");
	}

	/*
     * Menu de eliminacion
     */
	private static void eliminate(){
		System.out.println("\nQue desea eliminar: \n"+
							"0. Regresar al menu principal\n"+
							"1. Dueño \n"+
							"2. Propiedad\n");
	}
}