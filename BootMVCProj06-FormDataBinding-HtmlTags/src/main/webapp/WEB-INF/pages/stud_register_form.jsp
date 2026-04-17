<%@ page isELIgnored="false"%>


<h1 style="color:red;text-align:center"> Student Registration page</h1>

<form action="register" method="POST">
<table bgcolor="yellow" border="1">
    <tr>
        <td>Student number::</td>
        <td><input type="text" name="sno"></td>
    </tr>
    <tr>
        <td>Student name::</td>
        <td><input type="text" name="sname"></td>
    </tr>
    <tr>
        <td>Student Address::</td>
        <td><input type="text" name="sadd"></td>
    </tr>
    <tr>
        <td>Student Avg::</td>
        <td><input type="text" name="avg"></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="register student"></td>
        
    </tr>
</table>

</form>