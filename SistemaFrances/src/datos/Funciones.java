package datos;

import java.time.LocalDate;
import java.time.Month;


public class Funciones {
	
	public static int traerAnio(LocalDate fecha) {
		return fecha.getYear();
	}
	
	public static int traerMes(LocalDate fecha) {
		return fecha.getMonthValue();
	}
	
	public static Month traerMesNombre(LocalDate fecha) {
		return fecha.getMonth();
	}
	
	public static int traerDia(LocalDate fecha) {
		return fecha.getDayOfMonth();
	}
	
	public static String traerFechaCorta(LocalDate fecha) {
		return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha);
	}
	
	public static String traerFechaCortaMes(LocalDate fecha) {
		return traerDia(fecha) + " de " + traerMesNombre(fecha) + " del año " + traerAnio(fecha);
	}
	
	public static boolean sonFechasIguales(LocalDate fecha1,LocalDate fecha2) {
		return fecha1.isEqual(fecha2);
	}
	
	
	
	
	

}

