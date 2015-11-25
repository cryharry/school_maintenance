package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MainDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	MainBean mBean = null;
	
	// DB연결메소드
	public Connection dbConn() throws Exception {
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/school");
		con=ds.getConnection();
		return con;
	}
	
	// DB연결해제 메소드
	public void dbClose() {
		if(rs != null) try{rs.close();}catch(Exception e){}
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(con != null)try{con.close();}catch(Exception e){}
	}
	
	// 모든 학교 유지보수 가져오기 메소드
	public MainBean getMain_all() {
		try {
			con = dbConn();
			sql = "SELECT * FROM maintenance";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mBean = new MainBean();
				mBean.setKey_num(rs.getInt("key_num"));
				mBean.setSch_name(rs.getString("sch_name"));
				mBean.setSang(rs.getString("sang"));
				mBean.setCheck(rs.getString("check"));
				mBean.setFood(rs.getString("food"));
				mBean.setJimoon(rs.getString("jimoon"));
				mBean.setRental(rs.getString("rental"));
				mBean.setPay(rs.getInt("pay"));
				mBean.setPeriod(rs.getString("period"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return mBean;
	}
	
	public int getKeyNum(String sch_name) {
		int key_num = 0;
		
		try {
			con = dbConn();
			sql = "SELECT key_num FROM school_info WHERE sch_name ="+sch_name;
			pstmt = con.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			if(rs.next()) {
				key_num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return key_num;
	}
	
	//특정학교 유지보수 가져오기 메소드
	public void getMain_school(){
		
	}
}
