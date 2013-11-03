package de.uulm.mi.web.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import de.uulm.mi.web.http.HttpMethod;
import de.uulm.mi.web.http.HttpRequest;
import de.uulm.mi.web.http.HttpVersion;

public class BasicHttpRequest implements HttpRequest
{
	// TODO: add setters/appropriate constructors

	// member variables
	private String requestLine;
	private HttpVersion requestHttpVersion;
	private HttpMethod requestHttpMethod;
	private String requestUri;
	private Map<String, String> requestHeaders = new HashMap<String, String>();
	
	
	// BasicHttpRequest Constructor
	// NOTE** This constructor is predicated on the assumption that the HttpRequest object takes in the request stream
	// I have implemented BasicHttpRequest as an immutable object that is initialized with the full request stream. By implementing this as immutable object, we assure
	// the object state is always coherent i.e. the HTTP version cannot be changed independent of the request method.
	public BasicHttpRequest(InputStream requestStream) throws IOException {
		// we set the individual members now, so that we know immediately if our requestStream is malformed
		
		// first line of stream is always the request line, from which we can get HTTP version, HTTP Method and the requested resource
		requestLine = readLine(requestStream); 
		requestHttpVersion = HttpVersion.extractVersion(requestLine);	
		requestHttpMethod = HttpMethod.extractMethod(requestLine);
		requestUri = requestLine.substring(requestLine.indexOf(" "), requestLine.lastIndexOf(" ")).trim(); 
		
		String line; // the line currently being read
		while ((line = readLine(requestStream)).length() != 0) { // loop through the input stream until a empty line is received
			String key = line.substring(0, line.indexOf(":"));
			String value = line.substring(line.indexOf(":")+2);
			
			requestHeaders.put(key, value);
		}
		
	}

	@Override
	public HttpVersion getHttpVersion()
	{
		// TODO Auto-generated method stub
		return requestHttpVersion;
	}

	@Override
	public Map<String, String> getHeaders()
	{
		// TODO Auto-generated method stub
		return requestHeaders;
	}

	@Override
	public byte[] getEntity()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpMethod getHttpMethod()
	{
		// TODO Auto-generated method stub
		return requestHttpMethod;
	}

	@Override
	public String getRequestUri()
	{
		// TODO Auto-generated method stub
		return requestUri;
	}
	
	/**
	 * A helper method that reads an InputStream until it reads a CRLF (\r\n\).
	 * Everything in front of the linefeed occured is returned as String.
	 * 
	 * @param inputStream
	 *            The stream to read from.
	 * @return The character sequence in front of the linefeed.
	 * @throws IOException
	 */
	// edited to make method static, so it is not tied to a instance
	protected static String readLine(InputStream inputStream) throws IOException
	{
		StringBuffer result = new StringBuffer();
		boolean crRead = false;
		int n;
		while ((n = inputStream.read()) != -1)
		{
			if (n == '\r')
			{
				crRead = true;
				continue;
			}
			else if (n == '\n' && crRead)
			{
				return result.toString();
			}
			else
			{
				result.append((char) n);
			}
		}
		return result.toString();
	}

}
