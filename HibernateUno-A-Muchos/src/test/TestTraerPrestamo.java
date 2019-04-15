package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {
	public static void main(String[] args) {
		PrestamoABM prestamoABM = PrestamoABM.getIntanciaPrestamoABM();
		long idPrestamo = 1;
		System.out.println("\n---> TraerPrestamo idPrestamo=" + idPrestamo + "\n\n");
		Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
		System.out.println(p + "\nPertenece a " + p.getCliente());
		
//implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		
		ClienteABM abm = ClienteABM.getIntanciaClienteABM();
		int dni = 14000000;
		Cliente c = abm.traer(dni);
		
		System.out.println("\n---> TraerPrestamos del Cliente=" + c + "\n\n");
		List<Prestamo> prestamos = prestamoABM.traerPrestamo(c);
		
//implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		
		for (Prestamo o : prestamos)
			System.out.println(o + "\nPertenece a " + o.getCliente());
	}
}