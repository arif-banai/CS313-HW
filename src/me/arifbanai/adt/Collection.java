package me.arifbanai.adt;

//Collection class provided by Adolfus Lapsys
public interface Collection<T> {
  public void insert(int index, T elem);
  public void prepend(T elem);
  public void append(T elem);

  public T get(int index);
  public T getFirst();
  public T getLast();

  public void remove(int index);
  public void removeFirst();
  public void removeLast();

  public int size();
  public boolean isEmpty();
}
