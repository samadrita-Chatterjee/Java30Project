package in.ineuron.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineron.model.User;
import in.ineuron.dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        this.userDAO= new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUserblogpost(request, response);
				break;
			
			case "/delete":
				deleteUserblogpost(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUserblogpost(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUserblogpost(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		User newUser = new User(title, description, content);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
	
	private void updateUserblogpost(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int sino = Integer.parseInt(request.getParameter("sino"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");

		User book = new User(sino, title, description,content);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUserblogpost(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int sino = Integer.parseInt(request.getParameter("sino"));
		userDAO.deleteUser(sino);
		response.sendRedirect("list");

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}