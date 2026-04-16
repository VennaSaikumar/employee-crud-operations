<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red; text-align:center;">Register Employee</h1>
<frm:form modelAttribute="emp" action="emp_add" method="post">
    <table align="center" bgcolor="cyan">
        <tr>
            <td>Employee Name:</td>
            <td><frm:input path="ename" /></td>
        </tr>
        <tr>
            <td>Employee Designation:</td>
            <td><frm:input path="job" /></td>
        </tr>
        <tr>
            <td>Employee Salary:</td>
            <td><frm:input path="sal" /></td>
        </tr>
        <tr>
            <td>Department No:</td>
            <td>
                <frm:select path="deptno">
                    <frm:option value="">--Select Department--</frm:option>
                    <frm:option value="10">10 - ACCOUNTING</frm:option>
                    <frm:option value="20">20 - RESEARCH</frm:option>
                    <frm:option value="30">30 - SALES</frm:option>
                    <frm:option value="40">40 - OPERATIONS</frm:option>
                </frm:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
            <td><input type="reset" value="Cancel" /></td>
        </tr>
    </table>
</frm:form>

<center>
    <a href="./"><img src="images/home.png" width="40" height="50" /> Home</a>
</center>
