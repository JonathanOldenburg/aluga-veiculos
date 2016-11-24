package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Veiculo;
import edu.asselvi.model.dao.VeiculoDAO;
import edu.asselvi.view.interfaces.IPadraoCadastra;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;

public class CadastraVeiculo implements IPadraoCadastra {

    private static final long serialVersionUID = 1L;

    public void run() {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		Menu menu = new Menu();
		
		menu.addOption(1, new Runnable() {
		    
		    @Override
		    public void run() {
		        Veiculo veiculo = new Veiculo();
	            veiculo.setPlaca(Msg.perguntaStr("Digite a placa:"));
	            veiculo.setModelo(Msg.perguntaStr("Digite o modelo:"));
	            veiculo.setAno(Msg.perguntaInt("Digite o ano"));
	            veiculo.setId_Cor(Msg.perguntaInt("Escolha a cor no combo")); //TODO: arrumar
	            
	            veiculo.setDiaria((Msg.perguntaDouble("Digite a diaria")));
	            veiculo.setAtivo(true);

	            try {
                    veiculoDAO.insere(veiculo);
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }

	            Msg.informa("Veiculo inserido com sucesso!");
		    }
		    
		    @Override
		    public String toString() {
		        return "Cadastrar veículo";
		    }
		})
		.addOption(2, new Runnable() {
		    
		    @Override
		    public void run() {
		        try {
                    if (veiculoDAO.exclui(Msg.perguntaInt("Digite o ID do carro a ser excluído"))) {
                        Msg.informa("Veiculo excluído com sucesso!");
                    }
                    else{
                        Msg.informa("Veiculo não existe!");
                    }
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
		    }
		    
		    @Override
		    public String toString() {
		        return "Excluir veiculo";
		    }
		})
		.show();
	}

    @Override
    public String toString() {
        return "Veiculos";
    }
}
