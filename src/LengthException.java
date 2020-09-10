/***********************************************************************
 Class: CMSC203 CRN 22378
 Program: Assignment # 1
 Instructor: Professor Alexander
 Description: Length Exception Class
 Due: 09/16/2020
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Anthony Liu
************************************************************************/


public class LengthException extends Exception{
	
	public LengthException() {
		super("The password must be at least 6 characters long.");
	}

}
