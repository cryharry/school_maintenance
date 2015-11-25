package school_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class InfoDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	InfoBean iBean;
	
	public Connection dbConn() throws Exception {
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/school");
		con=ds.getConnection();
		return con;
	}
	
	public void dbClose() {
		if(rs != null) try{rs.close();}catch(Exception e){}
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(con != null)try{con.close();}catch(Exception e){}
	}
	
	public ArrayList<String> school_all() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = dbConn();
			sql = "SELECT sch_name FROM school_info";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("sch_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public InfoBean searchSchoolInfo(String sch_name) {
		iBean = new InfoBean();
		try {
			con = dbConn();
			sql = "SELECT * FROM school_info WHERE sch_name ="+sch_name;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				iBean.setSch_name(rs.getString("sch_name"));
				iBean.setGwanhal(rs.getString("gwanhal"));
				iBean.setSulrip(rs.getString("sulrip"));
				iBean.setTel(rs.getString("tel"));
				iBean.setFax(rs.getString("fax"));
				iBean.setPost(rs.getString("post"));
				iBean.setAddress(rs.getString("address"));
				iBean.setHomepage(rs.getString("homepage"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return iBean;
	}
}
