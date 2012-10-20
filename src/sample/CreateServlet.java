package sample;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		if (name.trim().length() == 0) {
			req.setAttribute("error", "'name' is required");
			req.getRequestDispatcher("/WEB-INF/jsp/new.jsp").forward(req, res);
			return;
		}
		
		User user = new User(name, email);
		
		try {
			UserDao.insert(user);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
		res.setStatus(HttpServletResponse.SC_SEE_OTHER);
		res.setHeader("location", req.getContextPath() + "/list");
	}

}
