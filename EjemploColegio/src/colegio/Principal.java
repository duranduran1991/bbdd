package colegio;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import bbdd.*;
import modelos.Alumno;



public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner sLeer=new Scanner(System.in);
		int opc=0;
		
		
		BD_Colegio bd=new BD_Colegio("colegio");
		
		
		do	
		{
			System.out.println("\n\nGESTIÓN COLEGIO");
			System.out.println("***************");
			System.out.println("1.Nuevo Alumno\n"
					+ "2.Nuevo Curso\n3.Borrar Alumno\n4.Listado alumnos por curso\n"
					+ "5.Listado de cursos\n"
					+ "6.Consultar alumno\n"
					+ "7.Consultar tutor de un curso\n"
					+ "8.Listado alumnos por tutor\n");
			System.out.print("\tTeclea opción: ");
			try{
			opc=sLeer.nextInt();
			}
			catch(NumberFormatException e ){
				System.out.println("Opcion incorrecta");
				opc=0;
			}
			catch(InputMismatchException e ){
				System.out.println("Debes introducir número 1-5");
				opc=0;
			}
			
			sLeer.nextLine();
			switch (opc){
			case 1:
				System.out.println("\n\nALTA ALUMNO");
				System.out.print("Introduce nombre completo\t");
				String nombre=sLeer.nextLine();				
				System.out.print("Introduce telefono\t");
				String telefono=sLeer.nextLine();
				System.out.print("Introduce DNI\t");
				String dni=sLeer.nextLine();
				System.out.print("Introduce número de matrícula\t");
				int matricula=sLeer.nextInt();	
				Vector <String> cursos=bd.listadoCursos();
				if (cursos==null){
						System.out.println("En este momento no podemos realizar la operación");
						break;
				}
				System.out.println("Lista de cursos");
				for (int i=0;i<cursos.size();i++)
					System.out.println((i+1)+ ".- "+cursos.get(i));				
				System.out.print("Teclea el curso\t");
				String curso=sLeer.next();
				Alumno al=new Alumno(dni,nombre,curso,matricula,telefono);			
				int filas=bd.añadir_Alumno(al);				
				switch (filas){
				case 1:
					System.out.println("\nAlumno añadido");
					break;
				case 0:
					System.out.println("\nNo añadido");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");
					break;
					
				}
			break;
			case 3:
				System.out.print("Introduce DNI");
				dni=sLeer.nextLine();
				System.out.print("Introduce nombre completo");
				nombre=sLeer.nextLine();
				System.out.print("Introduce curso");
				curso=sLeer.nextLine();
				System.out.print("Introduce número de matrícula");
				matricula=sLeer.nextInt();
				sLeer.nextLine();
				System.out.print("Introduce telefono");
				telefono=sLeer.nextLine();
				al=new Alumno(dni,nombre,curso,matricula,telefono);	
				int f=bd.borrar_Alumno(al);
				switch (f){
				case 0:
					System.out.println("No es un alumno");
					break;
				case 1: 
					System.out.println("Alumno elimindado");
					break;
				default:
					System.out.println("En este momento no podemos eliminar. Inténtalo más tarde");
				}
	
		break;
			
			case 4:											
				cursos=bd.listadoCursos();
				if (cursos==null){
						System.out.println("En este momento no podemos realizar la operación");
						break;
				}
				System.out.println("Lista de cursos");
				for (int i=0;i<cursos.size();i++)
					System.out.println((i+1)+ ".- "+cursos.get(i));				
				System.out.print("Teclea el curso\t");
				curso=sLeer.next();
				Vector <Alumno> listado=bd.listadoAlumnosCurso(curso);
				System.out.println("\n\nLISTADO ALUMNOS "+ curso.toUpperCase()+"\n");
				for (int i=0;i<listado.size();i++)									
					System.out.println(listado.get(i).toString());
				break;
			
			}
		}
		while (opc!=8);
			
	
		}
	
	
	

}
