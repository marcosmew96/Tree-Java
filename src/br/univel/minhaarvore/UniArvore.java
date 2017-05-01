package br.univel.minhaarvore;

import br.univel.minhaarvore.UniNode;

public interface UniArvore<T> {
	
	
	public void mostrarTodosConsole();
	public UniNode<T> trazRaiz();
	public Object getId();
	public String returnMembro(UniNode<T> node, Object id);
}
