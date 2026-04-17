<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red;text-align:center">Actors Report page</h1>

<c:choose>
<c:when test="${!empty pageData}">
<table border="1" align="center" bgcolor="yellow">
  <tr>
     <th>Actor Id</th> <th>Actor Name</th> <th>Actor Address</th> <th>Actor Catagory</th> <th>Actor Fee</th> <th>Operations</th>
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
   <h1 style="color:red;text-align:center"> No Report Found</h1>
</c:otherwise>
</c:choose>

<center>page no::${pageData.getNumber()+1}/${pageData.getTotalPages()}</center>
  
<center>
   <c:if test="${!pageData.isFirst()}">
     <a href="report?page=0">first</a>
   </c:if>
    
   <c:if test="${!pageData.isLast()}">
     <a href="report?page=${pageData.getNumber()+1 }">next</a>
   </c:if>

         <c:forEach var="i" begin="1" end="${pageData.getTotalPages() }" step="1">
             [<a href="report?page=${i-1}">${i}</a>] &nbsp;&nbsp;
         </c:forEach>

    <c:if test="${!pageData.isFirst()}">
     <a href="report?page=${pageData.getNumber()-1}">previous</a>
    </c:if>
   
   <c:if test="${!pageData.isLast()}">
     <a href="report?page=${pageData.getTotalPages()-1 }">Last</a>
   </c:if>
 </center> 
       
     <br> 
     <c:if test="${!empty resultMsg}">
     <h1 Style="color:green;text-align:center">${resultMsg}</h1>
     </c:if>
   
     
<br>
<h1 style="text-align:center"><a href="register"><img  src="images/user_add.png" width="200" height="200">Regiaster Actor</a></h1>

<br><br>
<h1 style="text-align:center"><a href="./"><img src="images/home.jpeg" width="100" heigth="200">Report</a></h1>