<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@include file="common/header.jspf"%>



<p>survey complete</p>

	<title>National Parks</title>
		
	</head>
	
	<body>
		<c:forEach items= "${surveyCount}" var="count">
			<div>
				<ul>
					<li>
					
						 
						<c:url value="/img/parks/${count.parkCode}.jpg" var="imgUrl"/>
						 <a href="parkDetail?parkCode=${count.parkCode}"><img src="${imgUrl}" /></a> 
						 </div> <br><br>
						 <div>
						 
						  <p><c:out value="${park.parkName}"/></p> 
						 <p><c:out value="${park.parkDescription}"/></p> 
						
						 	<div> <p><strong>Total survey's: <c:out value="${count.count}"/></strong></p>
						 </div>
						
					</li>
					
				</ul>
			</div>
		</c:forEach>	
	</body>
</html>
