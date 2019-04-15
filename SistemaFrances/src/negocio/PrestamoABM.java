package negocio;

import dao.PrestamoDao;
import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private static PrestamoABM instanciaPrestamoABM;

	protected PrestamoABM() {
		this.inicializar();
	}

	public static PrestamoABM getIntanciaPrestamoABM() {
		if (instanciaPrestamoABM == null) {
			instanciaPrestamoABM = new PrestamoABM();
		}
		return instanciaPrestamoABM;
	}

	public void inicializar() {

	}

	public Prestamo traerPrestamo(long idPrestamo) {
//Implementar: si el no existe el prestamo lanzar la excepción
		Prestamo p = PrestamoDao.getIntanciaPrestamoDao().traer(idPrestamo);
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return PrestamoDao.getIntanciaPrestamoDao().traer(c);
	}

	public int agregarPrestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente)
			throws Exception {

		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return PrestamoDao.getIntanciaPrestamoDao().agregar(p);
	}

	public void modificarPrestamo(Prestamo p) {
		PrestamoDao.getIntanciaPrestamoDao().actualizar(p);
	}

	public void eliminarPrestamo(Prestamo p) {
		PrestamoDao.getIntanciaPrestamoDao().eliminar(p);
	}

}