package com.blog.application.api;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.blog.application.client.ApiClient;
import com.blog.application.utility.AppUtility;

/*********************************************************************
 * / Unit testing configuration /
 **********************************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application-local.properties")
@WebAppConfiguration

/*********************************************************************
 * /
 * 
 * @Before The Before annotation indicates that this method must be executed
 *         before each test in the class, so as to execute some preconditions
 *         necessary for the test.
 * 
 * @After The After annotation is used on a method containing java code to run
 *        after each test case. These methods will run even if any exceptions
 *        are thrown in the test case or in the case of assertion failures.
 * 
 * @Mock Mock will create a mock implementation for the class / service
 * 
 * @InjectMocks InjectMock will inject the mocks marked with @Mock to this
 *              instance when it is created.
 * 
 *              So when or where are these instances created? Well, it is done
 *              by this line which reside in the setUp method.
 *              MockitoAnnotations.initMocks(this);
 *
 *              So these instances would be created at the start of every test
 *              method of this test class.
 *
 * @Captor simplifies creation of ArgumentCaptor - useful when the argument to
 *         capture is a nasty generic class and you want to avoid compiler
 *         warnings
 *
 * @Spy - you can use it instead spy(Object).
 *
 * 
 *      when().thenReturn() when is a static method of the Mockito class and it
 *      returns an OngoingStubbing<T> (T is the return type of the method that
 *      we are mocking)
 *
 *      Verify with Mockito A great thing about mocking is that we can verify
 *      that certain methods have been called on those mock objects during test
 *      execution in addition to assertions or in place of assertions when the
 *      method under test is void.
 *
 *      /
 **********************************************************************/

/*************************************************************************
 * /
 * 
 * @author Sidheshwar Kumbhar
 * 
 *         We have created this class as abstract because we don�t want to
 *         instantiate this class. Only we can extends
 *
 *         /
 **************************************************************************/
public abstract class AbstractUnitTestCasesConfiguration {

	/*********************************************************************
	 * / Created ObjectMapper object for convert object to JSON string /
	 **********************************************************************/
	protected ObjectMapper mapperObj = new ObjectMapper();

	/*********************************************************************
	 * / Created MVC Mock object /
	 **********************************************************************/
	protected MockMvc mockMvc;

	/*********************************************************************
	 * / Start to create all classes Mock objects /
	 **********************************************************************/

	@Mock
	protected AppUtility appUtility = org.mockito.Mockito.mock(AppUtility.class);

	@Mock
	protected ApiClient apiClient = org.mockito.Mockito.mock(ApiClient.class);

}
