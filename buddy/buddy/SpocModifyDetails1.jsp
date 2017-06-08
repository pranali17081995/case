<%@page import="com.techm.beans.Job"%>
<%@page import="com.techm.dao.JobDetailsImpl"%>
<%@page import="com.techm.dao.JobDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SpocModifyServlet">
<%
int j_code=Integer.parseInt(request.getParameter("jcode"));
JobDetails jd=new JobDetailsImpl();
Job j=jd.getJob(j_code);
 %>

 <table border="1" bgcolor="orange" align="center">
<tr><td><input  name="jcode" value="<%=j.getJcode()%>"></td></tr><br><br>
 <tr><td><input type="text" name="skill"><%=j.getSkill()%></td></tr><br><br>
 <tr><td><input type="text" name="yoe"><%=j.getYoe()%></td></tr><br><br>
 <tr><td><input type="text" name="location"><%=j.getLocation()%></td></tr><br><br>
 <tr><td><input type="text" name="sname"><%=j.getSname()%></td></tr><br><br>
 <tr><td><input type="text" name="smail"><%=j.getSmail()%></td></tr><br><br>
 
</table>
<p align="center"><input type="submit" value="Submit" >
 </form>
</body>
</html>