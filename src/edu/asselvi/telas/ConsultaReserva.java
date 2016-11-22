package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.ReservaDAO;
import edu.asselvi.bean.Reserva;
import edu.asselvi.interfaces.IPadraoConsulta;

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
