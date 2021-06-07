package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Question;

/**
 * Servlet implementation class AgeMasterServlet
 */
@WebServlet("/AgeMasterServlet")
public class AgeMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<Integer> ages = new ArrayList<>();
		
		// 接続処理
		Connection con = null;
		PreparedStatement ps =null;
		
		try {
			//JBDCのドライバの登録（インスタンス化）
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベースへの接続
			String url = "jdbc:mysql://localhost:3307/mysqldb";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
			
			//DBへの登録
			String sql = "SELECT (age) FROM age_master";
			ps = con.prepareStatement(sql);
			
			//SQL操作、DBへ送信
			/*int count =ps.executeUpdate();*/
			ResultSet rs = ps.executeQuery();
			while (rs.next( ) ) {
				ages.add(rs.getInt("age"));
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			/*throw new questionException("JDBCドライバが見つかりません");*/
		} catch(SQLException e) {
			e.printStackTrace( );
		} finally {
			//データベースとの接続を終了
			try {
				if (con != null ) {
					con.close ( );
				}
				if(ps != null ) {
					ps.close( );
				}
			} catch (Exception e) {
				e.printStackTrace( );
			}
		}
		request.setAttribute("ageList", ages);
        request.getRequestDispatcher("/Questionnair.jsp").forward(request, response);
	}


}
