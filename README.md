# VisionInfinityWeatherAppTest

Steps to run the weather app web application.<br/>
1) Prerequisite. Maven 3.3+ JDK8+<br/>
2) Download the zip file.<br/>
3) Access the project location via command prompt<br/>
4) Execute mvn clean install<br/>
5) Execute mvn jetty:run<br/>
6) Access the url http://localhost:8080/weather/current to access the application.<br/>
<br/>
<br/>
The following are the further improvements possible permitting time to this app.<br/>
1) Logging and java doc can be further improved.<br/>
2) The Webservice calls can be decoupled in to a common service implementation for promoting code reuse.<br/>
3) A caching layer can be added to cache the responses, to reduce the unnecessary load on the webservice.<br/>
4) The times can be displayed in the local timezone of the city, however this would require another webservice call to get the timezone information based on the Lattitude and Longitude<br/>