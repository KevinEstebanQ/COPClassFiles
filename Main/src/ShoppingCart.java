import java.util.ArrayList;

public class ShoppingCart {
    private String costumerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> cartItems;

    public ShoppingCart(){
        costumerName = "none";
        currentDate = "January 1, 2016";
        cartItems = new ArrayList<>();
    }
    public ShoppingCart(String MyCostumerName, String MyDate){
        costumerName = MyCostumerName;
        currentDate = MyDate;
        cartItems = new ArrayList<>();
    }

    public String getCustomerName() {
        return costumerName;
    }

    public String getDate() {
        return currentDate;
    }
    public void addItem(ItemToPurchase item){
        this.cartItems.add(item);
    }
    public boolean removeItem(String itemName){
        if(cartItems.removeIf(x -> x.getName().equals(itemName))){
            System.out.println();
            return true;
        };
        System.out.println("Item not found in cart. Nothing removed.\n");
        return false;
    }

    public void modifyItem(ItemToPurchase item){
        boolean found = false;
        for (ItemToPurchase it : cartItems) {
            if (it.getName().equals(item.getName())) {
                found = true;
                if (item.getDescription() != null && !item.getDescription().equals("none")) {
                    it.setDescription(item.getDescription());
                }
                if (item.getPrice() != 0) {
                    it.setPrice(item.getPrice());
                }
                if (item.getQuantity() != 0) {
                    it.setQuantity(item.getQuantity());
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in cart. Nothing modified.\n");
        }
    }


    public int getNumItemsInCart(){
        int totalQuantity=0;
        for(ItemToPurchase item : cartItems){
            totalQuantity+=item.getQuantity();
        }
        return totalQuantity;
    }
    public int getCostOfCart(){
        int totalCartCost = 0;
        for (ItemToPurchase item : cartItems){
            totalCartCost+= item.getQuantity()*item.getPrice();
        }
        return totalCartCost;
    }

    public void printTotal(){
        System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate());
        System.out.println("Number of Items: "+getNumItemsInCart() + "\n");
        if (!cartItems.isEmpty()){
            for (ItemToPurchase item : cartItems) {
                item.printItemCost();
            }
            System.out.println();
            System.out.println("Total: $" + getCostOfCart());
            System.out.println();
            return;
        }
        System.out.println("SHOPPING CART IS EMPTY\n");
        System.out.println("Total: $0\n");

    }

    public void printDescriptions(){
        System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate());
        System.out.println();
        System.out.println("Item Descriptions");
        if(!cartItems.isEmpty()){
            for (ItemToPurchase item : cartItems) {
                item.printItemDescription();
            }
            System.out.println();
            return;
        }
        System.out.println("SHOPPING CART IS EMPTY");
    }

}
