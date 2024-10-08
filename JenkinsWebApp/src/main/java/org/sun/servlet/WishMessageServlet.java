package org.sun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wishurl")
public class WishMessageServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set response content type
		resp.setContentType("text/html");
		//get the print writer
		PrintWriter pw=resp.getWriter();
		//write the messages to response object
		pw.println("<h1 style='color:red ; text-align:center'>Good Morning</h1>");
		//home hyper link
		pw.println("<br><br><a href='index.jsp'>home</a>  ");
		//close the stream
		pw.close();
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPost(req, resp);
	}
	
	
}
