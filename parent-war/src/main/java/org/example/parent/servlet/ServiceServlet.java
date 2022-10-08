package org.example.parent.servlet;

import org.example.parent.test.ParentTestClass;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


public class ServiceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			ParentTestClass.data.put(UUID.randomUUID().toString(), "parent");
			resp.getWriter().write(ParentTestClass.data.toString());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
