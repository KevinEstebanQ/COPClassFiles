import java.util.InputMismatchException;
import java.util.Scanner;

public class AnimalFarm {
    public static enum animalEnum {DOG, CAT, COW}
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Animal[] animalArr = new Animal[10];
        int animal_idx = 0;
        while (true) {
            System.out.println("Press 1 to view the animals, " +
								"\n2 to add animals, "+
								"\nany other key to exit");
            // ask user in
            String inputLine = sc.nextLine();

            //break if input is not "1" or "2"
            if ( !(inputLine.equals("1")) && !(inputLine.equals("2"))) {
                System.out.println("Thank you!");
                sc.close();
                break;
            }

            if (inputLine.equalsIgnoreCase("1")) {
                int n = animalArr.length;
                if (animalArr[0] == null) {
                    System.out.println("No animals to display.");
                    continue;
                } else {

                    for (int i = 0; i < n; i++) {
                        if (animalArr[i] != null) {
                            System.out.println(animalArr[i]);
                        }
                    }
                }
            }
            if (inputLine.equalsIgnoreCase("2")) {
                if (animal_idx == 10) {
                    System.out.println("List already has 10 animals");
                    break;
                }
                try{
                    System.out.println("Which animal do you want to create? \nPress 1 for dog,"+ 
                                "\n2 for cat " +
                                "\n3 for cow" );
                    int input = sc.nextInt();
                    sc.nextLine(); // consume the newline character after nextInt()
                    animalEnum animalChoice = animalEnum.values()[input-1];
                    switch (animalChoice) {
                        case DOG:
                            System.out.println("Adding new dog to list, what is their name?");
                            String dogName = sc.nextLine();
                            animalArr[animal_idx] = new Dog(dogName);
                            animalArr[animal_idx].setFood("dogfood");

                            animal_idx++;
                            break;
                        case CAT:
                            System.out.println("Adding new cat to list, what is their name?");
                            String catName = sc.nextLine();
                            animalArr[animal_idx] = new Cat(catName);
                            animalArr[animal_idx].setFood("catfood");
                            animal_idx++;
                            break;
                        case COW:
                            System.out.println("Adding new cow to list, what is their name?");
                            String cowName = sc.nextLine();
                            animalArr[animal_idx] = new Cow(cowName);
                            animalArr[animal_idx].setFood("cowfood");
                            animal_idx++;
                            break;
                        default:
                            break;
                    }
                } catch( InputMismatchException e){
                    System.out.println("Not a correct answer, try again...");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid choice, try again...");
                }
                }   
            }
        }
}
