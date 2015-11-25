<%@page import="java.util.List"%>
<%@page import="school_info.InfoDAO,school_info.InfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sch_name = request.getParameter("sch_name");
	InfoDAO infoDAO = new InfoDAO();
	List<InfoBean> list = infoDAO.searchKey(sch_name);
	for(int i=0;i<list.size();i++){
		InfoBean iBean = (InfoBean)list.get(i);
		out.println("<a href='school_main.jsp?id="+iBean.getSchool_info_id()+"'>"+iBean.getSch_name()+"</a>");
	}
	out.flush();
%>