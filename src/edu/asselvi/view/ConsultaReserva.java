package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Reserva;
import edu.asselvi.model.dao.ReservaDAO;
import edu.asselvi.view.interfaces.IPadraoConsulta;

public class ConsultaReserva implements IPadraoConsulta {

	public static void chamaConsulta() throws BDException {
		ReservaDAO reservaDAO = new ReservaDAO();

		try {
			for (Reserva reserva : reservaDAO.consulta())
				System.out.println(reserva);

		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
	}
	// try

	// try {
	// for (Reserva reserva : reservaDAO.consulta())
	// System.out.println(p);
	// }
	// } catch (BDException e) {
	// System.out.println(e.getMessage());
	// }

}
