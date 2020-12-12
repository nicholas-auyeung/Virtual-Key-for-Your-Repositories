package com.prototype;

import java.util.Scanner;

import com.business.operations.*;
import com.exceptions.DirectoryNotFoundException;
import com.exceptions.FailCreateDirectoryException;
import com.exceptions.IsNotDirectoryException;

public class LockMePrototype {

	public static void main(String[] args) {

		boolean directoryValid = false, operationValid = false;

		int operation;

		String directoryName;

		Scanner scan = new Scanner(System.in);
		LockMeDirectoryHandler directoryHandler = new LockMeDirectoryHandler();

		System.out.println("*************************************");
		System.out.println("Welcome to LockMe.com Prototype \n");
		System.out.println("*************************************");

		while (directoryValid == false) {
			// output current directory
			System.out.println("Current directory");
			System.out.println("Enter the following operation that you would like to perform: ");
			System.out.println("(1) Keep current directory");
			System.out.println("(2) Switch to an existing directory");
			System.out.println("(3) Create a new directory");
			operation = scan.nextInt();
			switch (operation) {
			case 1:
				System.out.println("Current directory is selected");
				directoryValid = true;
				break;
			case 2:
				directoryName = scan.next();
				try {
					directoryHandler.validDirectory(directoryName);
				} catch (IsNotDirectoryException | DirectoryNotFoundException e) {

				}
				directoryValid = true;
				break;
			case 3:
				directoryName = scan.next();
				try {
					directoryHandler.makeDirectory(directoryName);
				} catch (FailCreateDirectoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				directoryValid = true;
				break;
			default:
				System.out.println("Not a valid operation");
				break;
			}
		}

		while (operationValid == false) {
			System.out.println("Enter the following operation that you would like to perform: ");
			System.out.println("(1) Add a file");
			System.out.println("(2) Delete a file");
			System.out.println("(3) Search for a file");

		}
		scan.close();
	}

}
