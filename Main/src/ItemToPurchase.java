  public class ItemToPurchase{
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;

    public ItemToPurchase(){
        itemName = "";
        itemPrice = 0;
        itemQuantity = 0;
        itemDescription = "none";
    }
    public ItemToPurchase(String name, String desc, int price, int qty){
          itemName = name;
          itemPrice = price;
          itemQuantity = qty;
          itemDescription = desc;
      }
    public void setName(String name){this.itemName = name;}
    public String getName(){return this.itemName;}
    public void setPrice(int price){this.itemPrice = price;}
    public int getPrice(){return this.itemPrice;}
    public void setQuantity(int qty){this.itemQuantity = qty;}
    public int getQuantity(){return itemQuantity;}
    public void setDescription(String itemDescription){this.itemDescription = itemDescription;}
    public String getDescription(){return this.itemDescription;}

    public void printItemCost(){
        int total = getQuantity() * getPrice();
        System.out.println(getName() + " " + getQuantity() + " @ $"+
            getPrice() + " = $" + total);
    }
    public void printItemDescription(){
        System.out.println(getName() + ": " + getDescription());
    }
}