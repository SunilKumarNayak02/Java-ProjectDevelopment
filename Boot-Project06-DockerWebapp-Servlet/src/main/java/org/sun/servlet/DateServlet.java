package org.sun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dateurl")
public class DateServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter Stream
		PrintWriter pw=res.getWriter();
	    //set Response Content Type
		res.setContentType("text/html");
		//Write b. logic
		Date d=new Date();
		//Write Response
		pw.println("<h1 style='color:red'> Date And Time: "+d+"<h1>");
		
		//Add one Home Hyper Link
		pw.println("<br><a href='index.jsp'>home</a>");
		//close the Stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
