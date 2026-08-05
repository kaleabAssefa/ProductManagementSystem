package com.productmanagement.app;
import com.productmanagement.model.Product;
import com.productmanagement.model.Production;
import com.productmanagement.model.Order;
import com.productmanagement.model.Payment;
import com.productmanagement.model.Person;
import com.productmanagement.model.Customer;
import java.util.Scanner;

import java.util.ArrayList;


/**
 * ProductManagementSystem.java
 * -----------------------------
 * This is the MAIN class - the entry point of the application
 * (it contains the "public static void main" method).
 *
 * WHAT THIS CLASS DOES:
 * 1. Holds ArrayLists that store all our data in memory
 *    (Products, Production records, Orders, Payments, Customers).
 * 2. Shows a text menu to the user using a "while" loop that keeps
 *    running until the user chooses "Exit".
 * 3. Based on the user's choice, a "switch" statement decides which
 *    sub-menu / operation to run.
 * 4. Each module (Product / Production / Order / Payment) has its own
 *    ADD / VIEW / UPDATE / DELETE methods that operate on the ArrayLists.
 *
 * WHY ArrayList?
 * ArrayList is a resizable array from Java's Collections Framework.
 * Unlike a normal array (int[] arr = new int[5]), an ArrayList can grow
 * or shrink automatically as we add or remove items - perfect for
 * managing an unknown number of products/orders/payments.
 */
public class ProductManagementSystem {

    // ---------- Data storage (ArrayLists) ----------
    private static ArrayList<Product> productList = new ArrayList<>();
    private static ArrayList<Production> productionList = new ArrayList<>();
    private static ArrayList<Order> orderList = new ArrayList<>();
    private static ArrayList<Payment> paymentList = new ArrayList<>();
    private static ArrayList<Customer> customerList = new ArrayList<>();

    // A single Scanner shared by the whole program to read user input
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Load a few sample records so the menus have something to show
        // the first time you run the program. This is optional -
        // feel free to delete this call once you understand the code.
        loadSampleData();

        int mainChoice;

        // MAIN MENU LOOP
        // "do-while" runs the menu at least once, and keeps repeating
        // until the user enters 0 (Exit).
        do {
            System.out.println("\n=====================================");
            System.out.println("   PRODUCT MANAGEMENT SYSTEM - MENU  ");
            System.out.println("=====================================");
            System.out.println("1. Product Information");
            System.out.println("2. Production Information");
            System.out.println("3. Order Information");
            System.out.println("4. Payment Information");
            System.out.println("5. Customer Information");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            mainChoice = readInt();

            // switch-case controls which module menu opens
            switch (mainChoice) {
                case 1:
                    productMenu();
                    break;
                case 2:
                    productionMenu();
                    break;
                case 3:
                    orderMenu();
                    break;
                case 4:
                    paymentMenu();
                    break;
                case 5:
                    customerMenu();
                    break;
                case 0:
                    System.out.println("Thank you for using the Product Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (mainChoice != 0);

        sc.close();
    }

    // =====================================================================
    //  PRODUCT MODULE
    // =====================================================================
    private static void productMenu() {
        int choice;
        do {
            System.out.println("\n----- PRODUCT INFORMATION -----");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: viewAllProducts(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = readInt();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = readDouble();
        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        Product p = new Product(id, name, category, price, description);
        productList.add(p); // ArrayList.add() -> stores the new object
        System.out.println("Product added successfully!");
    }

    private static void viewAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        // "for-each" loop: goes through every element in the ArrayList
        for (Product p : productList) {
            p.displayProduct();
        }
    }

    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = readInt();
        // POLYMORPHISM (method overloading) - here we call the version
        // of findProduct that accepts an int id. See the overloaded
        // methods further below.
        Product p = findProduct(id);

        if (p == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new Name (" + p.getProductName() + "): ");
        p.setProductName(sc.nextLine());
        System.out.print("Enter new Category (" + p.getCategory() + "): ");
        p.setCategory(sc.nextLine());
        System.out.print("Enter new Price (" + p.getPrice() + "): ");
        p.setPrice(readDouble());
        System.out.print("Enter new Description (" + p.getDescription() + "): ");
        p.setDescription(sc.nextLine());

        System.out.println("Product updated successfully!");
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = readInt();
        Product p = findProduct(id);

        if (p == null) {
            System.out.println("Product not found.");
            return;
        }
        productList.remove(p); // ArrayList.remove() -> deletes the object
        System.out.println("Product deleted successfully!");
    }

    /**
     * POLYMORPHISM EXAMPLE - METHOD OVERLOADING
     * Two methods with the SAME NAME (findProduct) but DIFFERENT
     * parameter types/lists. Java decides which one to run based on
     * what you pass in. This is called "compile-time polymorphism".
     */
    private static Product findProduct(int productId) {
        for (Product p : productList) {
            if (p.getProductId() == productId) {
                return p;
            }
        }
        return null;
    }

    private static Product findProduct(String productName) {
        for (Product p : productList) {
            if (p.getProductName().equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }

    // =====================================================================
    //  PRODUCTION MODULE
    // =====================================================================
    private static void productionMenu() {
        int choice;
        do {
            System.out.println("\n----- PRODUCTION INFORMATION -----");
            System.out.println("1. Add Production Record");
            System.out.println("2. View All Production Records");
            System.out.println("3. Update Production Status");
            System.out.println("4. Delete Production Record");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {
                case 1: addProduction(); break;
                case 2: viewAllProduction(); break;
                case 3: updateProductionStatus(); break;
                case 4: deleteProduction(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addProduction() {
        System.out.print("Enter Production ID: ");
        int id = readInt();
        System.out.print("Enter Product ID this production belongs to: ");
        int productId = readInt();

        // Basic validation: make sure the product actually exists first
        if (findProduct(productId) == null) {
            System.out.println("No such Product ID exists. Add the product first.");
            return;
        }

        System.out.print("Enter Quantity Produced: ");
        int qty = readInt();
        System.out.print("Enter Production Status (In Progress / Completed): ");
        String status = sc.nextLine();

        Production prod = new Production(id, productId, qty, status);
        productionList.add(prod);
        System.out.println("Production record added successfully!");
    }

    private static void viewAllProduction() {
        if (productionList.isEmpty()) {
            System.out.println("No production records found.");
            return;
        }
        for (Production prod : productionList) {
            prod.displayProduction();
        }
    }

    private static void updateProductionStatus() {
        System.out.print("Enter Production ID to update: ");
        int id = readInt();
        Production prod = findProduction(id);

        if (prod == null) {
            System.out.println("Production record not found.");
            return;
        }
        System.out.print("Enter new Status: ");
        prod.setProductionStatus(sc.nextLine());
        System.out.println("Production status updated!");
    }

    private static void deleteProduction() {
        System.out.print("Enter Production ID to delete: ");
        int id = readInt();
        Production prod = findProduction(id);

        if (prod == null) {
            System.out.println("Production record not found.");
            return;
        }
        productionList.remove(prod);
        System.out.println("Production record deleted successfully!");
    }

    private static Production findProduction(int productionId) {
        for (Production prod : productionList) {
            if (prod.getProductionId() == productionId) {
                return prod;
            }
        }
        return null;
    }

    // =====================================================================
    //  ORDER MODULE
    // =====================================================================
    private static void orderMenu() {
        int choice;
        do {
            System.out.println("\n----- ORDER INFORMATION -----");
            System.out.println("1. Create Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Update Order Status");
            System.out.println("4. Delete Order");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {
                case 1: createOrder(); break;
                case 2: viewAllOrders(); break;
                case 3: updateOrderStatus(); break;
                case 4: deleteOrder(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void createOrder() {
        System.out.print("Enter Order ID: ");
        int id = readInt();
        System.out.print("Enter Customer ID: ");
        int custId = readInt();
        System.out.print("Enter Product ID: ");
        int productId = readInt();

        Product p = findProduct(productId);
        if (p == null) {
            System.out.println("No such Product ID exists. Cannot create order.");
            return;
        }

        System.out.print("Enter Quantity: ");
        int qty = readInt();
        System.out.print("Enter Order Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        Order order = new Order(id, custId, productId, qty, date, "Placed");
        // Business logic: calculate total using the product's price
        order.calculateTotalAmount(p.getPrice());

        orderList.add(order);
        System.out.println("Order created successfully! Total Amount = Rs. " + order.getTotalAmount());
    }

    private static void viewAllOrders() {
        if (orderList.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        for (Order order : orderList) {
            order.displayOrder();
        }
    }

    private static void updateOrderStatus() {
        System.out.print("Enter Order ID to update: ");
        int id = readInt();
        Order order = findOrder(id);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }
        System.out.print("Enter new Status (Placed/Shipped/Delivered/Cancelled): ");
        order.setOrderStatus(sc.nextLine());
        System.out.println("Order status updated!");
    }

    private static void deleteOrder() {
        System.out.print("Enter Order ID to delete: ");
        int id = readInt();
        Order order = findOrder(id);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }
        orderList.remove(order);
        System.out.println("Order deleted successfully!");
    }

    private static Order findOrder(int orderId) {
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    // =====================================================================
    //  PAYMENT MODULE
    // =====================================================================
    private static void paymentMenu() {
        int choice;
        do {
            System.out.println("\n----- PAYMENT INFORMATION -----");
            System.out.println("1. Add Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. Update Payment Status");
            System.out.println("4. Delete Payment");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {
                case 1: addPayment(); break;
                case 2: viewAllPayments(); break;
                case 3: updatePaymentStatus(); break;
                case 4: deletePayment(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addPayment() {
        System.out.print("Enter Payment ID: ");
        int id = readInt();
        System.out.print("Enter Order ID this payment is for: ");
        int orderId = readInt();

        Order order = findOrder(orderId);
        if (order == null) {
            System.out.println("No such Order ID exists. Cannot add payment.");
            return;
        }

        System.out.print("Enter Payment Method (Cash/Card/UPI): ");
        String method = sc.nextLine();
        System.out.print("Enter Payment Status (Paid/Pending/Failed): ");
        String status = sc.nextLine();

        // We use the order's total amount as the amount paid
        Payment payment = new Payment(id, orderId, order.getTotalAmount(), method, status);
        paymentList.add(payment);
        System.out.println("Payment record added successfully!");
    }

    private static void viewAllPayments() {
        if (paymentList.isEmpty()) {
            System.out.println("No payment records found.");
            return;
        }
        for (Payment payment : paymentList) {
            payment.displayPayment();
        }
    }

    private static void updatePaymentStatus() {
        System.out.print("Enter Payment ID to update: ");
        int id = readInt();
        Payment payment = findPayment(id);

        if (payment == null) {
            System.out.println("Payment record not found.");
            return;
        }
        System.out.print("Enter new Payment Status: ");
        payment.setPaymentStatus(sc.nextLine());
        System.out.println("Payment status updated!");
    }

    private static void deletePayment() {
        System.out.print("Enter Payment ID to delete: ");
        int id = readInt();
        Payment payment = findPayment(id);

        if (payment == null) {
            System.out.println("Payment record not found.");
            return;
        }
        paymentList.remove(payment);
        System.out.println("Payment record deleted successfully!");
    }

    private static Payment findPayment(int paymentId) {
        for (Payment payment : paymentList) {
            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        return null;
    }

    // =====================================================================
    //  CUSTOMER MODULE (demonstrates Inheritance / Polymorphism usage)
    // =====================================================================
    private static void customerMenu() {
        int choice;
        do {
            System.out.println("\n----- CUSTOMER INFORMATION -----");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {
                case 1: addCustomer(); break;
                case 2: viewAllCustomers(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = readInt();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();

        Customer customer = new Customer(id, name, contact);
        customerList.add(customer);
        System.out.println("Customer added successfully!");
    }

    private static void viewAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        // Because Customer extends Person, we could also store these in an
        // ArrayList<Person> and call displayDetails() polymorphically.
        // Here we loop through Customers directly for simplicity.
        for (Customer customer : customerList) {
            customer.displayDetails(); // calls Customer's overridden version
        }
    }

    // =====================================================================
    //  HELPER METHODS (input handling)
    // =====================================================================

    /**
     * Safely reads an integer from the user.
     * We wrap Scanner's nextInt() in a try-catch because if the user types
     * text instead of a number, nextInt() would normally crash the program
     * with an exception. Here we catch that and ask again.
     */
    private static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, please enter again: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, please enter again: ");
            }
        }
    }

    /**
     * Adds a few starter records so you can immediately try
     * "View All..." options without manually typing data first.
     */
    private static void loadSampleData() {
        productList.add(new Product(101, "Laptop", "Electronics", 55000.0, "15-inch business laptop"));
        productList.add(new Product(102, "Office Chair", "Furniture", 4500.0, "Ergonomic mesh chair"));

        productionList.add(new Production(1, 101, 50, "Completed"));
        productionList.add(new Production(2, 102, 30, "In Progress"));

        customerList.add(new Customer(1, "Ravi Kumar", "9876543210"));

        Order order = new Order(1001, 1, 101, 2, "01-08-2026", "Placed");
        order.calculateTotalAmount(55000.0);
        orderList.add(order);

        paymentList.add(new Payment(1, 1001, order.getTotalAmount(), "UPI", "Paid"));
    }
}