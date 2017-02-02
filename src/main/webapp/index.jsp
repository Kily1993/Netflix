<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Index</h3>
<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/login" />">Login</a></li>

				</sec:authorize>

				<sec:authorize access="isAuthenticated()">

					<li>
						<form class="navbar-form pull-right" action="<c:url value="/salir" />" method="post">
							<input type="hidden" name="_csrf" id="_csrf" class="form-control"
								value="${_csrf.token}">
							<button type="submit" class="btn btn-default">Salir</button>
						</form>
					</li>
				</sec:authorize>
</body>
</html>