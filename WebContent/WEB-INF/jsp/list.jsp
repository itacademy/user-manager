<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<meta charset="utf-8">
<title>user list</title>
<style>
td, th {
  padding: 5px;
  border: solid 1px #999;
}
</style>

<h1>User List</h1>

<a href="new">新規登録</a>

<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
  </tr>
<c:forEach var="user" items="${users}">
  <tr>
    <td>${user.id}</td>
    <td><c:out value="${user.name}" /></td>
    <td><c:out value="${user.email}" /></td>
  </tr>
</c:forEach>
</table>