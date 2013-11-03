package de.uulm.mi.web.server.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import de.uulm.mi.web.http.HttpMethod;
import de.uulm.mi.web.http.HttpRequest;
import de.uulm.mi.web.http.HttpResponse;
import de.uulm.mi.web.http.HttpStatusCode;
import de.uulm.mi.web.http.impl.BasicHttpRequest;
import de.uulm.mi.web.http.impl.BasicHttpResponse;
import de.uulm.mi.web.server.HttpWorker;

public class BasicHttpWorker extends HttpWorker
{
	private String responseCodeHtml = "<HTML><HEAD><meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"><TITLE>CODE PHRASE</TITLE></HEAD><BODY><H1>CODE PHRASE</H1></BODY></HTML>";
	
	public BasicHttpWorker(Socket socket, BasicHttpServer server)
	{
		super(socket, server);
	}

	@Override
	protected HttpRequest parseRequest(InputStream inputStream) throws IOException
	{
		// TODO Auto-generated method stub
		// BasicHttpRequest is capable of initializing itself directly from a input stream
		return new BasicHttpRequest(inputStream);
	}

	@Override
	protected HttpResponse handleRequest(HttpRequest request)
	{
		// TODO Auto-generated method stub
		// Creates a response object based on the incoming request object, including reading in content from the file system, etc.
		BasicHttpResponse basicHttpResponse = new BasicHttpResponse();
		
		// **** NOTE!!! **** //
		// For testing purposes, the if/else is commented out - hard code a 501 response to verify request/server response.
		// Uncomment if/else to handle GET
		// **** ------- **** //
		
		// ** For starters, implement ONLY GET method, return error code for all other cases.
		//if (request.getHttpMethod().toString().equals(HttpMethod.GET.toString())) 		// get request method
		//{
			// get request uri
			// does the uri exist on file system? 
			// if yes... 
			// 		set response obj properties: Status code, reason phrase, header string, entity 
			// 		read in file contents, put in response object
			// 		EXAMPLE below in sendResponse
			// if no...
			// 		
		//}
		//else {
			// base case, return "Not implemented" error
			basicHttpResponse.setStatusCode(HttpStatusCode.NOT_IMPLEMENTED);
			String codeHtmlResponse = responseCodeHtml.replaceAll("CODE", String.valueOf(basicHttpResponse.getStatusCode().getCode()));
			codeHtmlResponse = codeHtmlResponse.replaceAll("PHRASE", basicHttpResponse.getStatusCode().getReasonPhrase());
			basicHttpResponse.setEntityString(codeHtmlResponse);
		//}
		
		return basicHttpResponse;
	}

	@Override
	protected void sendResponse(HttpResponse response, OutputStream outputStream) throws IOException
	{
		// TODO Auto-generated method stub
		// Send the already created Response obj to the client 
		
		// Build up our Response
		StringBuilder responseString = new StringBuilder();
		responseString.append(response.getHttpVersion().toString() + " ");
		responseString.append(response.getStatusCode().getCode() + " ");
		responseString.append(response.getStatusCode().getReasonPhrase());
		responseString.append("\r\n");
		responseString.append(getHeaderString(response));
		responseString.append("\r\n"); 
		
		outputStream.write(responseString.toString().getBytes());
		outputStream.write(response.getEntity());
		outputStream.flush();
	}
	
	/**
	 * Helper method to build up the HTTP response header for output to the stream
	 * @param response
	 * @return String
	 */
	public String getHeaderString(HttpResponse response)
	{
		Iterator iterator = response.getHeaders().entrySet().iterator();
		StringBuilder headerString = new StringBuilder();
		
		while (iterator.hasNext())
		{
			Map.Entry pairs = (Map.Entry)iterator.next();
			headerString.append(pairs.getKey() + ": ");
			headerString.append(pairs.getValue());
			headerString.append("\r\n");
		}
		
		return headerString.toString();
	}

	@Override
	protected boolean keepAlive(HttpRequest request, HttpResponse response)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
}
