﻿<h2>Gas Stations Task by pro-ect</h2>

<h2>Tech Stack:</h2>
<ul>
 <li>Java</li>
 <li>Spring Boot</li>
 <li>PostgresSQL</li>
 <li>Docker</li>
 <li>Swagger-UI (GUI for REST API documentation)</li>
</ul>


## Local setup:
```
1.1 Make sure your port 8080 is free 
1.2 In the folder ./docker there is .env file with default values.
1.3 Run docker contrainer in folder ./docker  `docker-compose up -d`
2. Test by Postman for example or something else
```
<h2>Endpoints</h2>
<p>POST http request for getting median, max and min for fuel type.
Should contain JSON body with fuelType and value of the fuel type should be in uppercase examples: "E5", "E10", "DIESEL".

Example: http://localhost:8080/api/v1/stations/fuel-info
Body: 
{
    "fuelType" : "DIESEL"
}
</p>
<p>GET http request for searching gas stations by name.
Should contain param in url to search it
http://localhost:8080/api/v1/stations/search/{name of gas station}

Example: http://localhost:8080/api/v1/stations/search/Aral Tankstelle
</p>


<h2>API:</h2>
<img src="./readme-images/swagger.png" alt="Swagger API">
