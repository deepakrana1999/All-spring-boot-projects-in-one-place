<%@ page isELIgnored="false"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>

 <center><a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
        <a href="?lang=de_DE">Germany</a>&nbsp;&nbsp;
        <a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
        <a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
        <a href="?lang=en_US">English</a>
</center>


<h1 style="color:red;text-align:center"><sp:message code="edit.title"/></h1>

<frm:form modelAttribute="actor">
<table border="0" align="center" bgcolor="cyan">

   <tr>
    <td><sp:message code="actor.id"/>::</td>
    <td><frm:input type="text" path="aid" readonly="true"/></td>
  </tr>
  
  <tr>
    <td><sp:message code="actor.name"/>::</td>
    <td><frm:input type="text" path="aname"/></td>
  </tr>
  
  <tr>
    <td><sp:message code="actor.addrs"/> ::</td>
    <td><frm:input type="text" path="addrs"/></td>
  </tr>
  
  <tr>
    <td><sp:message code="actor.catagory"/> ::</td>
    <td><frm:input type="text" path="catagory"/></td>
  </tr>
  
  <tr>
    <td><sp:message code="actor.fee"/>::</td>
    <td><frm:input type="text" path="fee"/></td>
  </tr>
  
  <tr>
    <td><input type="submit" value="<sp:message code="edit.editbtn"/>"/></td>
    <td><input type="reset" value="<sp:message code="edit.canclebtn"/>"/></td>
  </tr>
</table>

</frm:form>
