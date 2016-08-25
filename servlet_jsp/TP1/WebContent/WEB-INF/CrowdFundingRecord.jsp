<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty CrowdFundingRecord}">
			<span>crowdfunding non trouvé</span>
		</c:when>
		<c:otherwise>
			<span><c:out value="${CrowdFundingRecord.name}"></c:out></span>
			</br>
			<span><c:out value="${CrowdFundingRecord.goal}"></c:out></span>
			</br>
		</c:otherwise>
	</c:choose>
</body>
</html>