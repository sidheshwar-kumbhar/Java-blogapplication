/**************************************************************************************************************************** /
//  
// Class Name : AdminUserControllerTest
// File/Class/Function Description: This class contents all REST APIs testing functions
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   11/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/

package com.blog.application.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.blog.application.client.model.GeographicCoordinate;
import com.blog.application.client.model.Post;
import com.blog.application.client.model.User;
import com.blog.application.client.model.UserAddress;
import com.blog.application.client.model.UserCompany;
import com.blog.application.response.MessageResponse;
import com.blog.application.response.UserAllInfoResponse;

public class AdminUserControllerTest extends AbstractUnitTestCasesConfiguration {

	/*********************************************************************
	 * / InjectMock will inject the mocks marked with @Mock to this instance. /
	 **********************************************************************/

	@InjectMocks
	private AdminUserController adminUserController = new AdminUserController();

	/*********************************************************************
	 * / seup() method is used to build mockMvc mock object /
	 **********************************************************************/

	@SuppressWarnings("deprecation")
	@Before
	public void seup() throws Exception {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminUserController).build();
	}

	/*******************************************************************************************
	 * Method name: setUserTestData
	 * 
	 * @created: Oct 11, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User information response
	 * @revisions: Sidheshwar Kumbhar (Oct 11, 2021) - This function used to set
	 *             test case data
	 ********************************************************************************************/

	@SuppressWarnings("unchecked")
	private UserAllInfoResponse setUserTestData(String testCase) {

		// Set response object
		UserAllInfoResponse response = new UserAllInfoResponse();

		// Create list of users with data
		List<User> userList = new ArrayList<User>();

		User user = new User();
		UserAddress address = new UserAddress();
		UserCompany userCompany = new UserCompany();
		GeographicCoordinate geo = new GeographicCoordinate();

		geo.setLat("-37.3159");
		geo.setLng("81.1496");

		address.setGeo(geo);
		address.setCity("Gwenborough");
		address.setStreet("Kulas Light");
		address.setSuite("Apt. 556");
		address.setZipcode("92998-3874");

		userCompany.setBs("harness real-time e-markets");
		userCompany.setCatchPhrase("Multi-layered client-server neural-net");
		userCompany.setName("Romaguera-Crona");

		user.setAddress(address);
		user.setCompany(userCompany);
		user.setEmail("Sincere@april.biz");
		user.setId(1);
		user.setPhone("1-770-736-8031 x56442");
		user.setUsername("Bret");
		user.setName("Leanne Graham");
		user.setWebsite("hildegard.org");

		userList.add(user);

		user = new User();
		address = new UserAddress();
		userCompany = new UserCompany();
		geo = new GeographicCoordinate();

		geo.setLat("-43.9509");
		geo.setLng("-34.4618");

		address.setGeo(geo);
		address.setCity("Wisokyburgh");
		address.setStreet("Victor Plains");
		address.setSuite("Suite 879");
		address.setZipcode("90566-7771");

		userCompany.setBs("synergize scalable supply-chains");
		userCompany.setCatchPhrase("Proactive didactic contingency");
		userCompany.setName("Deckow-Crist");

		user.setAddress(address);
		user.setCompany(userCompany);
		user.setEmail("Shanna@melissa.tv");
		user.setId(2);
		user.setPhone("010-692-6593 x09125");
		user.setUsername("Antonette");
		user.setName("Ervin Howell");
		user.setWebsite("anastasia.net");

		userList.add(user);

		// Create list of posts

		List<Post> postList = new ArrayList<Post>();
		List<Post> userPostList = new ArrayList<Post>();

		Post post = new Post();

		post.setUserId(1);
		post.setId(1);
		post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		post.setBody(
				"quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

		postList.add(post);

		post.setUserId(1);
		post.setId(2);
		post.setTitle("qui est esse");
		post.setBody(
				"est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla");

		postList.add(post);

		post.setUserId(2);
		post.setId(11);
		post.setTitle("et ea vero quia laudantium autem");
		post.setBody(
				"delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus\naccusamus in eum beatae sit\nvel qui neque voluptates ut commodi qui incidunt\nut animi commodi");

		postList.add(post);
		userPostList.add(post);

		post.setUserId(2);
		post.setId(12);
		post.setTitle("in quibusdam tempore odit est dolorem");
		post.setBody(
				"itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio");

		postList.add(post);
		userPostList.add(post);

		// Set response object values
		response.setAddress(user.getAddress());
		response.setCompany(user.getCompany());
		response.setEmail(user.getEmail());
		response.setId(user.getId());
		response.setName(user.getName());
		response.setPhone(user.getPhone());
		response.setUsername(user.getUsername());
		response.setWebsite(user.getWebsite());
		response.setPosts(userPostList);

		// Mock function call

		if (testCase.equalsIgnoreCase("testUserListEmpty")) {
			// Set user list empty to test result
			when(apiClient.getUserList()).thenReturn(new ArrayList<User>());
		} else {
			when(apiClient.getUserList()).thenReturn(userList);
		}

		when(apiClient.getaAllPostList()).thenReturn(postList);
		when(appUtility.findUserByUserId(2, userList)).thenReturn(user);
		when(appUtility.findAllPostsByUserId(2, postList)).thenReturn(userPostList);
		when(appUtility.getPostResponse(isA(User.class), isA(List.class), isA(UserAllInfoResponse.class), any()))
				.thenReturn(response);

		// setup for send post test case
		if (testCase.equalsIgnoreCase("testSendPostData")) {
			MessageResponse messageResponse = new MessageResponse();
			messageResponse.setTitle("Message");
			messageResponse.setMessage("Success");

			when(appUtility.updateAdminPost(isA(User.class), isA(Post.class), any())).thenReturn(messageResponse);
		}

		return response;
	}

	/*******************************************************************************************
	 * Method name: testUserAllInfoByUserId
	 * 
	 * @created: Oct 11, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: void
	 * @revisions: Sidheshwar Kumbhar (Oct 11, 2021) - This function used to test
	 *             get user's all information
	 ********************************************************************************************/
	@Test
	public void testUserAllInfoByUserId() throws Exception {

		// Set API call data
		UserAllInfoResponse response = this.setUserTestData("testUserAllInfoByUserId");

		// Test API call
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/user/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(mapperObj.writeValueAsString(response))).andDo(print());
	}

	/*******************************************************************************************
	 * Method name: testUserNotFoundByUserId
	 * 
	 * @created: Oct 11, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: void
	 * @revisions: Sidheshwar Kumbhar (Oct 11, 2021) - This function used to test
	 *             user not found by userId wrong
	 ********************************************************************************************/
	@Test
	public void testUserNotFoundByUserId() throws Exception {

		String msgBody = "{\"errorMessage\":\"Could not get user information!\"}";

		// Set API call data
		this.setUserTestData("testUserNotFoundByUserId");

		// Test API call
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/user/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(msgBody)).andDo(print());
	}

	/*******************************************************************************************
	 * Method name: testUserListEmpty
	 * 
	 * @created: Oct 11, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: void
	 * @revisions: Sidheshwar Kumbhar (Oct 11, 2021) - This function used to test
	 *             user list is empty
	 ********************************************************************************************/
	@Test
	public void testUserListEmpty() throws Exception {

		String msgBody = "{\"errorMessage\":\"Could not get user list!\"}";

		// Set API call data
		this.setUserTestData("testUserListEmpty");

		// Test API call
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/user/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(msgBody)).andDo(print());
	}

	/*******************************************************************************************
	 * Method name: testUserIdInvalid
	 * 
	 * @created: Oct 11, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: void
	 * @revisions: Sidheshwar Kumbhar (Oct 11, 2021) - This function used to test
	 *             user invalid
	 ********************************************************************************************/
	@Test
	public void testUserIdInvalid() throws Exception {

		String msgBody = "{\"errorMessage\":\"Invalid user ID!\"}";

		// Set API call data
		this.setUserTestData("testUserIdInvalid");

		// Test API call
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/user/0").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotAcceptable()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(msgBody)).andDo(print());
	}

	/*******************************************************************************************
	 * Method name: testSendPostData
	 * 
	 * @created: Oct 11, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: void
	 * @revisions: Sidheshwar Kumbhar (Oct 11, 2021) - This function used to test
	 *             send user post by admin
	 ********************************************************************************************/
	@Test
	public void testSendPostData() throws Exception {

		// Expect message
		String msgBody = "{\"title\":\"Message\", \"message\":\"Success\"}";

		// Set API call data
		this.setUserTestData("testSendPostData");

		// Create post object for input
		Post post = new Post();

		post.setUserId(2);
		post.setId(100);
		post.setTitle("Test Post Title");
		post.setBody("Test Post Body");

		// Convert post object to JSON string for input
		String postJson = mapperObj.writeValueAsString(post);

		// Test API call
		mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/post").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(postJson)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(msgBody))
				.andDo(print());
	}

	/*******************************************************************************************
	 * Method name: testSendPostDataUserListEmpty
	 * 
	 * @created: Oct 11, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: void
	 * @revisions: Sidheshwar Kumbhar (Oct 11, 2021) - This function used to test
	 *             send user post by admin when user list is empty
	 ********************************************************************************************/
	@Test
	public void testSendPostDataUserListEmpty() throws Exception {

		// Expect message
		String msgBody = "{\"errorMessage\":\"Could not get user list!\"}";

		// Set API call data
		this.setUserTestData("testUserListEmpty");

		// Create post object for input
		Post post = new Post();

		post.setUserId(2);
		post.setId(100);
		post.setTitle("Test Post Title");
		post.setBody("Test Post Body");

		// Convert post object to JSON string for input
		String postJson = mapperObj.writeValueAsString(post);

		// Test API call
		mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/post").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(postJson)).andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(msgBody))
				.andDo(print());
	}

}
