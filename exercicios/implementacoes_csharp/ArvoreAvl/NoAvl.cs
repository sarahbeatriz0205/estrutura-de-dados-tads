namespace ArvoreAvl;

public class NoAvl : No 
{
    public int Fb {get; set;}

    public NoAvl(No? FilhoEsquerdo, No? FilhoDireito, No? Pai, int Elemento, int Fb) : base(FilhoEsquerdo, FilhoDireito, Pai, Elemento)
    {
        this.Fb = Fb;
    }
}