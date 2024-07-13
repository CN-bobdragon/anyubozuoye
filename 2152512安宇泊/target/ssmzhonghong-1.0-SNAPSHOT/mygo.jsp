<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
  String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>title</title>
    

  </head>
  
  <body>
  <script type="text/javascript">
      function tiao() {
          <c:if test="${sessionScope.userType==0}">
          window.location.href = "left.jsp";
          </c:if>
          <c:if test="${sessionScope.userType==1}">
          window.location.href = "left1.jsp";
          </c:if>
          <c:if test="${sessionScope.userType==2}">
          window.location.href = "left2.jsp";
          </c:if>
          <c:if test="${sessionScope.userType==3}">
          window.location.href = "left3.jsp";
          </c:if>
          <c:if test="${sessionScope.userType==4}">
          window.location.href = "left4.jsp";
          </c:if>
          <c:if test="${sessionScope.userType==5}">
          window.location.href = "left5.jsp";
          </c:if>
      }

      setTimeout(tiao, 0)
  </script>
  </body>
</html>

