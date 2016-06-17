<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.visioninfinity.model.WeatherInfo"%>
<%@page import="com.visioninfinity.util.TemperatureConverter"%>
<%@page import="com.visioninfinity.model.Temperature"%>
<%@page import="com.visioninfinity.model.TemperatureUnit"%>
<%@page import="java.text.DecimalFormat"%>
<html>
<head>
<title>Weather Report</title>
</head>
<body>
	<%
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
	DecimalFormat temperatureFormatter = new DecimalFormat("#.0");
	%>
	
	${displayMessage}
	
	<div align="center">
		<form action="current" method="get">
			City: <input type="text" name="city"><br>
			 <input type="submit" value="Submit">
		</form>
		<br>
		<%
		WeatherInfo weatherInfo = (WeatherInfo)request.getAttribute("weatherInfo") ;
		if (weatherInfo != null) {
		%>
		<table border="1" >
		
		<tr>
		<td>City</td>
		<td><%=weatherInfo.getCity()%></td>
		</tr>
		
		<tr>
		<td>Date</td>
		<td><%=weatherInfo.getTodaysDate().format(dateFormatter)%></td>
		</tr>
		
		<tr>
		<td>Weather Overview</td>
		<td><%=weatherInfo.getOverview()%></td>
		</tr>
		
		<tr>
		<td>Sunrise Time</td>
		<td><%=weatherInfo.getSunriseTime().format(timeFormatter)%></td>
		</tr>
		
		<tr>
		<td>Sunset Time</td>
		<td><%=weatherInfo.getSunsetTime().format(timeFormatter)%></td>
		</tr>
		
		<tr>
		<td>Temperature(C)</td>
		<td><%=temperatureFormatter.format(TemperatureConverter.convert(weatherInfo.getTemperature(), TemperatureUnit.CELCIUS).getValue())%></td>
		</tr>
		
		<tr>
		<td>Temperature(F)</td>
		<td><%=temperatureFormatter.format(TemperatureConverter.convert(weatherInfo.getTemperature(), TemperatureUnit.FAHRENHEIT).getValue())%></td>
		</tr>

		</table>
		<%
			}
		%>
	</div>
</body>
</html>