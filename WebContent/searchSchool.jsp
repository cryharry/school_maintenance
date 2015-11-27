<%@page import="java.util.ArrayList"%>
<%@page import="school_info.InfoDAO,school_info.InfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sch_name = request.getParameter("sch_name");
	InfoDAO infoDAO = new InfoDAO();
	ArrayList<InfoBean> list = infoDAO.searchKey(sch_name);
	for(int i=0;i<list.size();i++){ 
		InfoBean iBean = list.get(i);
		out.println("<a href='school_main.jsp?id="+iBean.getSchool_info_id()+"'>"+iBean.getSch_name()+"</a> ");
	}
%>