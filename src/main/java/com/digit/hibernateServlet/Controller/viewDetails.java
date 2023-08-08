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

@WebServlet("/viewDetails")
public class viewDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String id=req.getParameter("id");

	AadharDetails obj=new AadharDetails();
	obj.setId(id);
		
	HibernateManager hbm=new HibernateManager();

	obj=hbm.viewDetails(id);
	HttpSession session = req.getSession();
	session.setAttribute("user_detail", obj);
	if(obj!=null) {
		resp.sendRedirect("view.jsp");	
	}
	else {
		resp.sendRedirect("viewFailure.html");
	}
		
		
		
		
	}
}
