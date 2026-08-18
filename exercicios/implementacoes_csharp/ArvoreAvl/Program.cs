using ArvoreBinariaPesquisa;
namespace ArvoreAvl
{
    public class ArvoreAvl : ArvoreBinariaPesquisa
    {
        public ArvoreAvl(int Elem) : base(new NoAvl(null, null, null, Elem, 0))
        {
            // aparentemente nenhum atributo novo pra a AVL
        }
    }
}
