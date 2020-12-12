package com.prototype;

import com.application.operations.ApplicationOperations;
import com.business.operations.*;
import com.exceptions.*;
import java.util.Scanner;

public class LockMePrototype {

	public static void main(String[] args) {

		boolean featureValid = false, operationValid = false;

		int operation;

		String directoryName;

		ApplicationOperations appOperations = new ApplicationOperations();
		LockMeDirectoryHandler directoryHandler = new LockMeDirectoryHandler();
		Scanner scan = new Scanner(System.in);

		System.out.println("*************************************");
		System.out.println("Welcome to LockMe.com Prototype \n");
		System.out.println("*************************************");
		System.out.println("Developer: Nicholas Auyeung");

		while (featureValid == false) {
			System.out.println("Main Menu \n");
			// output current directory
			System.out.println("Current directory");
			System.out.println("Enter the following feature you would like to access: ");
			System.out.println("(1) Display existing files in current directory");
			System.out.println("(2) Directory management");
			System.out.println("(3) File management");
			System.out.println("(4) Exit application");
			operation = scan.nextInt();
			switch (operation) {
			case 1:

				// display existing files in directory
				featureValid = true;
				break;
			case 2:
				while (operationValid == false) {
					System.out.println("-----------------------------------");
					System.out.println("Directory Management");
					System.out.println("------------------------------------ \n");
					// output current directory
					System.out.println("Current directory");
					System.out.println("Enter the following operation that you would like to perform: ");
					System.out.println("(1) Switch to an existing directory");
					System.out.println("(2) Create a new directory");
					System.out.println("(3) Return to main menu");
					operation = scan.nextInt();
					switch (operation) {
					case 1:
						directoryName = scan.next();
						try {
							directoryHandler.validDirectory(directoryName);
						} catch (IsNotDirectoryException | DirectoryNotFoundException e) {

						}
						break;
					case 2:
						directoryName = scan.next();
						try {
							directoryHandler.makeDirectory(directoryName);
						} catch (FailCreateDirectoryException e) {

						}
						break;
					case 3:
						System.out.println("Returing to main menu");
						operationValid = true;
					default:
						System.out.println("Not a valid operation");
						break;
					}
				}
				break;
			case 3:
				while (operationValid == false) {
					System.out.println("-------------------------");
					System.out.println("File Management");
					System.out.println("--------------------------");
					// output current directory
					System.out.println("Current Directory: ");
					System.out.println("Enter the following operation that you would like to perform: ");
					System.out.println("(1) Add a file");
					System.out.println("(2) Delete a file");
					System.out.println("(3) Search for a file");
					System.out.println("(4) Return to main menu");
					operation = scan.nextInt();
					switch (operation) {
					case 1:

						break;
					case 2:

						break;
					case 3:
						break;
					case 4:
						System.out.println("Returing to main menu");
						operationValid = true;
						break;
					default:
						System.out.println("Not a valid operation");
						break;
					}

				}
				break;
			case 4:
				appOperations.exitApp();
				featureValid = true;
				break;
			default:
				System.out.println("Not a valid feature");
				break;
			}

		}

		scan.close();
	}

}
