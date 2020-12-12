package com.business.operations;

import com.exceptions.DirectoryNotFoundException;
import com.exceptions.FailCreateDirectoryException;
import com.exceptions.IsNotDirectoryException;

public interface LockMeDirectoryOperations {
	
	public void makeDirectory(String directoryName) throws FailCreateDirectoryException;
	
	public void validDirectory(String directoryName) throws IsNotDirectoryException, DirectoryNotFoundException;
	
	
}
