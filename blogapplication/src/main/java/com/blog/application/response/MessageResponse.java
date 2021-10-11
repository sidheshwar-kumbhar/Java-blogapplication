/**************************************************************************************************************************** /
// 
// Class Name : MessageResponse
// File/Class/Function Description: This class is used for API Message response
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/

package com.blog.application.response;

public class MessageResponse {
	private String title;
	private String message;

	public MessageResponse(String title, String message) {
		this.title = title;
		this.message = message;
	}

	public MessageResponse() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}