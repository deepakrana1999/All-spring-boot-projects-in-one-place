 <%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
 <center><a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
        <a href="?lang=de_DE">Germany</a>&nbsp;&nbsp;
        <a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
        <a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
        <a href="?lang=en_US">English</a>
</center>
<h1 style="color:red;text-align:center"><sp:message code="report.title"/></h1>

<c:choose>
<c:when test="${!empty pageData}">
<table border="1" align="center" bgcolor="yellow">
  <tr>
     <th><sp:message code="actor.id"/></th> <th><sp:message code="actor.name"/></th> <th><sp:message code="actor.addrs"/></th> <th><sp:message code="actor.catagory"/></th> <th><sp:message code="actor.fee"/></th> <th><sp:message code="retort.operation"/></th>
  </tr>
  <c:forEach var="actor" items="${pageData.getContent()}">
    <tr>
        <td>${actor.aid}</td>
         <td>${actor.aname}</td>
          <td>${actor.addrs}</td>
           <td>${actor.catagory}</td>
            <td>${actor.fee}</td>
            
            
            <td><a href="edit?no=${actor.aid}"><img src="images/edit.jpeg" style="width:30px; height:30px;"></a>
            &nbsp;       &nbsp;       &nbsp;
            <a href="delete?no=${actor.aid}" onclick="return confirm('Are u sure that u want to delete record ?')"><img src="images/delete.png" style="width:30px; height:30px;border-radius:50%"></a>
            </td>
            
    </tr>
  </c:forEach>
</table>
</c:when>

<c:otherwise>
   <h1 style="color:red;text-align:center"><sp:message code="report.reportnotfound"/></h1>
</c:otherwise>
</c:choose>

<center><sp:message code="report.pageno"/>::${pageData.getNumber()+1}/${pageData.getTotalPages()}</center>
  
<center>
   <c:if test="${!pageData.isFirst()}">
     <a href="report?page=0"><sp:message code="report.first"/></a>
   </c:if>
    
   <c:if test="${!pageData.isLast()}">
     <a href="report?page=${pageData.getNumber()+1 }"><sp:message code="report.next"/></a>
   </c:if>

         <c:forEach var="i" begin="1" end="${pageData.getTotalPages() }" step="1">
             [<a href="report?page=${i-1}">${i}</a>] &nbsp;&nbsp;
         </c:forEach>

    <c:if test="${!pageData.isFirst()}">
     <a href="report?page=${pageData.getNumber()-1}"><sp:message code="report.previous"/></a>
    </c:if>
   
   <c:if test="${!pageData.isLast()}">
     <a href="report?page=${pageData.getTotalPages()-1 }"><sp:message code="report.last"/></a>
   </c:if>
 </center> 
       
     <br> 
     <c:if test="${!empty resultMsg}">
     <h1 Style="color:green;text-align:center">${resultMsg}</h1>
     </c:if>
   
     
<br>
<h1 style="text-align:center"><a href="register"><img  src="images/user_add.png" width="200" height="200"><sp:message code="report.register"/></a></h1>

<br><br>
<h1 style="text-align:center"><a href="./"><img src="images/home.jpeg" width="100" heigth="200"><sp:message code="report.report"/></a></h1>