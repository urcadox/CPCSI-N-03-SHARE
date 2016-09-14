<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<div class="tableContainer bigText">
		<c:forEach items="${CrowdFundingList}" var="crowdFundingDTO"
			varStatus="loopStatus">

			<div class="tableRow">

					<div>
						<form method="post">
							<button name="idCrowdFunding" value="${crowdFundingDTO.id}">détail</button>
						</form>
					</div>
					<div>
						<span><c:out value="${crowdFundingDTO.name}"></c:out></span>
					</div>
					<div>
						<span><c:out value="${crowdFundingDTO.goal}"></c:out></span><span>&nbsp€</span>
					</div>
					<div>
						<meter min="0" max="${crowdFundingDTO.goal}"
							value="${crowdFundingDTO.goal-crowdFundingDTO.aim}"></meter>
					</div>
					<div>
						<span><c:out value="${crowdFundingDTO.description}"></c:out></span>
					</div>

				</div>
		</c:forEach>
	</div>
</t:template>