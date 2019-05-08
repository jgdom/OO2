package negocio;

import dao.CuotaDao;
//import java.time.LocalDate;
import java.util.List;

import datos.Prestamo;
import datos.Cuota;

public class CuotaABM {
	
	private CuotaDao dao = CuotaDao.getInstancia();
	private static CuotaABM instancia;
	
	public static CuotaABM getInstancia() {
		if(instancia == null) {
			instancia = new CuotaABM();
		}
		return instancia;
	}
	
	public Cuota traerCuota(long idCuota) {
		return dao.traerCuota(idCuota);
	}
	
	public List<Cuota> traerCuota(Prestamo p){
		return dao.traerCuota(p);
	}
	
	public int agregarCuota(Cuota c) {
		return dao.agregar(c);
	}
	
	public void actualizar(Cuota c) {
		dao.actualizar(c);
	}
	
	public void eliminar(Cuota c) {
		dao.eliminar(c);
	}
	
	
	
	

}
