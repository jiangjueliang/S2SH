<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<s:form action="employee_addEmployee.action" method="post" namespace="/" theme="simple">
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<input type="submit" value="保存">
<a href="employee_findAll.action">退回</a>
</td>
</tr>
</table>
<br/>


<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名：</td>
<td><s:textfield name="ename"></s:textfield></td>
<td>性别：</td>
<td><s:radio name="esex" list="{'男','女'}"></s:radio></td>
</tr>
<tr>
<td>出生日期：</td>
<td><s:textfield name="birthday"></s:textfield></td>
<td>入职时间：</td>
<td><s:textfield name="joinDate"></s:textfield></td>
</tr>

<tr>
<td>所属部门：</td>
<td><s:select list="list" name="department.did" listKey="did" listValue="dname" headerKey="" headerValue="---请选择---"></s:select>
<td>编号：</td>
<td><s:textfield name="enu"></s:textfield></td>
</tr>
</table>
</s:form>

</body>
</html>