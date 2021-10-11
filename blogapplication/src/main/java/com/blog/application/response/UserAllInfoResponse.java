/**************************************************************************************************************************** /
//  
// Class Name : UserAllInfoResponse
// File/Class/Function Description: This class contents user's all information 
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.blog.application.response;

import java.io.Serializable;
import java.util.List;

import com.blog.application.client.model.Post;
import com.blog.application.client.model.UserAddress;
import com.blog.application.client.model.UserCompany;

public class UserAllInfoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String username;
	private String email;
	private UserAddress address;
	private String phone;
	private String website;
	private UserCompany company;
	private List<Post> posts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public UserCompany getCompany() {
		return company;
	}

	public void setCompany(UserCompany company) {
		this.company = company;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
