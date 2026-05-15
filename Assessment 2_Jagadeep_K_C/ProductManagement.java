package Assessment;

import java.util.*;

abstract class Product {
	int productId;
	String productName;
	double price;

	Product(int productId, String productName, double price) {
		this.price = price;
		this.productId = productId;
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	abstract void displayInfo();
}

class ElectronicProduct extends Product {
	int warrantyPeriod;

	ElectronicProduct(int warrantyPeriod, int productId, String productName, double price) {
		super(productId, productName, price);
		this.warrantyPeriod = warrantyPeriod;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void displayInfo() {
		System.out.println("ProductId: " + productId);
		System.out.println("ProductName: " + productName);
		System.out.println("Price: " + price);
		System.out.println("Warranty Period: " + warrantyPeriod);
	}
}

class ClothingProduct extends Product {
	String size;
	String material;

	ClothingProduct(String size, String material, int productId, String productName, double price) {
		super(productId, productName, price);
		this.size = size;
		this.material = material;
	}

	public String getSize() {
		return size;
	}

	public String getMaterial() {
		return material;
	}

	public void displayInfo() {
		System.out.println("ProductId: " + productId);
		System.out.println("ProductName: " + productName);
		System.out.println("Price: " + price);
		System.out.println("Size: " + size);
		System.out.println("Material: " + material);
	}
}

public class ProductManagement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ElectronicProduct e = null;

		ClothingProduct c = null;

		while (true) {
			System.out.println("Choose the Action:");
			System.out.println("1.Add Electronic Product");
			System.out.println("2.Add Clothing Product");
			System.out.println("3.Display Electronic Product");
			System.out.println("4.Display Electronic Product");
			System.out.println("5.Exit");
			
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("Enter ProductId:");
				int productId = sc.nextInt();

				sc.nextLine();

				System.out.println("Enter ProductName:");
				String productName = sc.nextLine();

				System.out.println("Enter Price:");
				double price = sc.nextDouble();

				System.out.println("Enter Warranty Period:");
				int warrantyPeriod = sc.nextInt();

				e = new ElectronicProduct(warrantyPeriod, productId, productName, price);
				System.out.println("Added Successfully...");
			}

			else if (choice == 2) {
				System.out.println("Enter ProductId:");
				int productId = sc.nextInt();

				sc.nextLine();

				System.out.println("Enter ProductName:");
				String productName = sc.nextLine();

				System.out.println("Enter Price:");
				double price = sc.nextDouble();

				sc.nextLine();

				System.out.println("Enter Size:");
				String size = sc.nextLine();

				System.out.println("Enter Material:");
				String material = sc.nextLine();

				c = new ClothingProduct(size, material, productId, productName, price);
				System.out.println("Added Successfully");
			} else if (choice == 3) {
				if (e != null)
					e.displayInfo();
				else
					System.out.println("Nothing is Added");
			} else if (choice == 4) {
				if (c != null)
					c.displayInfo();
				else
					System.out.println("Nothing is Added");
			}

			else if (choice == 5) {
				break;
			}
		}
		sc.close();
	}
}
