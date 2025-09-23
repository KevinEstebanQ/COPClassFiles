import java.util.Locale;
import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String costumerName = "";
        String currentDate = "";

        System.out.println("Enter customer's name:");
        costumerName = scnr.nextLine();

        System.out.println("Enter today's date:");
        currentDate = scnr.nextLine();
        System.out.println();
        ShoppingCart shoppingCart = new ShoppingCart(costumerName, currentDate);
        System.out.println("Customer name: "+ shoppingCart.getCustomerName());
        System.out.println("Today's date: "+shoppingCart.getDate());
        System.out.println();
        printMenu();
        System.out.println("Choose an option:");

        while (scnr.hasNext()) {  // only loop if there is input
            String line = scnr.nextLine().trim().toLowerCase();
            if(line.isEmpty()){
                System.out.println("Choose an Option:");
                continue;
            }
            char input = line.charAt(0);

            if (input == 'q') {
                break;
            }

            if("adcio".indexOf(input) == -1){
                System.out.println("Choose an option:");
                continue;
            }

            executeMenu(input, shoppingCart, scnr);
            printMenu();
            System.out.println("Choose an option:");
        }

    }
    public static void printMenu(){

        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
        System.out.println();

    }

    public static void executeMenu(char userChoice, ShoppingCart cart, Scanner scnr){
        String itemName="";
        String itemDescription="";
        int itemPrice=0;
        int itemQty=0;

        switch (userChoice){
            case 'a':
                System.out.println("ADD ITEM TO CART");

                System.out.println("Enter the item name:");

                itemName=scnr.nextLine().trim();

                System.out.println("Enter the item description:");
                itemDescription=scnr.nextLine().trim();

                System.out.println("Enter the item price:");
                itemPrice=scnr.nextInt();
                scnr.nextLine();

                System.out.println("Enter the item quantity:");
                itemQty=scnr.nextInt();
                scnr.nextLine();
                System.out.println();
                cart.addItem(new ItemToPurchase(itemName,itemDescription, itemPrice,itemQty));
                break;
            case 'd':
                System.out.println("REMOVE ITEM FROM CART");
                System.out.println("Enter name of item to remove:");
                itemName = scnr.nextLine().trim();
                cart.removeItem(itemName);
                break;

            case 'c':
                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name:");
                itemName = scnr.nextLine().trim();

                System.out.println("Enter the new quantity:");
                itemQty = scnr.nextInt();
                scnr.nextLine();

                ItemToPurchase newItem = new ItemToPurchase();
                newItem.setName(itemName);
                newItem.setQuantity(itemQty);
                cart.modifyItem(newItem);
                break;

            case 'i':
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                cart.printDescriptions();
                break;

            case 'o':
                System.out.println("OUTPUT SHOPPING CART");
                cart.printTotal();
                break;
            case 'q':
                System.exit(0);

        }
    }
}
