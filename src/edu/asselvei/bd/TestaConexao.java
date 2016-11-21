package edu.asselvei.bd;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.asselvi.bd.dao.VeiculoDAO;
import edu.asselvi.bean.Veiculo;

public class TestaConexao {
	public static void main(String[] args) {
		System.out.println("Iniciando");

		GregorianCalendar calendario = new GregorianCalendar(1977, Calendar.FEBRUARY, 27);
		
//		Calendar calendar = Calendar.getInstance();
		
		Veiculo veiculo = new Veiculo();
//		pessoa.setCodigo(1);
//		pessoa.setNome("Maria");
//		pessoa.setNascimento(calendario.getTime());
//		pessoa.setSalario(1000);
//		pessoa.setAtivo(true);
//		pessoa.setSexo('F');
		
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		try {
			veiculoDAO.insere(veiculo);
		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
//		try {
//			System.out.println(pessoaDAO.exclui(1) ? "sucesso" : "falha");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
		
		//		Pessoa pessoa = new Pessoa(1, "Junior", new Date(), 'M', 500, false);
//		try {
//			pessoaDAO.altera(pessoa);
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
		
////		Pessoa pessoa = null;
//		try {
//			for (Pessoa p : pessoaDAO.consulta()) {
//				System.out.println(p);
//			}
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(pessoa instanceof Pessoa ? pessoa.toString() : "não achei");
			
//		List<Pessoa> pessoas = new ArrayList<Pessoa>();
//		for (int i = 1; i < 10000; i++) {
//			pessoas.add(new Pessoa(i, "Danton Junior", new Date(), 'M', i * 10, true));
//		}
//// 		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		try {
//			pessoaDAO.insereTRN(pessoas);
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
//			for (Pessoa pessoa : pessoas) {
//				pessoaDAO.insere(pessoa);
//			}
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("Terminei");		
//		try {
//			System.out.println(pessoaDAO.criaTabela() ? "tabela criada" : "deu pau");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			System.out.println(pessoaDAO.dropaTabela() ? "tabela dropada" : "deu pau");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
		
//		System.out.println("Abrindo a conexão...");
//		try {
//			Conexao.getConexao();
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("Fechando a conexão");
//		try {
//			Conexao.fechaConexao();
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("FIM");
	}
}
