package com.business.operations;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.exceptions.*;

public class LockMeDirectoryHandler implements LockMeDirectoryOperations {

	// main parent directory
	final static String location = "";
	
	@Override
	public void displayDirectory(String directoryName) throws NullDirectoryException{
		File dir = new File(directoryName);
		//String[] children = dir.list();
		List children = Arrays.asList(dir.list());
		
		//convert to arrayList logic
		if(children == null) {
			throw new NullDirectoryException("Directory is empty");
		}else {
			int i = 0;
			String fileName;
			for(String child : children) {
				//fileName = children[i];
				i++;
				System.out.println(fileName);
			}
		}

	}

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
