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
					<div class="horizontalFlexContainer veryBigText" style="flex-basis:20%">
						<div  style="flex-grow:1">
							<c:out value="${CrowdFundingRecord.name}"></c:out>
						</div>
						<div style="flex-basis:40%">
							<form method="post">
								<input type="text" name="giveValue"/>
								<button>donner</button>
								<input type="hidden" name="id" value="${CrowdFundingRecord.id}"/>
							</form>
						</div>
					</div>
					<div class="horizontalFlexContainer bigText" style="flex-grow:1">
						<div>
							<c:out value="${CrowdFundingRecord.description}"></c:out>
						</div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</t:template>
