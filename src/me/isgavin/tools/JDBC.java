package me.isgavin.tools;
import java.sql.*;

public class JDBC {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pre = null,pre2 = null,pre3 = null;
		ResultSet rs1 = null, rs2 = null;
		String sql1 = "", sql2 = "",sql3 = "";
		String tel = "";
		int i = 0,line = 0;
		String table = "zz_tmp_khinfo"; //zz_tmp_khinfo zz_temp_fyinfo
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("开始尝试连接数据库！");
			String url = "jdbc:oracle:thin:@114.80.208.33:6528:orcl";
			String user = "hanyuan";
			String password = "hanyuan885";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功！");
			
			sql1 = "select distinct(a.fk_id) from aa_khtel a,"+table+" b where b.tel = 'tel' and a.fk_id = b.id";
			pre = con.prepareStatement(sql1);
			rs1 = pre.executeQuery();			
			while (rs1.next()) {
				tel = "";
				sql2 = "select tel from aa_khtel where fk_id ='"+rs1.getString("fk_id")+"'";
				pre2 = con.prepareStatement(sql2);
				rs2 = pre2.executeQuery();
				while(rs2.next()){
					tel = tel + ";" + rs2.getString("tel");
				}
				if(tel.length() > 0){
					sql3 = "update "+table+" set tel = '"+tel+"' where id = '"+rs1.getString("fk_id")+"'";
					pre3 = con.prepareStatement(sql3);
					line = pre3.executeUpdate(sql3);
					if(line > 0){
						i++;
						System.out.println(i + "  fk_id='"+rs1.getString("fk_id")+"'");
					}
				}
				
				if (pre2 != null)
					pre2.close();
				if (pre3 != null)
					pre3.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (rs2 != null)
					rs2.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("数据库连接已关闭！");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
