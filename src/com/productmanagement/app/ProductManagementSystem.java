package com.productmanagement.app;
import java.util.ArrayList;

public class ProductManagementSystem {
    private static ArrayList<Product> productList = new ArrayList<>();
    private static ArrayList<Production> productionList = new ArrayList<>();
    private static ArrayList<Order> orderList = new ArrayList<>();
    private static ArrayList<Payment> paymentList = new ArrayList<>();
    private static ArrayList<Customer> customerList = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do{
            System.out.println("\n================================");
            System.out.println("Product Management System Menu");
            System.out.println("\n================================");
            System.out.println("1. Product Information");
            System.out.println("2. Production Information");
            System.out.println("3. Order Information");
            System.out.println("4. Payment Information");
            System.out.println("5. Customer Information");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = readInt();

            switch(choice){
                case 1: productMenu(); break;
                case 2:ProductionMenu();break;
                case 3:orderMenu();break;
                case 4:paymentMenu();break;
                case 5: customerMenu();break;
                default:
                    System.out.println("please Enter a valid option"   );
            }


        } while(choice != 0);
        sc.close();
    }

    static void productMenu(){
        int choice;
        do{
            System.out.println("\n-- Products --");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = readInt();

            if (choice == 1) {
                addProduct();
            } else if (choice == 2) {
                viewAllProducts();
            } else if (choice == 3) {
                updateProduct();
            } else if (choice == 4) {
                deleteProduct();
            } else if (choice != 0) {
                System.out.println("Please enter a valid option.");
            }

        } while (choice != 0);
    }





    }

