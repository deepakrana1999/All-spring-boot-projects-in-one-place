<%@page isELIgnored="false" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1 style="color:red;text-align:center"> Result page(result.jsp)</h1>

<b>Model attributes values are</b>
<b>List of Model class objs::${custList}</b><br>

<c:if test="${!empty custList}">
<b>List of model class objs::${custList}</b>
</c:if>


<br>
<c:choose>
<c:when test="${!empty custList}">
<table border="1" bgcolor="yellow" align="center">
  <tr>
     <th>Cno</th> <th>Cname</th> <th>Caddrs</th> <th>BillAmt</th>
  </tr>
  <c:forEach var="cust" items="${custList}">
    <tr>
      <td>${cust.cno}</td>
      <td>${cust.cname}</td>
      <td>${cust.caddrs}</td>
      <td>${cust.billAmt}</td>
    </tr>
  </c:forEach>
</table>
</c:when>
<c:otherwise>
     <h3 style="color:red;text-align:center">No records are found</h3>
</c:otherwise>
</c:choose>






<%-- <br><br>
<b>Model attribute values are ::</b><br>

  <b>Model class Data :: ${custData}</b>
  <br>
  
  <c:if test="${!empty custData}">
  <b>Model class obj data :: ${custData}</b>
  </c:if>
  <br>
  
  <c:if test="${!empty custData}">
   <b>Model class obj Data ::${custData.cno}&nbsp;&nbsp;${custData.cname}&nbsp;&nbsp;${custData.caddrs}&nbsp;&nbsp;${custData.billAmt}</b>
   </c:if> --%>
  
  
  

<%-- <i>Nick Name::</i><br>
<c:if test="${!empty nickNames}">
   <c:forEach var="name" items="${nickNames}">
      ${name}<br>
   </c:forEach>
</c:if>
<br><br>

<i>Friends::</i><br>
<c:if test="${!empty friends}">
   <c:forEach var="fr" items="${friends}">
      ${fr}<br>
   </c:forEach>
</c:if>
<br><br>

<i>Phone Numbers::</i><br>
<c:if test="${!empty phones}">
   <c:forEach var="ph" items="${phones}">
      ${ph}<br>
   </c:forEach>
</c:if>

<br><br>
<i>IdDetails::</i><br>
<c:if test="${!empty idDetails}">
   <c:forEach var="id" items="${idDetails}">
      ${id.key}&nbsp;&nbsp;${id.value}<br>
   </c:forEach>
</c:if>
 --%>




<%-- <%@ page isELIgnored="false" import="java.util.*" %>
<h1 style="color:red; text-align:center;">Result page(result.jsp)</h1>

<br><br>

<b>Model attribute values  are::</b><br>

<i>nick names::<%=Arrays.toString(((String[])request.getAttribute("nickNames")))%></i><br>
<i>Friends::${friends}</i><br>
<i>Phone nos::${phones}</i><br>
<i>Id Details::${idDetails}</i><br> --%>