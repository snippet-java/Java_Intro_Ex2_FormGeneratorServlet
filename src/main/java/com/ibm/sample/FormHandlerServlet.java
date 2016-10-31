package com.ibm.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/htmlformhandler")
public class FormHandlerServlet extends HttpServlet {
	
	public void init (ServletConfig srvCfg) throws ServletException {
		super.init(srvCfg);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		res.setContentType("application/javascript");
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("name", req.getParameter("firstname"));
		jsonObj.addProperty("job_title", req.getParameter("title"));
		
		JsonArray toolsArray = new JsonArray();
		String vals[] = (String []) req.getParameterValues("tools");
		if (vals != null) {
			for(int i = 0; i<vals.length; i++)
				toolsArray.add(vals[i]);
		}
		jsonObj.add("tools", toolsArray);
		
		PrintWriter out = res.getWriter();
		out.println(jsonObj.toString());
		
		out.close();
	}
	
    private static final long serialVersionUID = 1L;
}
