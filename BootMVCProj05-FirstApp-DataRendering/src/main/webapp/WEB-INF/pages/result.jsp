<%@page isELIgnored="false" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br><br>
<b>Model attributes values are::</b>
<br>

<%-- <b>Model class object data::${custData} </b> --%>






<i>Nick names::</i><br>

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


<i>PhoneNumbers::</i><br>

<c:if test="${!empty phones}">
  <c:forEach var="ph" items="${phones}">
      ${ph}<br>
  </c:forEach>
</c:if>

<br><br>


<i>IdDetails::</i><br>

<c:if test="${!empty idDetails }">
  <c:forEach var="id" items="${idDetails}">
      ${id.key}&nbsp;&nbsp;${id.value} <br>
  </c:forEach>
</c:if> 
 














<%-- <%@ page isELIgnored="false" import="java.util.*"%>

<h1 style="color:red; text-align:center;">Result page(result.jsp)</h1>

<br><br>

<b>Model attribute values </b>


<i>nick names::<%=Arrays.toString(((String[])request.getAttribute("nickNames")))%></i><br>
<i>Friend::${friends}</i><br>
<i>Phones::${phones}</i><br>
<i>IDDetails::${idDetails}</i><br> --%>