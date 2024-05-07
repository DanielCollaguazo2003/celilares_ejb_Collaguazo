package ups.edu.ec.business;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.dao.CelularDao;
import ups.edu.ec.model.Celular;

@Singleton
@Startup // Hace que no espere a que un Celular lo llame sino que se ejecutara ni bien se
			// lanza la aplicacion
public class GestionDatos {

	@Inject
	private CelularDao daoCelular;

	@PostConstruct
	public void init() {
		System.out.println("iniciando");

		Celular Celular = new Celular();
		Celular.setCodigo(1);
		Celular.setIMEI("098765432123456789");
		Celular.setColor("Negro");
		Celular.setMarca("Iphone");
		Celular.setModelo("13 Pro Max");
		Celular.setPrecio(19.2);

		daoCelular.insert(Celular);

		System.out.println("\n------------- Celulares");
		List<Celular> list2 = daoCelular.getAll();
		for (Celular fac : list2) {
			System.out.println(fac);
		}
	}
}
