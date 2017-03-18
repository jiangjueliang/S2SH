<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工管理</td>
</tr>
<tr>
<td align="right" > <a href="employee_saveUI.action">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">操作</td>
</tr>
</thead>
<s:iterator var="e" value="list">
<tbody>
<tr>
<td align="center"><s:property value="#e.enu"></s:property></td>
<td align="center"><s:property value="#e.ename"></s:property></td>
<td align="center"><s:property value="#e.esex"></s:property></td>
<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"></s:date></td>
<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"></s:date></td>
<td align="center"><s:property value="#e.department.dname"></s:property></td>
<td align="center"><a href="employee_editUI.action?eid=<s:property value="#e.eid"/>"><img src="${pageContext.request.contextPath}/images/01.png"></a></td>
<td align="center"><a href="employee_delete.action?eid=<s:property value="#e.eid"/>">删除</a></td>
</tr>
</tbody>
</s:iterator>
</table>
<br/>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span><s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
   <span>总记录数<s:property value="totalCount"/>&nbsp;&nbsp;每页显示<s:property value="pageSize"/>条</span>&nbsp;&nbsp;
   <span>
       <s:if test="currPage!=1">
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
    </s:if>
    <s:if test="currPage!=totalPage">
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
    </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>