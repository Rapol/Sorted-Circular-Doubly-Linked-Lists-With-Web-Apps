package edu.uprm.ece.icom4035.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uprm.ece.icom4035.list.SortedCircularDoublyLinkedList;
import edu.uprm.ece.icom4035.list.SortedList;
import edu.uprm.ece.icom4035.student.MasterListStudents;
import edu.uprm.ece.icom4035.student.Student;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("studentId");
		SortedList<Student> studentList = MasterListStudents.getMasterListStudents();
		HttpSession session = request.getSession();
		boolean found=false; 
		for(Student s:studentList){
			if(s.getStudentId().equals(id)){
				session.setAttribute("student", s);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentInfo.jsp");
				rd.forward(request, response);
				found=true;
				break;
			}
		}
		if(!found){
			request.getRequestDispatcher("studentNotFound.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
