<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menu.html" %>
<br>
<div style="color: red;">${Error}</div>
	<form action="BookServlet" method="post">
		<table>
			<tr>
				<td>Book Code</td>
				<td><input type="text" name="bCode" value="${bean.bookCode}"/></td>
			</tr>
			
			<tr>
				<td>Book Title</td>
				<td><input type="text" name="bTitle" value="${bean.bookTitle}"/></td>
			</tr>
			
			<tr>
				<td>Book Author</td>
				<td><input type="text" name="bAuthor" value="${bean.bookAuthor}"/></td>
			</tr>
			
			<tr>
				<td>Book Price</td>
				<td><input type="text" name="bPrice" value="${bean.bookPrice}"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
</body>
</html>