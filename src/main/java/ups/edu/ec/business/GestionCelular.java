package ups.edu.ec.business;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.dao.CelularDao;
import ups.edu.ec.model.Celular;

@Stateless
public class GestionCelular implements GestionCelularLocal, GestionCelularRemoto {

	@Inject
	private CelularDao daoCelular;

	public void actualizarCelular(Celular celular) throws Exception {
		Celular cel = daoCelular.read(celular.getCodigo());
		if (cel != null) {
			daoCelular.update(celular);
		} else {
			throw new Exception("Celular no existe");
		}
	}

	public void guardarCelulares(Celular celular) {
		System.out.println("Codigo: " + celular.getCodigo());
		Celular cli = daoCelular.read(celular.getCodigo());
		if (cli != null) {
			System.out.println("Este es: " + celular);
			daoCelular.update(celular);
		} else {
			daoCelular.insert(celular);
		}
	}

	public Celular getCelularPorId(int codigo) {
		return daoCelular.getCelularPorId(codigo);
	}

	public void borrarCelular(int codigo) {
		daoCelular.remove(codigo);
	}

	public List<Celular> getCelulares() {
		return daoCelular.getAll();
	}
}