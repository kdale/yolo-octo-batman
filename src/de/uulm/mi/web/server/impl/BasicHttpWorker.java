package de.uulm.mi.web.server.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import de.uulm.mi.web.http.HttpRequest;
import de.uulm.mi.web.http.HttpResponse;
import de.uulm.mi.web.http.impl.BasicHttpRequest;
import de.uulm.mi.web.http.impl.BasicHttpResponse;
import de.uulm.mi.web.server.HttpWorker;

public class BasicHttpWorker extends HttpWorker
{
	public BasicHttpWorker(Socket socket, BasicHttpServer server)
	{
		super(socket, server);
	}

	@Override
	protected HttpRequest parseRequest(InputStream inputStream) throws IOException
	{
		// TODO Auto-generated method stub
		// readLine gives us everything up to the first line feed, in this case the request line
		String requestLine = readLine(inputStream);
		return new BasicHttpRequest(requestLine);
	}

	@Override
	protected HttpResponse handleRequest(HttpRequest request)
	{
		// TODO Auto-generated method stub
		// we have the request info i.e method, resource, version - need to handle as appropriate
		BasicHttpResponse basicHttpResponse = new BasicHttpResponse();
		
		
		return basicHttpResponse;
	}

	@Override
	protected void sendResponse(HttpResponse response, OutputStream outputStream) throws IOException
	{
		// TODO Auto-generated method stub
		String test = "hello world";
		outputStream.write(test.getBytes());
	}

	@Override
	protected boolean keepAlive(HttpRequest request, HttpResponse response)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
}
