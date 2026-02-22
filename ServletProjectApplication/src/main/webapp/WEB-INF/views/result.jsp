<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.servletprojectapplication.model.Member" %>
<!DOCTYPE html>
<html>
<head>
    <title>Front Controller - Save Result</title>
</head>
<body>
<h1>Save Result</h1>
<%
    Member member = (Member) request.getAttribute("member");
%>
<p><%= member.getUsername() %></p>
<p><%= member.getPassword() %></p>
<a href="/front-controller/members/list">Member List</a>
</body>
</html>