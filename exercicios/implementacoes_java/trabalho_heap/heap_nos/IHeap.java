package heap_nos;

public interface IHeap {
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract Item min();
    public abstract void insert(Item o);
    public abstract Item removeMin();
}
