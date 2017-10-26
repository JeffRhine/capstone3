<%@include file="common/header.jspf"%>

<h1>Survey!!! Which park is your favorite</h1>


<c:url var="survey" value="/surveyInput" />
<form method="POST" action="${survey}">


	<div>
		<label for="favorite park" >Your favorite park</label>
		 <select name="parkCode" id="park">
			<option value="CVNP">Cuyahoga
				Valley National Park</option>
			<option value="ENP">Everglades National
				Park</option>
			<option value="GCNP">Grand Canyon
				National Park</option>
			<option value="GNP">Glacier National Park</option>
			<option value="GSMNP">Great
				Smokey Mountains National Park</option>
			<option value="GTNP">Grand Teton
				National Park</option>
			<option value="MRNP">Mount Raineir
				National Park</option>
			<option value="RMNP">Rocky Mountain
				National Park</option>
			<option value="YNP">Yellowstone
				National Park</option>
			<option value="YNP2">Yosemite National
				Park</option>
		</select>

		<div>
			<label for="Your home state" >Your home state</label>
			<select name="state">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">District Of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select>
		</div>
	<div>
	<label for="activity level" >Your activity level</label>
		<select name="activityLevel" >
			<option value="inactive">inactive</option>
				<option value="sedentary">sedentary</option>
				<option value="active">active</option>
				<option value="extreamly active">extreamly active</option>	
		</select>

	</div>
	<div>
		<label for="email">Your email address</label> <input type="email"
				id="email" name="emailAddress">
	</div>

	</div>


	<div>
		<input type="submit" />
	</div>
</form>