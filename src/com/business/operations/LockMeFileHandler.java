package com.business.operations;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exceptions.FailCreateFileException;
import com.exceptions.FileDoesNotExistException;
import com.exceptions.InvalidFileNameException;
import com.exceptions.NullDirectoryException;

public class LockMeFileHandler implements LockMeFileHandlerOperations {
	
	public static final String regex = "^[a-zA-Z0-9](?:[a-zA-Z0-9 ._-]*[a-zA-Z0-9])?\\.[a-zA-Z0-9_-]+$";

	private String pathName;

	public LockMeFileHandler(String pathName) {
		super();
		this.pathName = pathName;
	}

	public LockMeFileHandler() {
		super();
	}
	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	@Override
	public void addFile(String fileName) throws InvalidFileNameException, FailCreateFileException {
		pathName += fileName;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fileName);
		if(matcher.matches()) {
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
		}else {
			throw new InvalidFileNameException("Invalid filename");
		}

	}

	@Override
	public void deleteFile(String fileName) throws InvalidFileNameException, FileDoesNotExistException {
		pathName += fileName;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fileName);
		if(matcher.matches()) {
			File f = new File(fileName);
			if (f.exists()) {
				f.delete();
			} else {
				throw new FileDoesNotExistException("File does not exist");
			}
		}else {
			throw new InvalidFileNameException("Invalid filename");
		}
	}

	@Override
	public void searchFile(String fileName) throws InvalidFileNameException, NullDirectoryException, FileDoesNotExistException{
		pathName += fileName;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fileName);
		if(matcher.matches()) {
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
		}else {
			throw new InvalidFileNameException("Invalid filename");
		}
	}

}
