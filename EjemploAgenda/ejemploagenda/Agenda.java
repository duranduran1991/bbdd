/*
 * agenda: Programa principal.
 */


package ejemploagenda;



import java.io.*;
import java.util.*;
import bbdd.BD_Conector;
import modelos.Contacto;
import bbdd.*;
public class Agenda {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int opc=0;
		String nombre="",telefono="",apellidos="";
		Contacto ct;
		BD_Agenda bd=new BD_Agenda("agenda");
		
		do	
		{
			System.out.println("\n1.Nuevo Contacto\n2.Borrar Contacto\n3.Consultar tel�fono\n4.Mostrar contactos\n5. Salir");
			try{
			opc=Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException e ){
				System.out.println("Opcion incorrecta");
				opc=0;
			}
			catch (IOException e){
				System.out.println(e.getMessage());
				System.exit(0);
			}
				
			switch (opc){
			case 1:			
				System.out.println("Introduce nombre");
				nombre=br.readLine();
				System.out.println("Introduce apellidos");
				apellidos=br.readLine();
				System.out.println("Introduce telefono");
				telefono=br.readLine();
				ct = new Contacto(nombre,apellidos,telefono);				
				if ( bd.a�adir(ct))
					System.out.println("A�adido");		
				else
					System.out.println("No se ha podido a�adir");
			break;
			case 2:
				
					System.out.println("Introduce nombre");
					nombre=br.readLine();
					System.out.println("Introduce apellidos");
					apellidos=br.readLine();
					System.out.println("Introduce telefono");
					telefono=br.readLine();
					ct = new Contacto(nombre,apellidos,telefono);
					int filas=bd.borrar(ct);
					switch (filas){
					case 0:
						System.out.println("No es contacto");
						break;
					case 1: 
						System.out.println("Contacto elimindado");
						break;
					default:
						System.out.println("En este momento no podemos eliminar. Int�ntalo m�s tarde");
					}
		
			break;
			case 3:				
				System.out.println("Introduce nombre");
				nombre=br.readLine();
				System.out.println("Introduce apellidos");
				apellidos=br.readLine();
				ct = new Contacto(nombre,apellidos);				
				telefono=bd.buscarTelefono(ct);		
				if (telefono==null)
					System.out.println("Por motivos t�cnicos no podemos obtener la informaci�n en este momento");
				else
					if (telefono.equals(""))
						System.out.println("No es contacto");
					else
						System.out.println("Su tel�fono es: "+ telefono);
				break;
			case 4:
				Vector<Contacto> v=bd.mostrarContactos();
				for(int i=0;i<v.size();i++)
					System.out.println(v.get(i));
				
				
			}
		}
		while (opc!=5);
			
	
		}
	
	
}

