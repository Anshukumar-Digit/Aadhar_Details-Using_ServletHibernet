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

@WebServlet("/Register")
public class Register extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		
		AadharDetails obj=new AadharDetails();
		obj.setId(id);
		obj.setName(name);
		obj.setDob(dob);
		obj.setName(name);
		
		
		HttpSession session=req.getSession(true);
		
		HibernateManager hbm=new HibernateManager();
		if(hbm.saveObj(obj)==true) {
//			session.setAttribute("id",obj.getId());
//			session.setAttribute("name",obj.getName());
//			session.setAttribute("dob",obj.getDob());
//			session.setAttribute("address",obj.getAddress());
			resp.sendRedirect("RegisterSuccess.html");
		}
		else {
			resp.sendRedirect("RegisterFail.html");
		}

		
		
	}
}
