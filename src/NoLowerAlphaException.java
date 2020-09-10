/***********************************************************************
 Class: CMSC203 CRN 22378
 Program: Assignment # 1
 Instructor: Professor Alexander
 Description: No Lower Alpha Exception Class
 Due: 09/16/2020
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Anthony Liu
************************************************************************/

public class NoLowerAlphaException extends Exception {
	
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character.");
	}
}
