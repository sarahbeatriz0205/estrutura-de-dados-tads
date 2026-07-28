public class Teste{
	public static void main(String[] args) {		
		Integer[] b = new Integer[1];		
		FilaArray fila=new FilaArray(1,0);
		System.out.println("TESTANDO A ESTRUTURA FILA FEITA COM ARRAY");		  
		fila.enqueue(5);
        fila.enqueue(3);
        System.out.println(fila.dequeue());
        fila.enqueue(2);
        fila.enqueue(8);
        System.out.println(fila.dequeue()); 
        System.out.println(fila.dequeue());
        fila.enqueue(9); 
        fila.enqueue(1); 
        System.out.println(fila.dequeue());
        fila.enqueue(7); 
        fila.enqueue(6); 
        System.out.println(fila.dequeue()); 
        System.out.println(fila.dequeue());
        fila.enqueue(4); 
        fila.enqueue (7); 
        System.out.println(fila.dequeue());
	}
}