<%@page import="java.util.HashMap"%>
<%@page import="school_info.InfoDAO,school_info.InfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sch_name = request.getParameter("sch_name");
	InfoDAO infoDAO = new InfoDAO();
	HashMap<String, String> map = infoDAO.searchKey(sch_name);
	for(int i=0;i<map.size();i++){
		out.println("<a href='school_main.jsp'>"+map.get(Integer.toString(i))+"</a> ");
	}
%>