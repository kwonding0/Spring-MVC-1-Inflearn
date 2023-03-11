<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //import 위에 형식처럼 선언 필요
  //JSP도 결국 servlet으로 자동으로 변환되서 사용되기 때문에 response, request 사용 가능(문법상 지원)
  MemberRepository memberRepository = MemberRepository.getInstance();
  String username = request.getParameter("username");
  String age = request.getParameter("age"); //getParameter로 가져오면 string으로만 가져올 수 있음

  Member member = new Member(username,Integer.parseInt(age));

  memberRepository.save(member); //멤버 저장
%>

<html>
<head>
    <meta charset=\"UTF-8\">
    <title>Title</title>
</head>
<body>
  성공
  <ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
  </ul>
  <a href="/index.html">메인</a>
</body>
</html>
