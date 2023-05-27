package tuan7_30_XML;

import java.util.Scanner;

public class Testing {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int luaChon;
		ManageProduct dom = new ManageProduct();
		boolean flag = true;
		do {
			menu();
			luaChon = sc.nextInt();
			switch (luaChon) {
			case 1: {
				sc.nextLine();
				Product p = createNewProduct();
				dom.addProduct(p);
				break;
			}
			case 2: {
				sc.nextLine();
				System.out.println("Enter productID: ");
				String productID = sc.nextLine();
				dom.deleteProduct(productID);
				break;
			}
			case 3: {
				sc.nextLine();
				System.out.println("Enter productID: ");
				String productID = sc.nextLine();
				System.out.println("Enter new price: ");
				double gia = sc.nextDouble();
				dom.updatePrice(productID, gia);
				break;
			}
			case 4:
				dom.printAll();
				break;
			case 5: {
				dom.writeXMLFile();
				break;
			}
			default:
				flag = false;
				break;
			}
		} while (flag);
	}

	private static void menu() {
		System.out.println("1. Add produce");
		System.out.println("2. Delete produce");
		System.out.println("3. Update produce");
		System.out.println("4. Print produce");
		System.out.println("5. Write XML produce");
		System.out.println("0. Exit");
		System.out.println("Your choice: ");
	}

	private static Product createNewProduct() {
		System.out.println("Enter productID: ");
		String productID = sc.nextLine();
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter manufacture: ");
		String manufacture = sc.nextLine();
		System.out.println("Enter description: ");
		String description = sc.nextLine();
		Suplier suplier = createNewSuplier();
		System.out.println("Enter price: ");
		double price = sc.nextDouble();
		return new Product(productID, name, manufacture, description, price, suplier);
	}

	private static Suplier createNewSuplier() {
		System.out.println("Enter suplier name: ");
		String suplierName = sc.nextLine();
		System.out.println("Enter country: ");
		String country = sc.nextLine();
		System.out.println("Enter website: ");
		String website = sc.nextLine();
		return new Suplier(suplierName, country, website);
	}
}
