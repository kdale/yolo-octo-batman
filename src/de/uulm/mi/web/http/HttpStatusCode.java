package de.uulm.mi.web.http;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * An enum of available HTTP status codes.
 * 
 * @see also http://tools.ietf.org/html/rfc2616.html#section-6.1.1
 * 
 * @author Benjamin Erb
 * 
 */
public enum HttpStatusCode
{
	CONTINUE(100, "Continue"),
	OK(200, "OK"),
	NOT_FOUND(400, "NOT FOUND");
	//TODO: Complete status code list (see http://tools.ietf.org/html/rfc2616.html#section-6.1.1)

	private final int code;
	private final String reasonPhrase;

	private static final Map<Integer, HttpStatusCode> codeLookupTable = new HashMap<Integer, HttpStatusCode>();

	static
	{
		for (HttpStatusCode s : EnumSet.allOf(HttpStatusCode.class))
		{
			codeLookupTable.put(s.getCode(), s);
		}
	}

	private HttpStatusCode(int code, String reasonPhrase)
	{
		this.code = code;
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * Returns the numerical code.
	 * 
	 * @return Code
	 */
	public int getCode()
	{
		return code;
	}

	/**
	 * Returns the verbatim code.
	 * 
	 * @return reasons phrase
	 */
	public String getReasonPhrase()
	{
		return reasonPhrase;
	}

	/**
	 * Gets the {@link HttpStatusCode} type by the code number.
	 * 
	 * @param code
	 *            numerical code representation (i.e. 200)
	 * @return assosciated status code
	 */
	public static HttpStatusCode getStatusCode(int code)
	{
		return codeLookupTable.get(code);
	}
}
