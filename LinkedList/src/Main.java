
public class Main {
    public static void main(String[] args){
        LinkedList l1 = new LinkedList<>();
        LinkedList l2 = new LinkedList<>();

        l1.addFirst(7);
        l1.insert(1,1);
        l1.insert(2,6);

        l2.addFirst(5);
        l2.insert(1,9);
        l2.insert(2,2);


        LinkedList newList = LinkedList.sumDigits(l1,l2);
        System.out.println(newList.toString());

        //task #1
        newList.reverse();
        System.out.println(newList.toString());
    }
}
