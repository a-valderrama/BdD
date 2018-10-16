import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

public class Practica2{
	public static void main (String[] args){
		Scanner reader = new Scanner(System.in);

		Menu.greetings();
		try{
			int option = reader.nextInt();
			if(option<0 || option>3)
				System.err.println("Se debe ingresar una opcion valida");
			Menu.actions(option);
		}catch(InputMismatchException e){
			System.err.println("Se debe ingresar un entero");
		}catch(ExceptionOptionInvalid e){
			System.err.println("Se debe ingresar una opcion valida");
		}catch(IOException e){
			System.err.println("Algo salio mal");
		}
		
	}
}	