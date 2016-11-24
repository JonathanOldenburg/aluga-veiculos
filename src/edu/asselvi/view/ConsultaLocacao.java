package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Locacao;
import edu.asselvi.model.dao.LocacaoDAO;
import edu.asselvi.view.interfaces.IPadraoConsulta;

public class ConsultaLocacao implements IPadraoConsulta {

	public static void chamaConsulta() throws BDException {
		LocacaoDAO locacaoDAO = new LocacaoDAO();

		try {
			for (Locacao locacao : locacaoDAO.consulta())
				System.out.println(locacao);

		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
	}
	// try

	// try {
	// for (Locacao locacao : locacaoDAO.consulta())
	// System.out.println(p);
	// }
	// } catch (BDException e) {
	// System.out.println(e.getMessage());
	// }
}
