/**************************************************************************************************************************** /
//  
// Class Name : CustomError
// File/Class/Function Description: This class use for create custom error message
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.blog.application.response;

public class CustomError {
	private String errorMessage;

	public CustomError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
