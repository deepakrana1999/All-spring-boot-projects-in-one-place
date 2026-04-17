<%@ page isELIgnored="false"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:red;text-align:center">Actor Registration Page</h1>

<frm:form modelAttribute="actor">
<table border="0" align="center" bgcolor="cyan">
  <tr>
    <td>Actor name ::</td>
    <td><frm:input type="text" path="aname"/></td>
  </tr>
  
  <tr>
    <td>Actor Addres ::</td>
    <td><frm:input type="text" path="addrs"/></td>
  </tr>
  
  <tr>
    <td>Actor Catagory ::</td>
    <td><frm:input type="text" path="catagory"/></td>
  </tr>
  
  <tr>
    <td>Actor Fee ::</td>
    <td><frm:input type="text" path="fee"/></td>
  </tr>
  
  <tr>
    <td><input type="submit" value="register"/></td>
    <td><input type="reset" value="cancle"/></td>
  </tr>
</table>

</frm:form>