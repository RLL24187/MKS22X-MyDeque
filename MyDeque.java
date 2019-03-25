public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  //--------------------------------Constructors--------------------------------//
  @SuppressWarnings("unchecked")
  public MyDeque(){
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }

  //Return size of deque
  public int size(){
    return size;
  }

  //-------------------------------toString()------------------------------//
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

  //----------------------------------------Add----------------------------------------//
  //Add(both first and last) will throw:
  //NullPointerException
  //if the specified element is null (this deque does not permit null elements)
  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("addFirst: Cannot add null!");
    }
    size++; //increase
    //only run if deque not empty
    if (size > 0){
      if (size == data.length) resize();
      // if start is at the start of the array
      if (start == 0) start = data.length - 1;
      else start--;
    }
    //add element to start
    data[start] = element;
    //increase size
    size++;
    }
  }
  public void addLast(E element){
    if (element == null){
      throw new NullPointerException("addLast: Cannot add null!");
    }
    //only run if deque not empty
    if (size > 0){
      if (size == data.length) resize();
      // if end is at the end of the array
      if (end == data.length - 1) end = 0;
      else end++;
    }
    // adding in last element
    data[end] = element;
    //increase size
    size++;//increase size
    }
  }

  //------------------------------------Remove--------------------------------------//
  //remove/get  (both first and last) will throw:
  //NoSuchElementException - if this deque is empty
  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException("removeFirst: deque empty!");
    }
  }
  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException("removeLast: deque empty!");
    }
  }
  //-------------------------------Gets----------------------------------//
  public E getFirst(){
    return E[start]
  }
  public E getLast(){
    return E[end];
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    //double the size of the temp array
    E[] temp = (E[]) new Object[size() * 2 + 1];
    int index = start;
    for (int i = 0; i < size; i++){
      // copy elements over
      temp[i] = data[index % data.length];
      index++;
    }
    start = 0;
    end = size - 1;
    data = temp;
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
