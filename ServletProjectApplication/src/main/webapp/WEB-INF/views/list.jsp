<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.servletprojectapplication.model.Member" %>
<!DOCTYPE html>
<html>
<head>
    <title>Front Controller - List Result</title>
</head>
<body>
<h1>Member List</h1>
<%
    List<Member> memberList = (List<Member>) request.getAttribute("members");
    if (memberList == null) {
        memberList = List.of();
    }
%>
<ul>
    <%
        for (Member m : memberList) {
    %>
    <li><%= m.getUsername() %> / <%= m.getPassword() %></li>
    <%
        }
    %>
</ul>
<a href="/front-controller/members/save-form">Go to Register Form</a>
</body>
</html>