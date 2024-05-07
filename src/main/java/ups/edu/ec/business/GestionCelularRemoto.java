package ups.edu.ec.business;

import java.util.List;

import jakarta.ejb.Remote;
import ups.edu.ec.model.Celular;

@Remote
public interface GestionCelularRemoto {
	public void guardarCelulares(Celular celular);
	public void actualizarCelular(Celular celular) throws Exception;
	public Celular getCelularPorId(int codigo);
	public void borrarCelular(int codigo);
	public List<Celular> getCelulares();
}
