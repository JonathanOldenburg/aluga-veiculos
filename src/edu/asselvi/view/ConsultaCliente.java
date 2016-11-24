package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Cliente;
import edu.asselvi.model.dao.ClienteDAO;
import edu.asselvi.view.interfaces.IPadraoConsulta;

public class ConsultaCliente implements IPadraoConsulta {

	public static void chamaConsulta() throws BDException {
		ClienteDAO clienteDAO = new ClienteDAO();

		try {
			for (Cliente cliente : clienteDAO.consulta())
				System.out.println(cliente);

		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
	}
	// try

	// try {
	// for (Cliente cliente : clienteDAO.consulta())
	// System.out.println(p);
	// }
	// } catch (BDException e) {
	// System.out.println(e.getMessage());
	// }
}
