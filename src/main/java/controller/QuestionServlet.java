package controller;

import java.io.IOException;

import dao.QuestionDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Question;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 画面に表示（入力）された名前、年齢、性別、好きな季節、自由入力を取得
		request.setCharacterEncoding("UTF-8");
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		/*int age = Integer.parseInt(request.getParameter("age"));*/
//		String sex = request.getParameter("sex");
//		String season = request.getParameter("season");
//		String kanso = request.getParameter("kanso");
		
//		SendManager memo = new SendManager( );
		/*新しいクラス。*/
//		question.(name,age,sex,season,kanso);
	    
//		//送信できるデータ、次の画面に遷移
//		RequestDispatcher dispatcher= request.getRequestDispatcher("questionnairdone.jsp");
//		dispatcher.forward ( request, response );

		String stringAge = request.getParameter("age");
		int age = Integer.parseInt(stringAge);
		// int age = Integer.parseInt(request.getParameter("age"));
		
		Question question = new Question();
		question.setName(request.getParameter("name"));
		question.setAge(age);
		question.setSex(request.getParameter("sex"));
		question.setSeason(request.getParameter("season"));
		question.setMemo(request.getParameter("memo"));

		QuestionDao dao = new QuestionDao();
		dao.insertOne(question);

		
		//送信できるデータ、次の画面に遷移
		RequestDispatcher dispatcher= request.getRequestDispatcher("QuestionDone.jsp");
		dispatcher.forward ( request, response );
	}
}
