package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import colegio.*;
import modelos.Alumno;


public class BD_Colegio extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Colegio(String file){
		super(file);
	}
	
	public  int añadir_Alumno( Alumno al){	
		String cadenaSQL="INSERT INTO alumnos VALUES('" + al.getNombre() + "','" +
		al.getDni()+"','"+ al.getTelefono() +"',"+ al.getMatricula()+",'"+
				al.getCurso()+"','"+al.getFechaMatricula()+"')"; 	
		
		try{
		this.abrir();
		s=c.createStatement();
		int filas=s.executeUpdate(cadenaSQL);
		s.close();
		this.cerrar();
		return filas;
		}
		catch ( SQLException e){			
			return -1;
		}
	}
	
	public int borrar_Alumno(Alumno al){
		String cadena="DELETE FROM alumno WHERE dni='" + al.getDni() + "'and nombre='" +
		al.getNombre()+"'and curso='"+ al.getCurso() +"'and matricula="+ al.getMatricula()+"and telefono='"+
				al.getTelefono()+"'"; 	
		
		try{
		this.abrir();
		s=c.createStatement();
		int f=s.executeUpdate(cadena);	
		s.close();
		this.cerrar();
		return f;
		
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	public  Vector<Alumno> listadoAlumnosCurso(String curso){
		String cadenaSQL="SELECT * from alumnos WHERE curso='"+curso+"'";
		Vector<Alumno> listaCursos=new Vector<Alumno>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fechaMatricula");
				LocalDate fBuena=f.toLocalDate();
				listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre")	
						,reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),fBuena));
				
			}
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	
	public  Vector<String> listadoCursos(){
		String cadenaSQL="SELECT curso from cursos";
		Vector<String> listaCursos=new Vector<String>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaCursos.add(reg.getString(1));
			}			
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			return null;
			
		}
	}
	
}
