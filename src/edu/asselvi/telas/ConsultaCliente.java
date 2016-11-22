package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.ClienteDAO;
import edu.asselvi.bean.Cliente;
import edu.asselvi.interfaces.IPadraoConsulta;

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
