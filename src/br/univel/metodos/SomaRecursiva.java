package br.univel.metodos;

import java.math.BigDecimal;

import br.univel.meustestes.Conta;
import br.univel.minhaarvore.UniNode;
/**
 * 
 * @author Marcos
 *
 * @param <Conta>
 * 
 * Método de soma recursiva para a conta.
 *
 */


public class SomaRecursiva<T> {

	public BigDecimal somaRecursiva(UniNode<Conta> node) {

		BigDecimal somaFilhoNo = node.getConteudo().getValor();

		if (!node.isLeaf() == true) {

			somaFilhoNo = node.getConteudo().getValor();

			for (UniNode<Conta> n : node.getFilhos()) {

				somaFilhoNo = somaFilhoNo.add(somaRecursiva(n));
				//Recursividade !
				

			}
		}
		return somaFilhoNo;

	}

}
