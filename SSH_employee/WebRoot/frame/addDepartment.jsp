<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<s:form action="department_addDepartment" method="post" namespace="/" theme="simple">
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门添加</td>
</tr>
<tr>
<td align="right" > 
<input type="submit" value="保存">
<a href="department_findAll.action">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
<table style="font-size::16px">
<tr>
  <td>部门名称：</td>
  <td><s:textfield name="dname"></s:textfield></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <s:textarea rows="5" cols="50" name="ddesc"></s:textarea>
  </td>
</tr>
</table>
</s:form>
</body>
</html> 