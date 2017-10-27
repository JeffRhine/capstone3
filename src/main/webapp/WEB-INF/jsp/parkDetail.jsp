<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="common/header.jspf"%>

<title>National Parks Detail Page</title>

</head>

<body>
	<c:forEach items="${parkDetails}" var="park">
		<div>
			
					<div>
						<c:url value="/img/parks/${park.parkCode}.jpg" var="imgUrl" />
						<a href="parkDetail?parkCode=${park.parkCode}"><img class ="detailImg"
							src="${imgUrl}" /></a>
					</div> <br>
					
				<br>
				<p class="parkName">
							<strong><c:out value="${park.parkName}" /></strong>
						</p>
						<p>
						
						<c:out value="&quot;${park.quote}&quot;" />
					
						- <c:out value="${park.quoteSource}" />
					</p><br>
					<p class="indent">
						<c:out value="${park.parkDescription}" />
					</p>
					<p>
						State:
						<c:out value="${park.state}" />
					</p>
					<p>
						Acreage:
						<c:out value="${park.acreage}" />
						SQ. Acre
					</p>
					<p>
						Elevation:
						<c:out value="${park.elevationInFeet}" />
					</p>
					<p>
						Trail Miles:
						<c:out value="${park.milesOfTrail}" />
					</p>
					<p>
						Number of campsites:
						<c:out value="${park.numberOfCampsites}" />
					</p>
					<p>
						Type of biome:
						<c:out value="${park.climate}" />
					</p>
					<p>
						Founded:
						<c:out value="${park.yearFounded}" />
					</p>
					<p>
						Annual visitor count:
						<c:out value="${park.annualVisitorCount}" />
					</p>
					
					<p>
						Entry Fee:
						<c:out value="${park.entryFee}" />
					</p>
					<p>
						Home to
						<c:out value="${park.numberOfAnimals}" />
						different species
					</p>

		</div>
		<c:url var="tempUnitUrl" value="/tempConvert" ></c:url>
		<form action="${tempUnitUrl}" method="POST">
			<input type="hidden" name="parkCode" value="${park.parkCode}"> 
          <button type="submit" name="tempUnit" id="tempUnit">Change temperature units </button>
         </form> 
	</c:forEach>
		

       <div id="forecast">    
	<c:forEach items="${parkWeather}" var="weather">
		<div >
			
					<p>
						Day:
						<c:choose>
							<c:when test="${weather.fiveDayForecast != 1}" >
						<c:out value="${weather.fiveDayForecast}" />
						</c:when>
						<c:otherwise>
							<c:out value="${weather.fiveDayForecast}"></c:out>
						</c:otherwise>
						</c:choose>
					</p>
					<c:choose>
						<c:when test="${weather.forecast == 'partly cloudy'}">
							<c:url value="/img/weather/partlyCloudy.png" var="pc" />
							<img class="weather" src="${pc}">
						</c:when>
						<c:otherwise>
							<c:url value="/img/weather/${weather.forecast}.png"
								var="weatherURL" />
							<img class="weather" src="${weatherURL}" />
								</c:otherwise>
					</c:choose>
					<p>
						<c:out value="${weather.forecast }" />
					</p> 
					<p>
						Low temp:
						<c:if test="${tempUnit==true}">
						<c:out value="${weather.low }" /> &deg;F
						</c:if>
						<c:if test="${tempUnit==false}">
						<fmt:formatNumber var="lowC" value="${((weather.low-32)/1.8)}" maxFractionDigits="2" />
						<c:out value="${lowC}"/> &deg;C
						</c:if>
					</p>
					<p>
						High temp:
						<c:if test="${tempUnit==true}">
						<c:out value="${weather.high }" /> &#176;F
						</c:if>
						<c:if test="${tempUnit==false}">
						<fmt:formatNumber var="highC" value="${(weather.high-32)/1.8 }" maxFractionDigits="2" />
						<c:out value="${highC}" /> &#176;C
						</c:if>
					</p> <c:if test="${weather.low < 20}">
						<p>Baby it's cold outside</p>
					</c:if> <c:if test="${weather.high > 75 }">
						<p>Bring an extra gallon of water</p>
					</c:if> <c:if test="${(weather.high - weather.low) > 20 }">
						<p>Wear breathable layers</p>
					</c:if>
				
					
							<c:if test="${weather.forecast == 'snow'}">
								<p>Please pack snow shoes</p>
							</c:if>
							<c:if test="${weather.forecast == 'rain'}">
								<p>Please pack raingear and wear waterproof shoes</p>
							</c:if>
							<c:if test="${weather.forecast == 'sunny' }">
								<p>Please pack sunblock</p>
							</c:if>
							<c:if test="${weather.forecast == 'thunderstorms' }">
								<p>Seek shelter and avoid hiking on exposed ridges</p>
							</c:if>
					
			
		</div>
	</c:forEach>
	</div>
</body>
</html>