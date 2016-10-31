package com.ibm.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/")
public class FormGeneratorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	System.out.println("In the init() method of HTMLFormGenerator");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		performTask(req, res, "POST",
		"htmlformhandler");
	}
	public void performTask(HttpServletRequest req, HttpServletResponse res,
	String method, String url) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML><TITLE>HTMLFormGenerator</TITLE><BODY>");
		out.println("<H2>Servlet API Example - HTMLCreatingServlet</H2><HR>");
		out.println("<FORM METHOD=\"" + method + "\" ACTION=\"" + url + "\">");
		out.println("<H2>Tell us something about yourself: </H2>");
		out.println("<B>Enter your name: </B>");
		out.println("<INPUT TYPE=TEXT NAME=firstname><BR>");
		out.println("<B>Select your title: </B>");
		out.println("<SELECT NAME=title>");
		out.println("<OPTION VALUE=\"Web Developer\">Web Developer");
		out.println("<OPTION VALUE=\"Web Architect\">Web Architect");
		out.println("<OPTION VALUE=\"Other\">Other");
		out.println("</SELECT><BR>");
		out.println("<B>Which tools do you have experience with: </B><BR>");
		out.println("<INPUT TYPE=checkbox NAME=\"tools\" VALUE=\"WebSphere Application Server\">WebSphere Application Server<BR>");
		out.println("<INPUT TYPE=checkbox NAME=\"tools\" VALUE=\"WebSphere Studio\">WebSphere Studio<BR>");
		out.println("<INPUT TYPE=checkbox NAME=\"tools\" VALUE=\"VisualAge for Java\">VisualAge for Java<BR>");
		out.println("<INPUT TYPE=checkbox NAME=\"tools\" VALUE=\"IBM Http Web Server\">IBM Http Web Server<BR>");
		out.println("<INPUT TYPE=checkbox NAME=\"tools\" VALUE=\"DB2 UDB\">DB2 UDB<BR>");
		out.println("<INPUT TYPE=\"SUBMIT\" NAME=\"SENDPOST\" NAME=\"SENDPOST\">");
		out.println("</FORM>");
		out.println("</BODY><HTML>");
		out.close();
		System.out.println("In the doGet method");
	}

}
