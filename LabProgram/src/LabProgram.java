import java.util.Scanner;

public class LabProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();
        while(scnr.hasNext()){
            int p, r, p2 = 0;
            p= scnr.nextInt();
            r= scnr.nextInt();
            p2= scnr.nextInt();
            vm.purchase(p);
            vm.restock(r);
            vm.purchase(p2);
            vm.report();
            int base = 20 - vm.getInventory();
            vm.restock(base);
        }
    }
}
