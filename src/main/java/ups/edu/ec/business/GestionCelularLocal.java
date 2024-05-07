package ups.edu.ec.business;

import java.util.List;

import jakarta.ejb.Local;
import ups.edu.ec.model.Celular;

@Local
public interface GestionCelularLocal {

	public void guardarCelulares(Celular celular);
	public void actualizarCelular(Celular celular) throws Exception;
	public Celular getCelularPorId(int codigo);
	public void borrarCelular(int codigo);
	public List<Celular> getCelulares();
}
