package br.univel.minhaarvore;

import java.util.List;

public interface UniNode<T> {

	public boolean isLeaf();
	
	public T getConteudo();
	
	public UniNode<T> getPai();
	
	public List<UniNode<T>> getFilhos();
	
	public void addFilho(UniNode<T> node);
	
	
	
}
