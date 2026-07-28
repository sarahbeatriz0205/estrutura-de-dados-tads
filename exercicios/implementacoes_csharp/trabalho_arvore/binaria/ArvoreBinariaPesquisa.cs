using System;
using System.Collections.Generic;
using System.ComponentModel;
namespace ArvoreBinaria;

public class ArvoreBinariaPesquisa {
    private NoArvore Raiz;
    private int Size;
    private List<NoArvore> Nos;

    public ArvoreBinariaPesquisa(int Elem) {
        Raiz = new NoArvore(null, null, null, Elem);
        Size = 1;
        Nos = [Raiz]; 
    }

    public int GetSize() {
        return Size;
    }

    public bool IsEmpty() {
        return Size == 0;
    }

    public NoArvore Root() {
        return Raiz;
    }

    public bool IsRoot(NoArvore No) {   
        if (No.GetPai() == null) {
            return true;
        }
        return false;
    }

    public bool IsExternal(NoArvore No) {
        if (No.GetFilhoEsquerdo() == null && No.GetFilhoDireito() == null) {
            return true;
        }
        return false;
    }

    public bool IsInternal(NoArvore No) {
        if (No.GetFilhoEsquerdo() != null || No.GetFilhoDireito() != null) {
            return true;
        }
        return false;
    }

    public NoArvore Parent(NoArvore No) {
        return No.GetPai();
    }

    public NoArvore Children(NoArvore No) {
        List<NoArvore> Filhos = new List<>();
        if (No.GetFilhoEsquerdo() != null) {
            Filhos.Add(No.GetFilhoEsquerdo());
        }
        if (No.GetFilhoDireito() != null) {
            Filhos.Add(No.GetFilhoDireito());
        }
        return Filhos.GetEnumerator();
    }

    public int Depht(NoArvore No) {
        if (IsRoot(No)) {
            return 0;
        }
        return 1 + Depht(Parent(No));
    }

    public int Height(NoArvore R, NoArvore No) {
        if (IsExternal(No)) {
            return 0;
        }
        int H = 0;
        IEnumerator<NoArvore> F = Children(No);
        while (f.MoveNext()) {
            NoArvore W = F.Current;
            H = Math.Max(H, Height(R, W));
        }
        return 1+H;
    }

    public NoArvore LeftChild(NoArvore No) {
        return No.GetFilhoEsquerdo();
    }

    public NoArvore RightChild(NoArvore No) {
        return No.GetFilhoDireito();
    }

    public HasLeft(NoArvore No) {
        if (LeftChild(No) = null) {
            return true;
        }
        return false;
    }

    public HasRight(NoArvore No) {
        if (RightChild(No) = null) {
            return true;
        }
        return false;
    }

    public IEnumerator<int> ElementsIterator() {
        List<int> Elementos = new List<>();
        foreach (NoArvore N in Nos) {
            Elementos.Add(N.GetElemento());
        }
        return Elementos.GetEnumerator();
    }

    public IEnumerator<NoArvore> NosIterator() {
        return Nos.GetEnumerator();
    }

    public void Visite(NoArvore No) {
        Console.WriteLine(No.GetElemento());
    }

    public void PreOrder(NoArvore No){
        if (No == null){
            return;
        }
        Visite(No);
        PreOrder(LeftChild(No));
        PreOrder(RightChild(No));
    }

    public void PostOrder(NoArvore No) {
        if (No == null) {
            return;
        }
        PostOrder(LeftChild(No));
        PostOrder(RightChild(No));
        Visite(No);
    }
}