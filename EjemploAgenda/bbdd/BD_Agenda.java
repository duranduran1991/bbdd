
/*
 * BD_Agenda: Operaciones de inserci�n, borrado y b�squeda en la tabla contactos
 */
package bbdd;

import java.sql.*;
import java.util.*;

import modelos.Contacto;

public class BD_Agenda extends BD_Conector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Agenda(String bbdd) {
		super(bbdd);
	}

	public boolean a�adir(Contacto ct) {
		String cadena = "INSERT INTO contactos VALUES('" + ct.getNombre()
		 + "','" + ct.getApellidos() + "','"
				+ ct.getTelefono() + "')";

		try {
			this.abrir();
			s = c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return true;
		} catch (SQLException e) {
			this.cerrar();
			return false;
		}

<<<<<<< HEAD
	}

	public int borrar(Contacto ct) {
		String cadena = "DELETE FROM contactos WHERE nombre='" + ct.getNombre() + "' AND apellidos='"
				+ ct.getApellidos() + "' AND telefono='" + ct.getTelefono() + "'";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return filas;

		} catch (SQLException e) {
=======
	public int borrar(Contacto ct){
		String cadena="DELETE FROM contactos WHERE nombre='" +  ct.getNombre() 
		+ "' AND apellidos='" + ct.getApellidos()+"' AND telefono='" + ct.getTelefono()+ "'";	
		
		try{
		this.abrir();
		s=c.createStatement();
		int filas=s.executeUpdate(cadena);	
		s.close();
		this.cerrar();
		return filas;
		
		}
		catch ( SQLException e){
>>>>>>> refs/remotes/origin/master
			this.cerrar();
			return -1;
		}
	}
<<<<<<< HEAD

	public String buscarTelefono(Contacto ct) {
		String cadena = "SELECT * FROM contactos WHERE nombre='" + ct.getNombre() + "' AND apellidos='"
				+ ct.getApellidos() + "'";
		try {
			String t = "";
=======
	
	public  String buscarTelefono(Contacto ct){
		String cadena="SELECT telefono FROM contactos WHERE nombre='" 
	+ ct.getNombre() +"' AND apellidos='" + ct.getApellidos() +"'";
		try{
			String t="";
>>>>>>> refs/remotes/origin/master
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next())
				t = reg.getString(1);
			t = reg.getString(1) + " " + reg.getString(2) + " " + reg.getString(3);

			// t=reg.getString("telefono");

			s.close();
			this.cerrar();
			return t;
		} catch (SQLException e) {

			return null;

		}

	}

	public Vector<Contacto> mostrarContactos() {
		Vector<Contacto> v = new Vector<Contacto>();
		String cadena = "SELECT * FROM contactos ";
		try {

			this.abrir();
<<<<<<< HEAD
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			while (reg.next()) {
				v.add(new Contacto(reg.getString("nombre")
						, reg.getString("apellidos")
						, reg.getString("telefono")));
=======
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			while ( reg.next()){						
				 v.add(new Contacto(reg.getString("nombre")
						 ,reg.getString("apellidos"),reg.getString("telefono")));
>>>>>>> refs/remotes/origin/master
			}

			s.close();
			this.cerrar();
			return v;
		} catch (SQLException e) {

			return null;

		}

	}

}
