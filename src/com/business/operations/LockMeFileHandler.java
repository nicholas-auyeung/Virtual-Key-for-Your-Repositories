package com.business.operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.exceptions.FailCreateFileException;
import com.exceptions.FileDoesNotExistException;
import com.exceptions.NullDirectoryException;

public class LockMeFileHandler implements LockMeFileHandlerOperations {

	private String pathName;

	public LockMeFileHandler(String pathName) {
		super();
		this.pathName = pathName;
	}

	public LockMeFileHandler() {
		super();
	}

	@Override
	public void addFile(String fileName) throws FailCreateFileException {
		// append fileName onto filePath then pass
		try {
			File f = new File(fileName);
			if (f.createNewFile()) {
				System.out.println("File creation succeeded");
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			throw new FailCreateFileException("Error occured");
		}

	}

	@Override
	public void deleteFile(String fileName) throws FileDoesNotExistException {
		// append fileName onto filePath then pass
		File f = new File(fileName);
		if (f.exists()) {
			f.delete();
		} else {
			throw new FileDoesNotExistException("File does not exist");
		}
	}

	@Override
	public void searchFile(String fileName) throws NullDirectoryException, FileDoesNotExistException{
		// append fileName onto filePath then pass
		File f = new File(fileName);
		List<String> children = Arrays.asList(f.list());
		if (children == null) {
			throw new NullDirectoryException("Directory is empty");
		} else {
			if (f.exists()) {
				System.out.println("File is " + fileName + " found");
			} else {
				throw new FileDoesNotExistException("File is not found");
			}
		}
	}

}
