/**************************************************************************************************************************** /
//   
// Class Name : UserAddress
// File/Class/Function Description: This class contents User address information 
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.blog.application.client.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private GeographicCoordinate geo;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public GeographicCoordinate getGeo() {
		return geo;
	}

	public void setGeo(GeographicCoordinate geo) {
		this.geo = geo;
	}
}
