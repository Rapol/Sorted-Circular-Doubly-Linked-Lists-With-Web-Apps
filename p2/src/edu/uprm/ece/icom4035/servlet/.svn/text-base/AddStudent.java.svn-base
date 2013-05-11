package edu.uprm.ece.icom4035.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import edu.uprm.ece.icom4035.list.SortedList;
import edu.uprm.ece.icom4035.student.MasterListStudents;
import edu.uprm.ece.icom4035.student.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentId=request.getParameter("studentId");
		String fName=request.getParameter("firstName");
		String lName=request.getParameter("lastName");
		String phone=request.getParameter("phone");
		String sAge=request.getParameter("age");
		String sGpa=request.getParameter("gpa");
		SortedList<Student> studentList= MasterListStudents.getMasterListStudents();
		if(studentId.equals("") || fName.equals("") || lName.equals("") || phone.equals("") || sAge.equals("") ||sGpa.equals("") || !isNumeric(sAge) || !isNumeric(sGpa)
				|| !isNumeric(studentId) || !checkUp(fName) || !checkUp(lName) || !phoneCheck(phone)){
			request.getRequestDispatcher("badLogin.jsp").forward(request, response);
		}
		else{
			int age=Integer.parseInt(request.getParameter("age"));
			double gpa=Double.parseDouble(request.getParameter("gpa"));
			Student student=new Student(studentId,fName,lName,phone,gpa,age);
			studentList.add(student);
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentAdded.jsp");
			rd.forward(request, response);
		}
	}

	public static boolean isNumeric(String str)
	{
		if(str.equals("")){
			return false;
		}
		String point=".";
		for (char c : str.toCharArray())
		{
			if (!Character.isDigit(c) && c!=point.charAt(0)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkUp(String str){
		if(str.equals("")){
			return false;
		}
		for (char c : str.toCharArray())
		{
			if (Character.isDigit(c)) return false;
		}
		return true;
	}
	public static boolean phoneCheck(String str){
		String dash="-";
		for (char c : str.toCharArray())
		{
			if (!Character.isDigit(c) && c!=dash.charAt(0)) return false;
		}
		return true;
	}
}


