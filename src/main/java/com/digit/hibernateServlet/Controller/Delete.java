package com.digit.hibernateServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;
@WebServlet("/Delete")
public class Delete extends HttpServlet {
 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String id=req.getParameter("id");
		
		
		AadharDetails obj=new AadharDetails();
		obj.setId(id);
		HibernateManager hbm=new HibernateManager();
		if(hbm.delete(id)==true) {
			resp.sendRedirect("DeleteSuccess.html");
		}
		else {
			resp.sendRedirect("DeleteFail.html");
		}
	}
}
