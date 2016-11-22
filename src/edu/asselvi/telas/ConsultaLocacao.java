package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.LocacaoDAO;
import edu.asselvi.bean.Locacao;
import edu.asselvi.interfaces.IPadraoConsulta;

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
