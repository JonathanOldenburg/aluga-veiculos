package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Cor;
import edu.asselvi.model.dao.CorDAO;
import edu.asselvi.view.interfaces.IPadraoConsulta;

public class ConsultaCor implements IPadraoConsulta {

	public static void chamaConsulta() throws BDException {
		CorDAO corDAO = new CorDAO();

		try {
			for (Cor cor : corDAO.consulta())
				System.out.println(cor);

		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
	}
	// try

	// try {
	// for (Cor cor : corDAO.consulta())
	// System.out.println(p);
	// }
	// } catch (BDException e) {
	// System.out.println(e.getMessage());
	// }

}
