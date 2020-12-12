package com.business.operations;

import java.io.File;
import java.io.IOException;

import com.exceptions.FailCreateFileException;
import com.exceptions.FileDoesNotExistException;

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
	public void deleteFile(String fileName) throws FileDoesNotExistException{
		//append fileName onto filePath then pass
		File f = new File(fileName);
		if(f.exists()) {
			f.delete();
		}else {
			throw new FileDoesNotExistException("File does not exist");
		}
	}

	@Override
	public void searchFile(String fileName) {
		// TODO Auto-generated method stub

	}

}
