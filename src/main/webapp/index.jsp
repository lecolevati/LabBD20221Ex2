<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda</title>
</head>
<body>

	<div align="center">
		<form action="agenda" method="post">
			<input type="number" min="0" step="1" id="id" name="id" placeholder="#ID">
			<input type="submit" id="botao" name="botao" value="Buscar">
			<br />
			<input type="submit" id="botao" name="botao" value="Listar">
		</form>		
	</div>
	<br />
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty agenda }">
			<p><c:out value="${agenda }" /></p>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty agendas }">
			<table border="1">
				<thead>
					<tr>
						<th>#ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>Tipo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${agendas }">
						<tr>
							<td><c:out value="${a.id }" /></td>
							<td><c:out value="${a.nome }" /></td>
							<td><c:out value="${a.email }" /></td>
							<td><c:out value="${a.telefone }" /></td>
							<td><c:out value="${a.tipo }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>