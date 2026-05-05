
package com.wip.view;

import java.util.Scanner;
import java.util.function.BiPredicate;

import com.wip.controller.ProductController;
import com.wip.controller.ProductInterface;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		String Username="Dharshan";
		String Password="1234";
		
		
		int attempts=0;
		boolean isAuthenticated=false;
		
		while(attempts<2) {
			System.out.println("Enter Username: ");
			String username=sc.next();
			
			System.out.println("Enter password: ");
			String password=sc.next();
			
			
			if(username.equals(Username) && password.equals(password)) {
				System.out.println("Login Successful");
				isAuthenticated=true;
				break;
				
			
			}else {
				attempts++;
				System.out.println("Wrong credentials");
				
				
				if(attempts<2) {
					System.out.println("Try Again...");
					
				}
			}
		}
		
		if(!isAuthenticated) {
			System.out.println("You have enterd wrong credentials 2 times. Access denied!");
		    System.exit(0);
		}
		

		System.out.println("Welcome to Ecommerce - App !!");
		ProductInterface pc = new ProductController();
		//Scanner sc = new Scanner(System.in);
		String continueChoice=null;
		
	//Bipredicate to check if input is "Y" or"y"  value    "Y" or "y"
		BiPredicate<String, String> checkContinue=(input, expected)->
		input.equalsIgnoreCase(expected);
		
		do {
			System.out.println("Enter your choice:");
			System.out.println("1. Add Product");
			System.out.println("2. View Product");
			System.out.println("3. Add Elec. Product");
			System.out.println("4. View Elec. Product");
			System.out.println("5. Update Product");
			System.out.println("6. Delete Product");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				pc.addProduct();
				break;
			}
			case 2: {

				pc.viewProduct();
				break;
			}
			case 3: {

				pc.viewProduct();
				break;
			}
			case 4: {

				pc.viewProduct();
				break;
			}
			case 5: {

				pc.updateProduct();
				break;
			}
			case 6: {

				pc.deleteProduct();
				break;
			}
			case 7:{
				pc.insertProductUsingProcedure();
				break;
			}
			case 8: {
				pc.getProductNameById();
				break;
			}
			default: {
				System.out.println("Choose the right choice ....");
			}
			}
			System.out.println("Do u wanna to continue? Y or y");
			continueChoice = sc.next();
			
		//Replacing condition  using Bipredicate	
		}while(checkContinue.test(continueChoice,"Y"));
		// while (continueChoice.equals("Y") || continueChoice.equals("y"));
		
		System.out.println("Thanks for using the system...");
		System.exit(0);
	}
}
