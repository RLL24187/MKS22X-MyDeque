public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }

  //spaces after every element
  //toString O(n) - format:  {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}  (space after each value)
  public String toString(){
    if (size == 0) return "{}";
    String output = "{";
    for (int i = 0; i < size; i++){
      output += E[i] + " ";
    }
    return output + "}";
  }

  //With commas and standard spacing
  public String myToString(){
    if (size == 0) return "{}";
    String output = "{";
    for (int i = 0; i < size; i++){
      output += E[i];
      if (i != size - 1){
        output += ", ";
      }
    }
    return output + "}";
  }
  public void addFirst(E element){

  }
  public void addLast(E element){

  }
  public E removeFirst(){
    //NoSuchElementException - if this deque is empty
    if (size == 0){
      throw new NoSuchElementException;
    }
    Add(both first and last) will throw:
    NullPointerException - if the specified element is null (this deque does not permit null elements)
  }
  public E removeLast(){
    NoSuchElementException - if this deque is empty
    Add(both first and last) will throw:
    NullPointerException - if the specified element is null (this deque does not permit null elements)

  }
  public E getFirst(){
    return E[start]
  }
  public E getLast(){
    return E[end];
  }
  /*Notes
  remove/get  (both first and last) will throw:
NoSuchElementException - if this deque is empty
Add(both first and last) will throw:
NullPointerException - if the specified element is null (this deque does not permit null elements)

To create a generic array you need to create an array of Object, and then cast it to E. This causes a warning, and you can use the SuppressWarnings command to prevent it. This is an appropriate use of the command because we need to instantiate an array of objects and cast it. You would not use this in most other cases.

Suppress the warning in the constructor:

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

OR suppress the warning on the creation of the array, but you cannot directly assign to the instance variable if you do this. (This would prevent the accidental suppresion of additional warnings)

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }

  */
}
