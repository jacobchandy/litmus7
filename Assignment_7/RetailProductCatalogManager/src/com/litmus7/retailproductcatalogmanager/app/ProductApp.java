package com.litmus7.retailproductcatalogmanager.app;

import java.util.Scanner;

import com.litmus7.retailproductcatalogmanager.dto.Product;

public class ProductApp {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n --- Product Manager ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                	System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter stock quantity: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); 

                    Product product = new Product(productId, name, category, price, stock);
                    break;

                case 2:
                    System.out.print("Enter product ID to search: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
             
                    break;

                case 3:
                    
                    break;

                case 4:
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new category: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new stock quantity: ");
                    int newStock = scanner.nextInt();
                    scanner.nextLine();

                   
                    break;

                case 5:
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    
                    break;

                case 6:
                    System.out.println("Exited");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}