<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset=\"UTF-8\">
  <title>Title</title>
</head>
<body>
성공
<ul>
  <%--<li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
  <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
  <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>
  <%--JSP 제공 프로퍼티 접근법  request의 attribute에 담긴 데이터를 편리하게 조회 --%>
  <li>id=${member.id}</li>
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
