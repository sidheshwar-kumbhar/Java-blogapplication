/**************************************************************************************************************************** /
//  
// Class Name : AbstractInstanceConfiguration
// File/Class/Function Description: This class contents all objects need to use in all controllers
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.blog.application.api;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.application.client.ApiClient;
import com.blog.application.utility.AppUtility;

/*************************************************************************
 * 
 * @author Sidheshwar Kumbhar
 *
 *         We have created this class as abstract because we do't want to
 *         instantiate this class. Only we can extends
 *
 **************************************************************************/
public abstract class AbstractInstanceConfiguration {
	/*********************************************************************
	 * / Start to declare all class objects /
	 **********************************************************************/
	protected ObjectMapper mapper;
	
	@Autowired
	protected AppUtility appUtility;
	
	@Autowired
	protected ApiClient apiClient;

	protected AbstractInstanceConfiguration() {
		mapper = new ObjectMapper();
	}

}
