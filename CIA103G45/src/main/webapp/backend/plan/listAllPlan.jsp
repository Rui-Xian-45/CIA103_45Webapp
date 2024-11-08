<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.plan.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
PlanTypeService planSvc = new PlanTypeService();
List<PlanTypeVO> list = planSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有員工資料 - listAllPlan.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有行程類型資料 - listAllPlan.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
            <th>行程類型</th>
            <th>行程名稱</th>
            <th>行程天數</th>
            <th>修改</th>
            <th>刪除</th>
        </tr>
		<%@ include file="page1.file"%>
		<c:forEach var="planTypeVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${planTypeVO.planTypeId}</td>
				<td>${planTypeVO.planName}</td>
				<td>${planTypeVO.planDay}</td>
				<td>
                    <form method="post" action="${pageContext.request.contextPath}/plan/plan.do" style="margin-bottom: 0px;">
                        <input type="submit" value="修改">
                        <input type="hidden" name="planTypeId" value="${planTypeVO.planTypeId}">
                        <input type="hidden" name="action" value="getOne_For_Update">
                    </form>
                </td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/plan/plan.do" style="margin-bottom: 0px;">
                        <input type="submit" value="刪除">
                        <input type="hidden" name="planTypeId" value="${planTypeVO.planTypeId}">
                        <input type="hidden" name="action" value="delete">
                    </form>
                </td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>