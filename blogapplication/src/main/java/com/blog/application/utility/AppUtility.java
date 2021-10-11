/**************************************************************************************************************************** /
//  
// Class Name : AppUtility
// File/Class/Function Description: This class contents utility functions
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.blog.application.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.blog.application.client.model.Post;
import com.blog.application.client.model.User;
import com.blog.application.response.MessageResponse;
import com.blog.application.response.UserAllInfoResponse;

@Service
public class AppUtility {

	ObjectMapper mapper;

	public AppUtility() {
		mapper = new ObjectMapper();
	}

	/*******************************************************************************************
	 * Method name: getObjectToJsonString
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User List
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - This function used to
	 *             converts object to JSON string
	 ********************************************************************************************/

	public String getObjectToJsonString(Object response) {

		String jsonInString = null;
		try {
			// Converts object to JSON string
			jsonInString = mapper.writeValueAsString(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonInString;
	}

	/*******************************************************************************************
	 * Method name: getObjectToJsonString
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User List
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - This function used to
	 *             converts object to JSON string
	 ********************************************************************************************/

	public User findUserByUserId(int userId, List<User> userList) {
		User user = null;

		// Check UserId should be greater ten 0 and userList should be greater then 0
		if (userId > 0 && userList != null && !userList.isEmpty()) {
			Optional<User> userObject = userList.stream().filter(u -> u.getId() == userId).findFirst();

			// Check if value Present or not
			if (userObject.isPresent()) {
				user = userObject.get(); // Get the user
			}
		}
		return user;
	}

	/*******************************************************************************************
	 * Method name: getObjectToJsonString
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User List
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - This function used to
	 *             converts object to JSON string
	 ********************************************************************************************/

	public List<Post> findAllPostsByUserId(int userId, List<Post> postList) {
		List<Post> tmpPostList = new ArrayList<>();
		// Check UserId should be greater ten 0 and userList should be greater then 0
		if (userId > 0 && postList != null && !postList.isEmpty()) {
			Stream<Post> postObject = postList.parallelStream().filter(p -> p.getUserId() == userId);
			tmpPostList = postObject.toList(); // Get the user
		}
		return tmpPostList;
	}

	/*******************************************************************************************
	 * Method name: merge
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User List
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - This function used to Merge
	 *             two list in one list
	 ********************************************************************************************/
	public <T> List<T> merge(List<T> list1, List<T> list2) {
		List<T> list = new ArrayList<T>();
		list.addAll(list1);
		list.addAll(list2);

		return list;
	}

	/*******************************************************************************************
	 * Method name: getPostResponse
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User List
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - This function used to get
	 *             Post Response
	 ********************************************************************************************/

	public UserAllInfoResponse getPostResponse(User user, List<Post> userPostList, UserAllInfoResponse response,
			ConcurrentMap<Integer, List<Post>> inMemoryPost) {
		if (user != null) {

			// Set all values for return response
			response.setAddress(user.getAddress());
			response.setCompany(user.getCompany());
			response.setEmail(user.getEmail());
			response.setId(user.getId());
			response.setName(user.getName());
			response.setPhone(user.getPhone());
			response.setUsername(user.getUsername());
			response.setWebsite(user.getWebsite());

			// Check in memory data
			if (!inMemoryPost.isEmpty()) {
				// Get all in memory post for the user
				List<Post> postList = inMemoryPost.get(user.getId());

				// If post are found in memory data store then add all in user post
				if (!postList.isEmpty()) {
					userPostList = this.merge(userPostList, postList);
				}

				// Set users all posts in response
				response.setPosts(userPostList);
			} else {
				// Set users all posts in response
				response.setPosts(userPostList);
			}
		}
		// Send user's all information with their related posts
		return response;
	}

	/*******************************************************************************************
	 * Method name: updateAdminPost
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User List
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - This function used to update
	 *             user Post
	 ********************************************************************************************/

	public MessageResponse updateAdminPost(User user, Post post, ConcurrentMap<Integer, List<Post>> inMemoryPost) {
		MessageResponse response = new MessageResponse();
		if (user != null) {

			// Check in memory user and post map is empty
			if (inMemoryPost.isEmpty()) {

				// Create new key value pair of add post list for the user
				inMemoryPost.put(post.getUserId(), new ArrayList<Post>(Arrays.asList(post)));
			} else {

				// Get all in memory post for the user
				List<Post> postList = inMemoryPost.get(post.getUserId());

				// If post not found in memory data store
				if (postList == null || postList.isEmpty()) {
					// Create new key value pair and post list for the user
					inMemoryPost.put(post.getUserId(), new ArrayList<Post>(Arrays.asList(post)));
				} else {

					// Add post in existing in memory data list for the user
					postList.add(post);
					// Update key value pair of add post list for the user
					inMemoryPost.put(post.getUserId(), postList);
				}
			}
			response.setTitle("Message");
			response.setMessage("Success");
			return response;
		}
		response.setTitle("Error");
		response.setMessage("Fail");
		return response;
	}

}
