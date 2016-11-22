package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.CorDAO;
import edu.asselvi.bean.Cor;
import edu.asselvi.interfaces.IPadraoConsulta;

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
