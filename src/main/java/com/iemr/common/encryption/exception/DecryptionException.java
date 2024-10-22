package com.iemr.common.encryption.exception;

public class DecryptionException extends Exception {
	
	 public DecryptionException(String message) {
		 super(message);
	 }
	 
	 public DecryptionException(String message, Throwable cause) {
		 super(message, cause);
	 }

}
