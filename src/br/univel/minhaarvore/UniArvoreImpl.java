package br.univel.minhaarvore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import br.univel.minhaarvore.UniNode;
import br.univel.meustestes.Conta;

public class UniArvoreImpl<T> implements UniArvore<T> {

	private T raiz;

	public UniArvoreImpl(T noRaiz) {
		this.raiz = noRaiz;
	}

	@Override
	public void mostrarTodosConsole() {

		StringBuilder sb = new StringBuilder();

		if (this.raiz == null) {

			JOptionPane.showMessageDialog(null, JOptionPane.WARNING_MESSAGE, "Árvore vazia.", 0);
		} else {
			
			
			sb.append(this.trazRaiz().getConteudo().toString() + "\n");
			
		}
		sb.append(returnMembro((UniNode<T>) this.raiz, getId()));
		
		System.out.println(sb.toString());
	}

	// Utilizando reflection para pegar o id.
	public Object getId() {

		Method metodo = null;
		Object valor = null;

		try {
			metodo = this.trazRaiz().getConteudo().getClass().getMethod("getId");

			try {

				valor = metodo.invoke(this.trazRaiz().getConteudo());

			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

				JOptionPane.showMessageDialog(null, "Algo deu errado !");
			}

		} catch (NoSuchMethodException | SecurityException e) {

			JOptionPane.showMessageDialog(null, "Algo deu errado !");

		}
		return valor;

	}

	public String returnMembro(UniNode<T> node, Object id) {

		StringBuilder sb = new StringBuilder();
		if (node.isLeaf() == false) {
			for (UniNode<T> no : node.getFilhos()) {
				if (!no.isLeaf() == false) {
					
					sb.append("\t");
				}
				sb.append(" " + getId() + "." + no.getConteudo().toString() + "\n");
				sb.append(returnMembro(no, id));
			}

		}
		return sb.toString();

	}




	@Override
	public UniNode<T> trazRaiz() {

		return (UniNode<T>) raiz;
	}

}
