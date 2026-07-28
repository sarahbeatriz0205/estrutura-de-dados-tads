package exercicios;
import java.util.ArrayList;

class TratamentoEncadeamento{
    private Item itemUnico;
    private ArrayList<Item> item = new ArrayList<>();

    public TratamentoEncadeamento(Item itemUnico){
        this.itemUnico = itemUnico;
        item.add(this.itemUnico);
    }

    public ArrayList<Item> getItem(){
        return item;
    }
}