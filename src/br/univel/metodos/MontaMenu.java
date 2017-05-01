package br.univel.metodos;

public class MontaMenu {
	
	
	public String montaMenu(){
		
		StringBuilder menu = new StringBuilder();
		
		menu.append("1 - \t Mostrar plano de contas. ").append("\n");
		menu.append("2 - \t Mostrar o total de despesas. ").append("\n");
		menu.append("3 - \t Mostrar setores. ").append("\n");
		menu.append("4 - \t Mostrar despesa por setor. ").append("\n");
		menu.append("5 - \t Sair. ");
		
		
		return menu.toString();
	}

}
