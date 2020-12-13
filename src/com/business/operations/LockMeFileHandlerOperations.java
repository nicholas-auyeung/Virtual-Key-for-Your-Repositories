package com.business.operations;

import com.exceptions.FailCreateFileException;
import com.exceptions.FileDoesNotExistException;
import com.exceptions.NullDirectoryException;

public interface LockMeFileHandlerOperations {

	public void addFile(String fileName) throws FailCreateFileException;

	public void deleteFile(String fileName) throws FileDoesNotExistException;

	public void searchFile(String fileName) throws NullDirectoryException, FileDoesNotExistException;

}
