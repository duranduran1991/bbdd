package modelos;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Alumno extends Persona {

	private int matricula;
	private String telefono;
	private LocalDate fechaMatricula;
	
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Alumno(String dni, String nombre, String curso, int matricula,
			String telefono) {
		super(dni, nombre, curso);
		this.matricula = matricula;
		this.telefono = telefono;
		this.fechaMatricula=LocalDate.now();
	}

		public Alumno(String dni, String nombre, String curso, int matricula,
			String telefono, LocalDate fechaMatricula) {
		super(dni, nombre, curso);
		this.matricula = matricula;
		this.telefono = telefono;
		this.fechaMatricula = fechaMatricula;
	}

	/**
	 * @return the matricula
	 */
	public int getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the telenono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telenono the telenono to set
	 */
	public void setTelefono(String telenono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + matricula + ", " + telefono + ", " + parseFecha() ;
	}

	private String parseFecha(){
		
		DateTimeFormatter formatter;
		formatter=DateTimeFormatter.ofPattern("dd/LL/yyyy", Locale.getDefault());
		return fechaMatricula.format(formatter);
	}
	

	
	
	

}
