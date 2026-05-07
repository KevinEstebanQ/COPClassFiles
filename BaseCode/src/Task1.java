import java.util.ArrayList;
import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Task1 {
    public static ArrayList<Integer> findDominant(int[] Arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        int Min = 0;
        for(int i = Arr.length - 1; i >= 0; i--) {
            if(Arr[i] > Min){
                temp.add(Arr[i]);
                Min = Arr[i];
            }
        }
        Collections.reverse(temp);
        return temp;
    }
    public static void main(String[] args) {
        int[] arr ={16,17,4,3,5,2};
        System.out.println(findDominant(arr).toString());
    }
}
//change