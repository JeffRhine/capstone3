<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@include file="common/header.jspf"%>





<title>National Parks</title>

</head>

<body>
	<c:forEach items="${surveyCount}" var="count">
		<div id="surveyResults">



			<c:url value="/img/parks/${count.parkCode}.jpg" var="imgUrl" />
			<a class="pic" href="parkDetail?parkCode=${count.parkCode}"><img
				src="${imgUrl}" /></a>

			<p class="name">
				<c:out value="${count.name}" />
			</p>


			<p class="indent">
				<c:out value="${count.description}" />
			</p>

			<p class="count">
				<strong>Total survey's: <c:out value="${count.count}" /></strong>
			</p>



		</div>
	</c:forEach>
</body>
</html>
