package de.uulm.mi.web.http.impl;

import java.util.Map;

import de.uulm.mi.web.http.HttpMethod;
import de.uulm.mi.web.http.HttpRequest;
import de.uulm.mi.web.http.HttpVersion;

public class BasicHttpRequest implements HttpRequest
{
	// TODO: add setters/appropriate constructors
	private String requestLine;
	
	// BasicHttpRequest Constructor
	// NOTE** This constructor is predicated on the assumption that the HttpRequest object takes in a string containing the entire request line
	// I have implemented BasicHttpRequest as an immutable object that is initialized with the full Request Line. By implementing this as immutable object, we assure
	// the object state is always coherent i.e. the HTTP version cannot be changed independent of the request method.
	// The constructor takes in a complete Request Line (string) and the instance is capable of parsing out the various values from the request line on demand (via class methods)
	public BasicHttpRequest(String initRequestData) {
		requestLine = initRequestData;
	}

	@Override
	public HttpVersion getHttpVersion()
	{
		// TODO Auto-generated method stub
		return HttpVersion.extractVersion(requestLine);	
	}

	@Override
	public Map<String, String> getHeaders()
	{
		// TODO Auto-generated method stub
		return null;
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
		return HttpMethod.extractMethod(requestLine);
	}

	@Override
	public String getRequestUri()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
