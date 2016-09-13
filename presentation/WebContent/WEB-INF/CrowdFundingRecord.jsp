<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:template>
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
</t:template>
