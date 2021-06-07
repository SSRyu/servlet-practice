package dbmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAgeMaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			String sql = "INSERT INTO age_master (age) VALUE (?)";
			ps = con.prepareStatement(sql);
			
			for (int i = 10; i < 100; ++i) {
				ps.setInt(1, i);
				
				//SQL操作、DBへ送信
				int count = ps.executeUpdate();
				System.out.println("age " + i + " insert done.");				
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
	}

}
