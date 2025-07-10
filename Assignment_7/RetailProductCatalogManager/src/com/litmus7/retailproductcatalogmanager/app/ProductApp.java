package com.litmus7.retailproductcatalogmanager.app;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retailproductcatalogmanager.controller.ProductController;
import com.litmus7.retailproductcatalogmanager.dto.Product;
import com.litmus7.retailproductcatalogmanager.dto.ProductResponse;

/**
 * Main entry point for the RetailMart Product Catalog Manager. Provides a
 * console-based menu for adding, retrieving, updating, deleting products in the
 * catalog.
 */
public class ProductApp {
	public static void main(String[] args) {
		ProductController productController = new ProductController();
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
				System.out.println("Enter Product ID: ");
				int productId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter name: ");
				String name = scanner.nextLine();
				System.out.println("Enter category: ");
				String category = scanner.nextLine();
				System.out.println("Enter price: ");
				double price = scanner.nextDouble();
				System.out.println("Enter stock quantity: ");
				int stockQuantity = scanner.nextInt();
				scanner.nextLine();

				ProductResponse<Void> response1 = productController
						.addProduct(new Product(productId, name, category, price, stockQuantity));

				if (response1.getStatusCode() == 200) {
					System.out.println(response1.getSuccessMessage());
				} else {
					System.out.println(response1.getErrorMessage());
				}
				break;

			case 2:
				System.out.println("Enter product ID to search: ");
				int productIdSearch = scanner.nextInt();
				scanner.nextLine();

				ProductResponse<Product> response2 = productController.getProduct(productIdSearch);

				if (response2.getStatusCode() == 200) {
					System.out.println("Product Details");
					System.out.println("ID: " + response2.getData().getProductId());
					System.out.println("Name: " + response2.getData().getName());
					System.out.println("Category: " + response2.getData().getCategory());
					System.out.println("Price: " + response2.getData().getPrice());
					System.out.println("Stock: " + response2.getData().getStockQuantity());

				} else {
					System.out.println(response2.getErrorMessage());
				}

				break;

			case 3:
				ProductResponse<List<Product>> response3 = productController.getAllProducts();
				if (response3.getStatusCode() == 200) {
					List<Product> products = response3.getData();
					for (Product product : products) {
						System.out.println(product);
					}
				} else {
					System.out.println(response3.getErrorMessage());
				}
				break;

			case 4:
				System.out.println("Enter product ID to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();

				ProductResponse<Product> response4 = productController.getProduct(updateId);

				if (response4.getStatusCode() == 200) {

					System.out.printf("Enter new name: (current name: %s):", response4.getData().getName());
					String newName = scanner.nextLine();
					System.out.printf("Enter new category: (current category: %s):", response4.getData().getCategory());
					String newCategory = scanner.nextLine();
					System.out.printf("Enter new price (current price: %1.f): ", response4.getData().getPrice());
					double newPrice = scanner.nextDouble();
					System.out.printf("Enter new stock (current: %d):", response4.getData().getStockQuantity());
					int newStock = scanner.nextInt();
					scanner.nextLine();

					ProductResponse<Void> response5 = productController
							.updateProduct(new Product(updateId, newName, newCategory, newPrice, newStock));
					if (response5.getStatusCode() == 200) {
						System.out.println(response5.getSuccessMessage());
					} else {
						System.out.println(response5.getErrorMessage());
					}
				} else {
					System.out.println(response4.getErrorMessage() + " Update Failed");
				}

				break;

			case 5:
				System.out.print("Enter product ID to delete: ");
				int deleteId = scanner.nextInt();
				scanner.nextLine();

				ProductResponse<Void> response6 = productController.deleteProduct(deleteId);

				if (response6.getStatusCode() == 200) {
					System.out.println(response6.getSuccessMessage());
				} else {
					System.out.println(response6.getErrorMessage());
				}
				break;

			case 6:
				System.out.println("Thank you for using RetailMart Product Catalog Manager.\nGoodbye");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}