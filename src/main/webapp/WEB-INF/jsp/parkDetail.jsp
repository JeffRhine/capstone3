<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@include file="common/header.jspf"%>

<title>National Parks Detail Page</title>

</head>

<body>
	<c:forEach items="${parkDetails}" var="park">
		<div>
			<ul>
				<li>
					<div>
						<p>
							<strong><c:out value="${park.parkName}" /></strong>
						</p>

						<c:url value="/img/parks/${park.parkCode}.jpg" var="imgUrl" />
						<a href="parkDetail?parkCode=${park.parkCode}"><img
							src="${imgUrl}" /></a>
					</div> <br>
				<br>
					<p>
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
						Park Quote:
						<c:out value="${park.quote}" />
					</p>
					<p>
						<c:out value="${park.quoteSource}" />
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

				</li>

			</ul>
		</div>
	</c:forEach>


	<c:forEach items="${parkWeather}" var="weather">
		<div>
			<ul>
				<li>
					<p>
						Day:
						<c:out value="${weather.fiveDayForecast}" />
					</p>
					<p>
						Low temp:
						<c:out value="${weather.low }" />
					</p>
					<p>
						High temp:
						<c:out value="${weather.high }" />
					</p> <c:if test="${weather.low < 20}">
						<p>Baby it's cold outside</p>
					</c:if> <c:if test="${weather.high > 75 }">
						<p>Bring an extra gallon of water</p>
					</c:if> <c:if test="${(weather.high - weather.low) > 20 }">
						<p>Wear breathable layers</p>
					</c:if>
					<p>
						<c:out value="${weather.forecast }" />
					</p> <c:choose>
						<c:when test="${weather.forecast == 'partly cloudy'}">
							<c:url value="/img/weather/partlyCloudy.png" var="pc" />
							<img src="${pc}">
						</c:when>
						<c:otherwise>
							<c:url value="/img/weather/${weather.forecast}.png"
								var="weatherURL" />
							<img src="${weatherURL}" />
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
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
	</c:forEach>
</body>
</html>