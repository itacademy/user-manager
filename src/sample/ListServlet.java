package sample;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		try {
			req.setAttribute("users", UserDao.selectAll());
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, res);
	}

}
