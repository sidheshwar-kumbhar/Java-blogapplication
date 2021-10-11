/**************************************************************************************************************************** /
//  
// Class Name : AdminUserController
// File/Class/Function Description: This class contents all admin REST APIs
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/

package com.blog.application.api;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.application.client.model.Post;
import com.blog.application.client.model.User;
import com.blog.application.response.CustomError;
import com.blog.application.response.MessageResponse;
import com.blog.application.response.UserAllInfoResponse;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController extends AbstractInstanceConfiguration {

	private ConcurrentMap<Integer, List<Post>> inMemoryPost = new ConcurrentHashMap<Integer, List<Post>>();

	/*******************************************************************************************************
	 * This API is use for get user's all information with their related posts by
	 * user Id
	 * 
	 * Function Name: getUserAllInfoByUserId
	 * 
	 * @parameter(s) : userId - user id
	 * 
	 * @response Type: JSON
	 * @return Response: JSON of user's all information with their related posts /
	 *         Error message
	 * @author Sidheshwar Kumbhar
	 **********************************************************************************************************/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<?> getUserAllInfoByUserId(@PathVariable("userId") int userId, HttpServletRequest request) {
		if (userId > 0) {
			UserAllInfoResponse response = new UserAllInfoResponse();

			// Get all users from API
			List<User> userList = apiClient.getUserList();

			// Get all posts from API
			List<Post> allPostList = apiClient.getaAllPostList();

			// Check user list is not empty
			if (userList != null && !userList.isEmpty()) {

				// Find user from user list
				User user = appUtility.findUserByUserId(userId, userList);

				// Find all posts of one user from all post list
				List<Post> userPostList = appUtility.findAllPostsByUserId(userId, allPostList);

				// Check user not empty
				if (user != null) {
					// Get post Response object
					response = appUtility.getPostResponse(user, userPostList, response, inMemoryPost);
					// Send user's all information with their related posts
					return new ResponseEntity<UserAllInfoResponse>(response, HttpStatus.OK);
				}

				// Return error message if user not found in list
				return new ResponseEntity(new CustomError("Could not get user information!"), HttpStatus.NOT_FOUND);
			}

			// Return error message if user not found in list
			return new ResponseEntity(new CustomError("Could not get user list!"), HttpStatus.NOT_FOUND);
		}
		// Return error message if user not found in list
		return new ResponseEntity(new CustomError("Invalid user ID!"), HttpStatus.NOT_ACCEPTABLE);

	}

	/*******************************************************************************************************
	 * This API is use for get user's all information with their related posts by
	 * user Id
	 * 
	 * Function Name: getUserAllInfoByUserId
	 * 
	 * @parameter(s) : userId - user id
	 * 
	 * @response Type: JSON
	 * @return Response: JSON of user's all information with their related posts /
	 *         Error message
	 * @author Sidheshwar Kumbhar
	 **********************************************************************************************************/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> sendPostData(@RequestBody Post post, HttpServletRequest request) {
		if (post != null) {
			// Get all users from API
			List<User> userList = apiClient.getUserList();

			// Check user list is not empty
			if (userList != null && !userList.isEmpty()) {

				// Find user from user list
				User user = appUtility.findUserByUserId(post.getUserId(), userList);
				MessageResponse response = appUtility.updateAdminPost(user, post, inMemoryPost);
				return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);
			}

			// Return error message if user not found in list
			return new ResponseEntity(new CustomError("Could not get user list!"), HttpStatus.NOT_FOUND);
		}
		// Return error message if user not found in list
		return new ResponseEntity(new CustomError("Invalid post data!"), HttpStatus.NOT_ACCEPTABLE);

	}
}
