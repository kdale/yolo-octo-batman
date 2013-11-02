package de.uulm.mi.web.http.impl;

import java.util.Map;

import de.uulm.mi.web.http.HttpResponse;
import de.uulm.mi.web.http.HttpStatusCode;
import de.uulm.mi.web.http.HttpVersion;

public class BasicHttpResponse implements HttpResponse
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
	public HttpStatusCode getStatusCode()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
