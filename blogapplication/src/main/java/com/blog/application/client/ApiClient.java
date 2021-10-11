/**************************************************************************************************************************** /
// 
// Class Name : ApiClient
// File/Class/Function Description: This class is used for all REST API calls
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.blog.application.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blog.application.client.model.Post;
import com.blog.application.client.model.User;

@Service
public class ApiClient {

	private static final Logger logger = LoggerFactory.getLogger(ApiClient.class);

	// Get base URL from properties file
	@Value("${api.host.baseurl}")
	private String apiHost;

	// Created RestTemplate object
	@Autowired
	RestTemplate restTemplate;

	/*******************************************************************************************
	 * / Method name: getUserList
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: User List
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - Create function to get all
	 *             user list
	 ********************************************************************************************/

	public List<User> getUserList() {
		try {
			// Create Http Headers to set API headers values
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<String> entity = new HttpEntity<>(headers);

			// REST API call to get all users list
			ResponseEntity<User[]> responseEntity = restTemplate.exchange(apiHost + "/users", HttpMethod.GET, entity,
					User[].class);

			User[] userArray = responseEntity.getBody();
			HttpStatus statusCode = responseEntity.getStatusCode();

			// Check error status code is OK and user list has some values these return all
			// user list
			if (statusCode == HttpStatus.OK && userArray != null && userArray.length > 0)
				return Arrays.asList(userArray);
			else {
				// Log status code to get error
				logger.info(String.format("Status Code is  %d", statusCode.value()));
				// If an error occurred it will return empty user list
				return new ArrayList<>();
			}
		} catch (Exception e) {
			// Create error log
			logger.info(e.getMessage());
			e.printStackTrace();
		}

		// If an error occurred it will return empty user list
		return new ArrayList<>();
	}

	/*******************************************************************************************
	 * / Method name: getaAllPostList
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: List of all posts
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - Create function to get all
	 *             List of all posts
	 ********************************************************************************************/

	public List<Post> getaAllPostList() {
		try {
			// Create Http Headers to set API headers values
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<String> entity = new HttpEntity<>(headers);

			// REST API call to get all users list
			ResponseEntity<Post[]> responseEntity = restTemplate.exchange(apiHost + "/posts", HttpMethod.GET, entity,
					Post[].class);

			Post[] postArray = responseEntity.getBody();
			HttpStatus statusCode = responseEntity.getStatusCode();

			// Check error status code is OK and post list has some values these return all
			// post list
			if (statusCode == HttpStatus.OK && postArray != null && postArray.length > 0)
				return Arrays.asList(postArray);
			else {
				// Log status code to get error
				logger.info(String.format("Status Code is  %d", statusCode.value()));
				// If an error occurred it will return empty post list
				return new ArrayList<>();
			}
		} catch (Exception e) {
			// Create error log
			logger.info(e.getMessage());
			e.printStackTrace();
		}

		// If an error occurred it will return empty post list
		return new ArrayList<>();
	}

	/*******************************************************************************************
	 * This function is used to created @Autowired RestTemplate object
	 * 
	 * Method name: restTemplate
	 * 
	 * @created: Oct 10, 2021
	 * @author: Sidheshwar Kumbhar
	 * @return: List of all posts
	 * @revisions: Sidheshwar Kumbhar (Oct 10, 2021) - Create function to get
	 *             RestTemplate object
	 ********************************************************************************************/
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
