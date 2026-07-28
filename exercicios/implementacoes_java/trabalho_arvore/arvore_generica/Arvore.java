package arvore_generica;
import java.util.ArrayList;
import java.util.Iterator;

public class Arvore{
	
	No raiz;
	int tamanho;
	ArrayList<No> nos = new ArrayList<No>();


	public Arvore(Object o){
		this.raiz = new No(null, o);
		nos.add(this.raiz);
		this.tamanho = 1;
	}

	public No root(){
		return this.raiz;
	}

	public No parent(No v){
		return v.getPai();
	}

	public Iterator<No> children(No v){
		return v.childrenIterator();
	}

	public boolean isInternal(No v){
		if (v.childrenNumber() != 0){
			return true;
		}
		return false;
	}
	
	public boolean isExternal(No v){
		if (v.childrenNumber() == 0){
			return true;
		}
		return false;
	}

	public boolean isRoot(No v){
		if (v == root()){
			return true;
		}
		return false;
	}

	public void addChild(No v, Object o){
		No novo = new No(v, o);
		v.addChild(novo);
		nos.add(novo);
		this.tamanho++;
	}

	public Object remove(No v) throws ArvoreExcecao{
		No pai = v.getPai();
		if (pai != null && isExternal(v)){
			pai.removeChild(v);
			nos.remove(v);
		}
		else{throw new ArvoreExcecao("Nó inválido");}

		Object o = v.element();
		tamanho--;
		return o;
		
	}

	public int depth(No v){
		return profundidade(v);
	}

	private int profundidade(No v){
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.getPai());
	}

	public int height(No v){
		return altura(v);
	}

	private int altura(No v){
		if (isExternal(v)){
			return 0;
		} else {
			int h = 0;
			for (No f : v.childrenArray()){
				h = Math.max(h, altura(f));
			}
			return 1+h;
		}
	}

	public int size(){
		return this.tamanho;
	}

	public boolean isEmpty(){
		return false;
	}

	private void visite(No v){
		System.out.println(v.element());
	}

	public void preOrder(No v){
		visite(v);
		for (No f : v.childrenArray()){
			preOrder(f);
		}
	}

	public void postOrder(No v){
		for (No f : v.childrenArray()){
			postOrder(f);
		}
		visite(v);
	}

	public Object replace(No v, Object o){
		Object e = v.element();
		v.setElement(o);
		return e;
	}

	public Iterator<Object> elements(){
		ArrayList<Object> elementos = new ArrayList<Object>();
		for (No n : nos){
			elementos.add(n.element());
		}
		return elementos.iterator();
	}

	public Iterator<No> Nos(){
		return nos.iterator();
	}

	public void swapElements(No v, No w){
		Object temp = v.element();
		v.setElement(w.element());
		w.setElement(temp);
	}
}