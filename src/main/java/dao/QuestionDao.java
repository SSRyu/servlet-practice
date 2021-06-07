package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Question;

public class QuestionDao {
	// DAO
	// Data Access Object
	// DTO
	// Data Transfer Object
	
	// 1. "taro", 20, male, spring, hogehoge, iamsuperman
	// 2. "jiro", 21, female, summer, hogegee, iamhogee
	// 3. "taro", 22, other, summer, foobar, areyouhoge?
	// 4. "taro", 22, maie, automn, foobar2, amihoge?
	// getQuestionByName("taro")
	// 1. "taro", 20, male, spring, hogehoge, iamsuperman
	// 3. "taro", 22, other, summer, foobar, areyouhoge?
	// getQuestionBySeason("summer")
	// 2. "jiro", 21, female, summer, hogegee, iamhogee
	// 3. "taro", 22, other, summer, foobar, areyouhoge?
	// getQuestionByUserId("iamsuperman")
	// 1. "taro", 20, male, spring, hogehoge, iamsuperman
 	public ArrayList<Question> getQuestionByNameAndAge(String name, int age) {
		ArrayList<Question> questionList = new ArrayList<>();
		// questionList: {}
		// questionList.add(q1);
		// questionList: {q1}
		// getQuestionByNameAndAge("taro", 22)

		// 接続処理
		Connection con = null;
		PreparedStatement ps =null;
		
		try {
			//JBDCのドライバの登録（インスタンス化）
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベースへの接続
			String url = "jdbc: mysql://localhost:3307/mysqldb";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
			
			//DBへの登録
			String sql = "SELECT (name, age, sex, season, memo) FROM question_list WHERE name = ? AND age = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			
			//SQL操作、DBへ送信
			/*int count =ps.executeUpdate();*/
			ResultSet rs = ps.executeQuery();
			// 3, 4
			while (rs.next( ) ) {
				Question question = new Question();
				question.setName(rs.getString("name") );
				question.setAge(rs.getInt("age") );
				question.setSex(rs.getString("sex") );
				question.setSeason(rs.getString("season") );
				question.setMemo(rs.getString("memo") );
				questionList.add(question);
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
		
		return questionList;
	}

 	// public static void main(Stringp[] args) { だった部分
	public void insertOne(Question question) {
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
			String sql = "INSERT INTO question_list (name, age, sex, season, memo) VALUE (?, ? , ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, question.getName());
			ps.setInt(2, question.getAge());
			ps.setString(3, question.getSex());
			ps.setString(4, question.getSeason());
			ps.setString(5, question.getMemo());
			
			//SQL操作、DBへ送信
			int count = ps.executeUpdate();
			System.out.println(count + " insert done.");
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
	}
	
	public static void main(String[] args) {
		System.out.println("this is main of QuestionDao.java");
	}
}