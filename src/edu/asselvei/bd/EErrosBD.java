package edu.asselvei.bd;

public enum EErrosBD {
	ABRE_CONEXAO ("Erro ao abrir conexão com o banco de dados"),
	FECHA_CONEXAO ("Erro ao fechar a conexão com o banco de dados"),
	CRIA_TABELA ("Erro ao criar a tabela especificada"),
	DROPA_TABELA ("Erro ao eliminar a tabela especificada"),
	INSERE_DADO ("Erro ao inserir dados na tabela especificada"),
	ROLLBACK ("Erro ao desfazer as alterações no banco. Entre em contato com o DBA"),
	CONSULTA_DADO ("Erro ao consultar dados na tabela especificada"),
	ATUALIZA_DADO ("Erro ao atualizar os dados na tabela especificada"),
	EXCLUI_DADO ("Erro ao excluuir os dados da tabela especificada");
	
	private final String erro;

	public String getErro() {
		return erro;
	}
	
	private EErrosBD(String erro) {
		this.erro = erro;
	}
}
