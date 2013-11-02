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
	/**
	 * Informational: 1xx
	 */
	CONTINUE(100, "Continue"),
	SWITCHING_PROTOCOLS(101, "Switching Protocols"),
	
	/**
	 * Success: 2xx
	 */
	OK(200, "OK"),
	CREATED(201, "Created"),
	ACCEPTED(202, "Accepted"),
	NON_AUTH_INFORMATION(203, "Non-Authoritative Information"),
	NO_CONTENT(204, "No Content"),
	RESET_CONTENT(205, "Reset Content"),
	PARTIAL_CONTENT(206, "Partial Content"),
	
	/**
	 * Redirection: 3xx
	 */
	MULTIPLE_CHOICES(300, "Multiple Choices"),
	MOVED_PERM(301, "Moved Permanently"),
	FOUND(302, "Found"),
	SEE_OTHER(303, "See Other"),
	NOT_MODIFIED(304, "Not Modified"),
	USE_PROXY(305, "Use Proxy"),
	TEMP_REDIRECT(307, "Temporary Redirect"),
	
	/**
	 * Client Error: 4xx
	 */
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	PAYMENT_REQ(402, "Payment Required"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Not Found"), 
	METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
	NOT_ACCEPTABLE(406, "Not Acceptable"),
	PROXY_AUTH_REQ(407, "Proxy Authentication Required"),
	REQ_TIME_OUT(408, "Request Time-out"),
	CONFLICT(409, "Conflict"),
	GONE(410, "Gone"),
	LENGTH_REQ(411, "Length Required"),
	PRECOND_FAILED(412, "Precondition Failed"),
	ENTITY_TOO_BIG(413, "Request Entity Too Large"),
	URI_TOO_BIG(414, "Request-URI Too Large"),
	MEDIA_NOT_SUPPORTED(415, "Unsupported Media Type"),
	REQ_RANGE_NOT_SAT(416, "Requested range not satisfiable"),
	EXPECTATION_FAILED(417, "Expectation Failed"),
	
	/**
	 * Server Error: 5xx
	 */
	INT_SERVER_ERROR(500, "Internal Server Error"),
	NOT_IMPLEMENTED(501, "Not Implemented"),
	BAD_GATEWAY(502, "Bad Gateway"),
	SERVICE_UNAVAILABLE(503, "Service Unavailable"),
	GATEWAY_TIME_OUT(504, "Gateway Time-out"),
	HTTP_VERSION_NOT_SUPPORTED(505, "HTTP version not supported");
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
