package 单子2;

import java.util.Locale;
import java.util.Scanner;

public class OrderSystem {
	private static Scanner sc;
	private static LinkedList orders = new LinkedList();
	private static int nextGuestID = 9000;
    public static Scanner scanner = new Scanner(System.in);

    public static void menu1() {
        System.out.println("----------------- Food Menu ----------------");
        System.out.println("Set A : Chicken Salad");
        System.out.println("Set B : Grilled Ribeye Steak");
        System.out.println("Set C : Angel Hair Pasta with Shrimp");
        System.out.println("Set D : Grilled Fish and Potatoes");
        System.out.println("--------------------------------------------");
        System.out.println("Select food: ");
    }
    public static void menu2() {
        System.out.println("----------------- Admin Function ----------------");
        System.out.println("1 : Print order list");
        System.out.println("2 : Remove order");
    }
    public static void menu3(LinkedList orders) {
        System.out.println("--------------------------------------");
        System.out.print(orders.toString());
        System.out.println("--------------------------------------");
        System.out.println("Total outstanding order: " + orders.count());
    }
    public static void menu4(LinkedList orders) {
        System.out.println("Enter Member ID: ");
        int memberID = scanner.nextInt();
        orders.remove(memberID);

    }
    // Check whether the entered memberID is valid
    public static boolean isInputMemberIDValid(int memberID) {
        if (memberID < 8000 && memberID != 0) {
            return false;
        }
        return true;
    }
    public static boolean isInputOrderValid(String order) {
        if (order.length() != 1) {
            return false;
        }
        // If the input value is A-D, then it minus A must be 0-3
        int i = order.charAt(0) - 'A';
        if (i >= 0 && i <= 3) {
            return true;
        } else {
            return false;
        }
    }
	
    public static void main(String[] args) {

        while (true) {
            System.out.println("Please input your member ID [input 0 for guest]: ");

            int memberID = scanner.nextInt();
            // If the entered memberID is invalid, ask user to enter it again
            if (!isInputMemberIDValid(memberID)) {
                System.out.println("Invalid input!Please input again");
                continue;
            }
            if(memberID == -1) {
                System.out.println("Have a nice day!!!");
                break;
            }
            if (memberID != 9999) {
                if (memberID == 0) {
                    memberID = nextGuestID++;
                }
                menu1();
                String food = scanner.next().toUpperCase(Locale.ROOT);
                if (!isInputOrderValid(food)) {
                    System.out.println("Invalid input!Please input again");
                    continue;
                }
                FoodOrder foodOrder = new FoodOrder(memberID, food);
                if (orders.isEmpty()) {
                    orders.addToHead(foodOrder);
                } else {
                    orders.add(foodOrder);
                }
            } else {
                menu2();
                int select = scanner.nextInt();
                if (select == 1) {
                    menu3(orders);
                } else {
                    menu4(orders);
                }

            }


        }



    }
    

    		
    
}