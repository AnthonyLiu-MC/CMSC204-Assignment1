
/***********************************************************************
 Class: CMSC203 CRN 22378
 Program: Assignment # 1
 Instructor: Professor Alexander
 Description: Invalid Sequence Exception Class
 Due: 09/16/2020
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Anthony Liu
************************************************************************/

public class InvalidSequenceException extends Exception {

	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence.");
	}
}
