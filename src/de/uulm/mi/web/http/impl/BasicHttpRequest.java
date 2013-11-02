package de.uulm.mi.web.http.impl;

import java.util.Map;

import de.uulm.mi.web.http.HttpMethod;
import de.uulm.mi.web.http.HttpRequest;
import de.uulm.mi.web.http.HttpVersion;

public class BasicHttpRequest implements HttpRequest
{
	// TODO: add setters/appropriate constructors

	@Override
	public HttpVersion getHttpVersion()
	{
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public String getRequestUri()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
