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
	
    public static void main(String[] args) {

        while (true) {
            System.out.println("Please input your member ID [input 0 for guest]: ");

            int memberID = scanner.nextInt();
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