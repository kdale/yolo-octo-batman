package de.uulm.mi.web.http.impl;

import java.util.HashMap;
import java.util.Map;

import de.uulm.mi.web.http.HttpResponse;
import de.uulm.mi.web.http.HttpStatusCode;
import de.uulm.mi.web.http.HttpVersion;

public class BasicHttpResponse implements HttpResponse
{
	// TODO: add setters/appropriate constructors
	private HttpVersion httpVersion = HttpVersion.VERSION_1_1; 
	private HttpStatusCode statusCode;
	private Map<String, String> responseHeaders = new HashMap<String, String>();
	private byte[] entity;
	
	public void addHeader(String key, String value)
	{
		responseHeaders.put(key, value);
	}
	
	public void setStatusCode(HttpStatusCode code)
	{
		statusCode = code;
	}
	
	public void setEntityString(String entityString) 
	{
		entity = entityString.getBytes();
	}
	
	public void setEntity(byte[] entityBytes)
	{
		entity = entityBytes;
	}
	
	@Override
	public HttpVersion getHttpVersion()
	{
		// TODO Auto-generated method stub
		return httpVersion;
	}

	@Override
	public Map<String, String> getHeaders()
	{
		// TODO Auto-generated method stub
		return responseHeaders;
	}

	@Override
	public byte[] getEntity()
	{
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public HttpStatusCode getStatusCode()
	{
		// TODO Auto-generated method stub
		return statusCode;
	}

}
