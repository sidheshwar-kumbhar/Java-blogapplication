/**************************************************************************************************************************** /
//  
// Class Name : Posts
// File/Class/Function Description: This class contents list of Post 
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/

package com.blog.application.client.model;

import java.io.Serializable;
import java.util.List;

public class Posts implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Post> postList;

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

}
