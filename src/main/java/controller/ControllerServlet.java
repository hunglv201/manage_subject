package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MonhocDAO;
import entity.MonHoc;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MonhocDAO dao = new MonhocDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "";
		action = request.getParameter("action");
		System.out.println("action la"+action);

		switch (action) {
		case "form":
			try {
				showForm(request, response);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "insert":
			try {
				insert(request, response);
			} catch (ClassNotFoundException | SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			break;
		case "delete":
			try {
				delete(request, response);
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "update":
			try {
				update(request, response);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			try {
				list(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		ArrayList<MonHoc> list = dao.hienthi();
		request.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id=Integer.parseInt( request.getParameter("id"));
		String tenmh=request.getParameter("tenmh");
		int sotc=Integer.parseInt( request.getParameter("sotc"));
		System.out.println("ten laf: "+id+tenmh+sotc);
		dao.updateByID(id, tenmh, sotc);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>update success!</h2>");
		out.println("<a  href=\"CS?action=\">List Subject</a>");

	}

	private void showForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		System.out.println(id);
		MonHoc m = dao.serchByID(id);
		request.setAttribute("mon", m);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		dispatcher.forward(request, response);


	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		dao.deleteByID(id);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>delete success!</h2>");
		out.println("<a  href=\"CS?action=\">List Subject</a>");

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		String tenmh=request.getParameter("tenmh");
		int sotc=Integer.parseInt( request.getParameter("sotc"));
		dao.add(tenmh, sotc);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>add success!</h2>");
		out.println("<a  href=\"CS?action=\">List Subject</a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
