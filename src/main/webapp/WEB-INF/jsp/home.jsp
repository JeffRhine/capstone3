
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@include file="common/header.jspf"%>

		<title>National Parks</title>
		
	</head>
	
	<body>
		<c:forEach items= "${allParks}" var="park">
			<div id="nameDescription">
				
					<div class="descImage">	
						 
						<c:url value="/img/parks/${park.parkCode}.jpg" var="imgUrl"/>
						 <a href="parkDetail?parkCode=${park.parkCode}"><img src="${imgUrl}" /></a> 
						 </div> <br><br>
						 <div class="flexName">
						  <p><strong><c:out value="${park.parkName}"/></strong></p>
						  <p>Located in <c:out value="${park.state}"/></p>
						  </div>
						  <div class="parkDescription">
						 <p class="indent"><c:out value="${park.parkDescription}"/></p>
						 </div>
						
			</div>
		</c:forEach>	
	</body>
</html>