package br.univel.meustestes;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import br.univel.metodos.MontaMenu;
import br.univel.metodos.SomaRecursiva;
import br.univel.minhaarvore.UniArvore;
import br.univel.minhaarvore.UniArvoreImpl;
import br.univel.minhaarvore.UniNode;
import br.univel.minhaarvore.UniNodeImpl;

public class Principal {

	public Principal() {

		// Plano de contas total !
		// TrabalhoComplementar 3o Sem
		Conta contaAgua = new Conta(1, "Água", new BigDecimal("30.00"));
		UniNode<Conta> noAgua = new UniNodeImpl<>(contaAgua);

		Conta contaAluguel = new Conta(2, "Aluguel", new BigDecimal("700.00"));
		UniNode<Conta> noAlu = new UniNodeImpl<>(contaAluguel);

		Conta contaIntTel = new Conta(3, "Internet e Telefone", new BigDecimal("240.00"));
		UniNode<Conta> noIntTel = new UniNodeImpl<>(contaIntTel);

		Conta contaEnElet = new Conta(4, "Luz", new BigDecimal("44.24"));
		UniNode<Conta> noEnElet = new UniNodeImpl<>(contaEnElet);

		Conta despesasAdm = new Conta(1, "Despesas Administrativas", new BigDecimal(0));

		UniNode<Conta> noDeAdm = new UniNodeImpl<>(despesasAdm);
		noDeAdm.addFilho(noAgua);
		noDeAdm.addFilho(noAlu);
		noDeAdm.addFilho(noIntTel);
		noDeAdm.addFilho(noEnElet);

		// Fim despesas Administrativas

		// Inicio gastos com pessoal

		Conta contaBeneficios = new Conta(1, "Beneficíos", new BigDecimal("15000.500"));
		UniNode<Conta> noBeneficio = new UniNodeImpl<Conta>(contaBeneficios);

		Conta contaEncargos = new Conta(2, "Encargos", new BigDecimal("39000.400"));
		UniNode<Conta> noEncargos = new UniNodeImpl<Conta>(contaEncargos);

		Conta contaSalarios = new Conta(3, "Salários", new BigDecimal("135000.80"));
		UniNode<Conta> noSalarios = new UniNodeImpl<Conta>(contaSalarios);

		Conta gastosPessoal = new Conta(2, "Gastos com Pessoal", new BigDecimal(0));

		UniNode<Conta> noPessoal = new UniNodeImpl<>(gastosPessoal);
		noPessoal.addFilho(noBeneficio);
		noPessoal.addFilho(noEncargos);
		noPessoal.addFilho(noSalarios);

		// Fim pessoal.

		// inicio Manutencao e Limpeza.

		Conta contaSerELimp = new Conta(1, "Serviço de Limpeza", new BigDecimal("1500.80"));
		UniNode<Conta> nodeSerELimp = new UniNodeImpl<Conta>(contaSerELimp);

		Conta contaSerEManu = new Conta(2, "Serviço de Manutenção", new BigDecimal("840.90"));
		UniNode<Conta> nodeSerEManu = new UniNodeImpl<Conta>(contaSerEManu);

		Conta despesasMateriais = new Conta(3, "Manutenção e Limpeza", new BigDecimal(0));
		UniNode<Conta> nodeManutencao = new UniNodeImpl<>(despesasMateriais);
		nodeManutencao.addFilho(nodeSerELimp);
		nodeManutencao.addFilho(nodeSerEManu);

		// Fim manutencao e limpeza

		// inicio Materiais.

		Conta materiEEsc = new Conta(1, "Materiais de Escritório", new BigDecimal("7600.70"));
		UniNode<Conta> nodeMateriEEsc = new UniNodeImpl<Conta>(materiEEsc);

		Conta materiELimp = new Conta(2, "Materiais de Limpeza", new BigDecimal("900.40"));
		UniNode<Conta> nodeMateriELimp = new UniNodeImpl<Conta>(materiELimp);

		Conta despesasComMateria = new Conta(4, "Materiais", new BigDecimal(0));
		UniNode<Conta> nodedeMateriais = new UniNodeImpl<>(despesasComMateria);
		nodedeMateriais.addFilho(nodeMateriEEsc);
		nodedeMateriais.addFilho(nodeMateriELimp);

		Conta despesasOper = new Conta(1, "Despesas Operacionais", new BigDecimal(0));
		UniNode<Conta> noDeOpr = new UniNodeImpl<>(despesasOper);
		noDeOpr.addFilho(noDeAdm);
		noDeOpr.addFilho(noPessoal);
		noDeOpr.addFilho(nodeManutencao);
		noDeOpr.addFilho(nodedeMateriais);

		UniArvore<Conta> planoContas = new UniArvoreImpl(noDeOpr);
		
		
		
		/**
		 * Ínicio Menu !
		 */
		
		MontaMenu menu = new MontaMenu();
		int escolhe = Integer.parseInt(JOptionPane.showInputDialog(menu.montaMenu()));
		
		while(escolhe !=5){
			if(escolhe == 1){
				
				planoContas.mostrarTodosConsole();
				break;
				
			}
			else if(escolhe == 2){
				
				SomaRecursiva<Conta> soma = new SomaRecursiva<>();
				BigDecimal somaTotal = soma.somaRecursiva(planoContas.trazRaiz());
				JOptionPane.showMessageDialog(null, "Total de despesas : R$ " + somaTotal);
				break;
			}
			else if(escolhe == 3){
				
				
				
			}
		}

	}

	public static void main(String[] args) {

		new Principal();

	}

}
