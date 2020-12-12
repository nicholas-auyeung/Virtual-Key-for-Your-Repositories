package com.business.operations;

import java.io.File;
import com.exceptions.*;

public class LockMeDirectoryHandler implements LockMeDirectoryOperations {

	// main parent directory
	final static String location = "";

	@Override
	public void makeDirectory(String directoryName) throws FailCreateDirectoryException {
		File f = new File(directoryName);
		if (f.mkdir()) {
			System.out.println("Directory creation successful");
		} else {
			throw new FailCreateDirectoryException("Directory creation failed");
		}

	}

	@Override
	public void validDirectory(String directoryName) throws IsNotDirectoryException, DirectoryNotFoundException {
		File f = new File(directoryName);
		if (f.exists()) {
			if (f.isDirectory()) {
				System.out.println("Directory exists");
			} else {
				throw new IsNotDirectoryException("This is not a directory");
			}
		} else {
			throw new DirectoryNotFoundException("Directory not found");
		}
	}

}
