
public class LinkedList <T>{

    private class Node<T>{
        private T data;
        private Node<T> next;
        private Node() {
            data = null;
            next = null;
        }
    }
    private int size;
    private Node<T> head;

    public LinkedList() {
        size = 0;
        head = null;
    }

    public void addFirst(T data) {
        insert(0,data);
    }

    public void addLast(T data) {
        insert(size-1,data);
    }

    public void add(T data) {
        addLast(data);
    }

    public void insert(int index, T data) {
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if(index == 0) {
            newNode.next = head;
            head = newNode;
            size ++;
            return;
        }
        Node<T> temp = head;
        for(int i=0; i<index-1; i++)
            temp = temp.next;
        newNode.next = temp.next;
        temp.next =  newNode;
        size++;
    }

    public void remove(int index) {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node<T> temp = head;
        for(int i=0; i<index-1; i++)
            temp = temp.next;
        Node<T> temp2 = temp.next;
        temp.next = temp2.next;
        size--;
    }

    public void removeFirst() {
        remove(0);
    }
    public void removeLast() {
        remove(size-1);
    }
    public void remove() {
        removeLast();
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        for(int i=0; i<index; i++)
            temp = temp.next;
        return temp.data;
    }

    public T getFirst() {
        return get(0);
    }
    public T getLast() {
        return get(size-1);
    }

    public void set(int index, T data) {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        for(int i=0; i<index; i++)
            temp = temp.next;
        temp.data = data;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(T data) {
        Node<T> temp = head;
        for(int i=0; i<size; i++) {
            if(temp.data.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public String toString() {
        String str = "[";
        if(head == null)
            return str + "]";
        Node<T> temp = head;
        while(temp.next != null) {
            str = str + temp.data + ", ";
            temp = temp.next;
        }
        str = str + temp.data + "]";
        return str;
    }

    //task #1
    public void reverse(){
        Node prev = null;
        Node next = head;
        Node current = head;

        while(next != null){
            next = current.next;
            current.next =prev;
            prev = current;
            current = next;

        }
        head = prev;
    }
    //task #2
    public static LinkedList sumDigits(LinkedList l1, LinkedList l2){
        LinkedList newList = new LinkedList<>();
        int carry=0;
        int i=0;

        //((l1.get(i) != null) | (l2.get(i) != null) | carry != 0) && (i < l1.size()) && (i < l2.size())
        while(i< l1.size() || i < l2.size() || carry > 0){

            int value1=(i < l1.size()) ? (int) l1.get(i) : 0 ;
            int value2=(i < l2.size()) ? (int) l2.get(i) : 0;



            int sum = value1 + value2 + carry;
            carry = sum >= 10 ? 1 : 0 ;
            sum = sum >= 10 ? sum - 10 : sum;

            if(newList.size() == 0){
                newList.addFirst(sum);
            } else {
                newList.insert(i, sum);
            }
            i++;
        }
        return newList;
    }

}
