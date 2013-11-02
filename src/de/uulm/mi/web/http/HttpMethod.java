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
	HEAD;
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
		return null;
	}
}
