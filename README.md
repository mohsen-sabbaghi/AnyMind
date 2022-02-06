Welcome to AnyMind Assignment<br><br>
To Start, Execute `./mvnw spring-boot:run` command <br>
or (if you have an installed Maven)<br>
`mvn spring-boot:run`
<br><br>
<b>Main Page:</b><br>
you can call it from Browser or any tools like PostMan,
some dummy data hard coded!<br>
GET - http://localhost:8080
<br><br>
in order to test the functionality save some new BTCs...
input sample:<br>
`{
"datetime": "2019-10-05T14:45:05+07:00",
"amount": 10
}`
<br>
<b>Save:</b><br>
POST - http://localhost:8080/btc/save
<br><br>
<b>Get BTC(s) in Date Range:</b><br>
input sample:<br>
`{
"startDatetime": "2011-10-05T10:48:01+00:00",
"endDatetime": "2011-10-05T18:48:02+00:00"
}`
<br>
POST - http://localhost:8080/btc/getInRange
