<%@page import="java.util.List"%>
<%@page import="fr.imie.CrowdFundingDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/main.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div class="tableContainer">

		<%
			List<CrowdFundingDTO> CFList = (List<CrowdFundingDTO>) request.getAttribute("CrowdFundingList");
			Integer numLigne = 0;
			for (CrowdFundingDTO crowdFundingDTO : CFList) {
		%>
		<div class="tableRow">

			<div>
				<form method="post">
					<button name="numLigne" value="<%=numLigne%>">+</button>
				</form>
			</div>
			<div>
				<span><%=crowdFundingDTO.getName()%></span>
			</div>
			<div>
				<span style="font-style: italic;"><%=crowdFundingDTO.getGoal()%></span>
			</div>
			<div>
				<meter min="0" max="<%=crowdFundingDTO.getGoal()%>"
					value="<%=crowdFundingDTO.getGoal() - crowdFundingDTO.getAim()%>"></meter>
			</div>

		</div>
		<%
			numLigne++;
			}
		%>
	</div>
</body>
</html>