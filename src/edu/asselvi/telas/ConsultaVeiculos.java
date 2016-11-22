package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.VeiculoDAO;
import edu.asselvi.bean.Veiculo;
import edu.asselvi.interfaces.IPadraoConsulta;

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
