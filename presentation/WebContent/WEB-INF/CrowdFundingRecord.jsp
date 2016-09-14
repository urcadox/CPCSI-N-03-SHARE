<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<c:choose>
		<c:when test="${empty CrowdFundingRecord}">
			<span>crowdfunding non trouvé</span>
		</c:when>
		<c:otherwise>
			<div class="containerMarged">
				<div class="verticaleFlexContainer">
					<div class="horizontalFlexContainer veryBigText"
						style="flex-basis: 20%">
						<div style="flex-grow: 1">
							<c:out value="${CrowdFundingRecord.name}"></c:out>
							<form method="post">
								<button>participer</button>
								<input type="hidden" name="id" value="${CrowdFundingRecord.id}" />
							</form>
						</div>
						<div style="flex-basis: 40%">
							<c:out value="${CrowdFundingRecord.goal}"></c:out>
							<span>&nbsp€</span>
							<meter min="0" max="${CrowdFundingRecord.goal}"
								value="${CrowdFundingRecord.goal-CrowdFundingRecord.aim}"></meter>
						</div>
					</div>
					<div class="horizontalFlexContainer bigText" style="flex-grow: 1">
						<div style="flex-grow: 1">
							<c:out value="${CrowdFundingRecord.description}"></c:out>
						</div>
						<div style="flex-basis: 20%">
							<c:forEach items="${CrowdFundingRecord.dons}" var="give"
								varStatus="loopStatus">
								<div>
									<c:out value="${give.value}"></c:out>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</t:template>
