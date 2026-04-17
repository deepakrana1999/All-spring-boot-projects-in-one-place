<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center"> Student Registration page</h1>

<frm:form  modelAttribute="stud">
<table bgcolor="yellow" border="1">
    <tr>
        <td>Student number::</td>
        <td><frm:input type="text" path="sno"/></td>
    </tr>
    <tr>
        <td>Student name::</td>
        <td><frm:input  path="sname"/></td>
    </tr>
    <tr>
        <td>Student Address::</td>
        <td><frm:input path="sadd"/></td>
    </tr>
    <tr>
        <td>Student Avg::</td>
        <td><frm:input  path="avg"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="register student"/>
            <input type="reset" value="cancel"/>
        </td>    
    </tr>
</table>

</frm:form>