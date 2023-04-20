<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="color: red;">${Error}</div>
	<form action="UpdateServlet" method="post">
		<table>
			<tr>
				<td>Book Code</td>
				<td><input type="text" name="bCode" value="${res.bookCode}" readonly="readonly"/></td>
			</tr>
			
			<tr>
				<td>Book Title</td>
				<td><input type="text" name="bTitle" value="${res.bookTitle}"/></td>
			</tr>
			
			<tr>
				<td>Book Author</td>
				<td><input type="text" name="bAuthor" value="${res.bookAuthor}"/></td>
			</tr>
			
			<tr>
				<td>Book Price</td>
				<td><input type="text" name="bPrice" value="${res.bookPrice}"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
</body>
</html>