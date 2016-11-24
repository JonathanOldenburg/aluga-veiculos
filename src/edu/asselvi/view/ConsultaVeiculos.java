package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Veiculo;
import edu.asselvi.model.dao.VeiculoDAO;
import edu.asselvi.view.interfaces.IPadraoConsulta;

public class ConsultaVeiculos implements IPadraoConsulta {

	public static void ChamaConsulta() throws BDException {
		VeiculoDAO veiculoDAO = new VeiculoDAO();

		try {
			for (Veiculo veiculo : veiculoDAO.consulta())
				System.out.println(veiculo);

		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
	}
	// try

	// try {
	// for (Veiculo veiculo : veiculoDAO.consulta())
	// System.out.println(p);
	// }
	// } catch (BDException e) {
	// System.out.println(e.getMessage());
	// }

}
