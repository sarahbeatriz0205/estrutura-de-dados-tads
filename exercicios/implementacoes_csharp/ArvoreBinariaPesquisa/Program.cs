using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
namespace ArvoreBinariaPesquisa;

class Program {
    static void Main(string[] args) {
        Console.WriteLine("=== Criando Árvore Binária de Pesquisa ===");
        
        // Criando a árvore com a raiz valendo 50
        ArvoreBinariaPesquisa arvore = new(50);
        
        // Inserindo vários elementos para povoar a árvore
        // Lembre-se: menores vão para a esquerda, maiores para a direita
        arvore.Insert(30, arvore.Raiz);
        arvore.Insert(70, arvore.Raiz);
        arvore.Insert(20, arvore.Raiz);
        arvore.Insert(40, arvore.Raiz);
        arvore.Insert(60, arvore.Raiz);
        arvore.Insert(80, arvore.Raiz);
        arvore.Insert(35, arvore.Raiz); // Filho direito do 30, esquerdo do 40

        Console.WriteLine($"\nTamanho atual da árvore: {arvore.GetSize()} nós.");

        Console.WriteLine("\n=== Impressão Visual da Árvore ===");
        arvore.ImprimirArvore();

        Console.WriteLine("\n=== Travessias (Caminhamentos) ===");
        
        Console.Write("Em Ordem (InOrder):   ");
        arvore.InOrder(arvore.Raiz);
        Console.WriteLine();

        Console.Write("Pré-Ordem (PreOrder): ");
        arvore.PreOrder(arvore.Raiz);
        Console.WriteLine();

        Console.Write("Pós-Ordem (PostOrder):");
        arvore.PostOrder(arvore.Raiz);
        Console.WriteLine();

        // Testando o sistema de busca
        Console.WriteLine("\n=== Testando Busca ===");
        int numeroParaBuscar = 40;
        No resultado = ArvoreBinariaPesquisa.Search(numeroParaBuscar, arvore.Raiz);
        
        if (resultado != null && resultado.Elemento == numeroParaBuscar)
        {
            Console.WriteLine($"Sucesso! O número {numeroParaBuscar} foi encontrado na árvore.");
        }
        else
        {
            Console.WriteLine($"O número {numeroParaBuscar} não existe na árvore.");
        }

        // Testando a validação de erro (duplicação)
        Console.WriteLine("\n=== Testando Tratamento de Erro ===");
        try
        {
            Console.WriteLine("Tentando inserir o número 30 novamente...");
            arvore.Insert(30, arvore.Raiz);
        }
        catch (Excecao ex)
        {
            Console.WriteLine($"Exceção capturada com sucesso: {ex.Message}");
        }
    }
}

public class ArvoreBinariaPesquisa {
    public No? Raiz;
    public int Size;
    public List<No> Nos;

    public ArvoreBinariaPesquisa(No? Raiz) {
        this.Raiz = Raiz;
        Size = 1;
        Nos = [Raiz]; 
    }

    public int GetSize() {
        return Size;
    }

    public bool IsEmpty() {
        return Size == 0;
    }

    public No Root() {
        return Raiz;
    }

    public static bool IsRoot(No No) {   
        if (No.Pai == null) {
            return true;
        }
        return false;
    }

    public static bool IsExternal(No No) {
        if (No.FilhoEsquerdo == null && No.FilhoDireito == null) {
            return true;
        }
        return false;
    }

    public static bool IsInternal(No No) {
        if (No.FilhoEsquerdo != null || No.FilhoDireito != null) {
            return true;
        }
        return false;
    }

    public static No Parent(No No) {
        if (IsRoot(No)) {
            throw new Excecao("Erro! Nó é raiz, não tem pai");
        }
        return No.Pai;
    }

    public static IEnumerator<No> Children(No No) {
        List<No> Filhos = new();
        if (No.FilhoEsquerdo != null) {
            Filhos.Add(No.FilhoEsquerdo);
        }
        if (No.FilhoDireito != null) {
            Filhos.Add(No.FilhoDireito);
        }
        return Filhos.GetEnumerator();
    }

    public static int Depht(No No) {
        if (IsRoot(No)) {
            return 0;
        }
        return 1 + Depht(Parent(No));
    }

    public static int Height(No R, No No) {
        if (IsExternal(No)) {
            return 0;
        }
        int H = 0;
        IEnumerator<No> F = Children(No);
        while (F.MoveNext()) {
            No W = F.Current;
            H = Math.Max(H, Height(R, W));
        }
        return 1+H;
    }

    public static No LeftChild(No No) {
        return No.FilhoEsquerdo;
    }

    public static No RightChild(No No) {
        return No.FilhoDireito;
    }

    public static bool HasLeft(No No) {
        if (LeftChild(No) == null) {
            return true;
        }
        return false;
    }

    public static bool HasRight(No No) {
        if (RightChild(No) == null) {
            return true;
        }
        return false;
    }

    public IEnumerator<int> ElementsIterator() {
        List<int> Elementos = new();
        foreach (No N in Nos) {
            Elementos.Add(N.Elemento);
        }
        return Elementos.GetEnumerator();
    }

    public IEnumerator<No> NosIterator() {
        return Nos.GetEnumerator();
    }

    public void Visite(No No) {
        Console.WriteLine(No.Elemento);
    }

    public void PreOrder(No No){
        if (No == null){
            return;
        }
        Visite(No);
        PreOrder(LeftChild(No));
        PreOrder(RightChild(No));
    }

    public void PostOrder(No No) {
        if (No == null) {
            return;
        }
        PostOrder(LeftChild(No));
        PostOrder(RightChild(No));
        Visite(No);
    }

    public void InOrder(No No) {
        if (No == null) {
            return;
        }
        InOrder(LeftChild(No));
        Visite(No);
        InOrder(RightChild(No));
    }

    public static No Search(int K, No No) {
        if (K == No.Elemento) { return No; }
        if (K < No.Elemento && No.FilhoEsquerdo != null){ return Search(K, No.FilhoEsquerdo); }
        if (K > No.Elemento && No.FilhoDireito != null){ return Search(K, No.FilhoDireito); }
        return No;
    }

    public void Insert(int K, No No) {
        No Encontrado = Search(K, No);
        if (Encontrado.Elemento == K){
            throw new Excecao("Erro! Nó já existente");
        }
        No Novo = new(null, null, null, K);

        if (Novo.Elemento < Encontrado.Elemento) {
            Encontrado.FilhoEsquerdo = Novo;
        }
        else {
            Encontrado.FilhoDireito = Novo;
        }
        Nos.Add(Novo);
        Size++;
    }

    public int Remove(No No) {
        int Element = No.Elemento;

        if (IsExternal(No) && No != null) {
            if (No.Elemento < No.Pai.Elemento) {
                No.Pai.FilhoEsquerdo = null;
            }
            else {
                No.Pai.FilhoDireito = null;
            }
            Size--;
            Nos.Remove(No);
            return Element;
        }

        if (No.FilhoEsquerdo == null || No.FilhoDireito == null) {
            No Filho;
            if (No.FilhoEsquerdo != null) {
                Filho = No.FilhoEsquerdo;
            }
            else {
                Filho = No.FilhoDireito;
            }
            Filho.Pai = No.Pai;
            if (Filho.Elemento < No.Pai.Elemento) {
                No.Pai.FilhoEsquerdo = Filho;
            }
            else {
                No.Pai.FilhoDireito = Filho;
            }
            Size--;
            Nos.Remove(No);
            return Element;
        }

        No Sucessor = No.FilhoDireito;
        while (Sucessor.FilhoEsquerdo != null) {
            Sucessor = Sucessor.FilhoEsquerdo;
        }
        int Temp = Sucessor.Elemento;
        Remove(Sucessor);
        No.Elemento = Temp;
        return Element;
    }

    private void PreencherMatriz(No no, int[,] matriz, int linha, int coluna, int deslocamento) {
        if (no == null || linha >= matriz.GetLength(0) || coluna < 0 || coluna >= matriz.GetLength(1)) return;
        if (deslocamento < 1) deslocamento = 1;

        matriz[linha, coluna] = no.Elemento;

        PreencherMatriz(
            no.FilhoEsquerdo,
            matriz,
            linha + 1,
            coluna - deslocamento,
            deslocamento / 2
        );

        PreencherMatriz(
            no.FilhoDireito,
            matriz,
            linha + 1,
            coluna + deslocamento,
            deslocamento / 2
        );
    }

    public void ImprimirArvore() {
        int h = Height(Raiz, Raiz);
        int linhas = h + 1;
        int colunas = (int)Math.Pow(2, h + 2) - 1;
        int[,] matriz = new int[linhas, colunas];
        
        PreencherMatriz(Raiz, matriz, 0, colunas / 2, colunas / 4);

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                if (matriz[i, j] == 0) 
                    Console.Write("    ");
                else                   
                    Console.Write($"{matriz[i, j],4}");
            }
            Console.WriteLine();
        }
    }

}