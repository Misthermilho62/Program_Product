package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of product: ");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			String nameProduct = sc.next();
			System.out.print("Price: ");
			double priceProduct = sc.nextDouble();
			if (resp == 'c') {
				list.add(new Product(nameProduct, priceProduct));
			} else if (resp == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDateProduct = sdf.parse(sc.next());
				list.add(new UsedProduct(nameProduct, priceProduct, manufactureDateProduct));
			} else {
				System.out.print("Customs fee: ");
				double customsFeeProduct = sc.nextDouble();
				list.add(new ImportedProduct(nameProduct, priceProduct, customsFeeProduct));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();

	}

}
