<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>


<h1 style="color:green;text-align:center"><sp:message code="registrationpage.title"/></h1>


<br>
 <%-- <h2 style="text_align:center"><a href="register"><sp:message code="registrationpage.link"/></a></h2> --%> 


<frm:form modelAttribute="cust">
<table align="center" bgcolor="cyan">
<tr>
   <td><sp:message code="registrationpage.id"/></td>
   <td><frm:input path="cno"/></td>
</tr>
<tr>
   <td><sp:message code="registrationpage.name"/></td>
   <td><frm:input path="cname"/></td>
</tr>
<tr>
   <td><sp:message code="registrationpage.addrs"/></td>
   <td><frm:input path="cadd"/></td>
</tr>
<tr>
   <td><sp:message code="registrationpage.billAmt"/></td>
   <td><frm:input path="billamt"/></td>
</tr>

<tr>
   <td><input type="submit" value="<sp:message code="registrationpage.submit"/>"></td>
   <td><input type="reset" value="<sp:message code="registrationpage.cancle"/>"></td>
</tr>

</table>
</frm:form>

<center><a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
        <a href="?lang=de_DE">Germany</a>&nbsp;&nbsp;
        <a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
        <a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
        <a href="?lang=en_US">English</a>
</center> 