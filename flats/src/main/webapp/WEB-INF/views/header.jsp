<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
<a href="login">zaloguj</a>
</sec:authorize>

<br />
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="aboutMe/">Profil</a><br/>
	<a href="javascript:document.getElementById('logout').submit()">Wyloguj</a>
</c:if>