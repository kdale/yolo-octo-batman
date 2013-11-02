package de.uulm.mi.web.http;

/**
 * An enum of available HTTP methods.
 * 
 * @see also http://tools.ietf.org/html/rfc2616.html#section-5.1
 * 
 * @author Benjamin Erb
 * 
 */
public enum HttpMethod
{
	OPTIONS,
	GET,
	HEAD,
	POST,
	PUT,
	DELETE,
	TRACE,
	CONNECT;	
	//TODO: Complete other methods (see http://tools.ietf.org/html/rfc2616.html#section-9)

	@Override
	public String toString()
	{
		return this.name();
	}

	/**
	 * Extracts the HTTP method from the request line.
	 * 
	 * @param headerLine HTTP request line
	 * @return the HTTP method 
	 * @throws IllegalArgumentException
	 */
	public static HttpMethod extractMethod(String requestLine) throws IllegalArgumentException
	{
		//TODO: Extract HTTP Method from request line (see http://tools.ietf.org/html/rfc2616.html#section-5.1).
		String reqMethodName = 	requestLine.substring(0, requestLine.indexOf(" ")); 
		
		//compare our current request method to our enum values
		if (reqMethodName == OPTIONS.name()) { return OPTIONS; }
		if (reqMethodName == GET.name()) { return GET; }
		if (reqMethodName == HEAD.name()) { return HEAD; }
		if (reqMethodName == POST.name()) { return POST; }
		if (reqMethodName == PUT.name()) { return PUT; }
		if (reqMethodName == DELETE.name()) { return DELETE; }
		if (reqMethodName == TRACE.name()) { return TRACE; }
		if (reqMethodName == CONNECT.name()) { return CONNECT; }
		
		//if we make it this far, something is wrong, throw exception
		throw new IllegalArgumentException();
	}
}
