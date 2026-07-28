public class TestePilha {
	public static void main(String[] args) {		
		// Integer b[] = new Integer[1];		
		PilhaRubroNegra pp=new PilhaRubroNegra(1);
		System.out.println("Inserindo na pilha vermelha");
		for(int f=0;f<10;f++){
		  System.out.println(f);		  
		  pp.pushVermelho(f);
		}
        
        System.out.println();
        System.out.println("Inserindo na pilha preta");
        for(int j=0;j<10;j++){
		  System.out.println(j);		  
		  pp.pushPreto(j);
		}

        System.out.println();
        System.out.println("Retornando o elemento do topo da pilha vermelha sem remover");
		System.out.println("Índice: "+pp.retornaIndiceTopVermelho());
		System.out.println(pp.topVermelho());

        System.out.println();
        System.out.println("Retornando o elemento do topo da pilha preta sem remover");
		System.out.println("Índice: "+pp.retornaIndiceTopPreto());
		System.out.println(pp.topPreto());

        System.out.println();
		System.out.println("Retirando da pilha vermelha");
		for(int k=0;k<10;k++){
              System.out.println(k);	
			  System.out.println("- "+pp.popVermelho());
		}

        System.out.println();
        System.out.println("Retirando da pilha preta");
        for(int i=0;i<10;i++){
              System.out.println(i);	
			  System.out.println("- "+pp.popPreto());
		}
	}
}