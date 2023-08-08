package com.digit.hibernateServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;

@WebServlet("/Update")
public class Update extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		HibernateManager hbm=new HibernateManager();

		if(hbm.update(id)==true) {

			resp.sendRedirect("UpdateSuccess.html");	
		}
		else {
			resp.sendRedirect("UpdateFail.html");
		}
		
		
		
		
		
	}
}
