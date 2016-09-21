package org.zerhusen.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FilteredRequest extends HttpServletRequestWrapper {

	public FilteredRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getHeader(String header){
		String value = super.getHeader(header);
		if ("Authorization".equals(header)) {
			value = sanitize(value);
		}
		return value;
	}
	
	
	public String sanitize(String input) {
		
        if (input!=null && input.startsWith("Bearer ")){
        	input  = input.substring(7);
        }
        
		return input;
	}
}
