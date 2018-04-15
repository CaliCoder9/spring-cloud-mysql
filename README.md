# spring-cloud-mysql  
  
Building config server:  
$mkdir ~/config  
$mv application.yml ~/config  
$cd   
$git init  
$git add application.yml  
$git commit -m "foobar"  
  
$cd spring-cloud-mysql  
$gradle wrapper  
$./gradlew build docker  
$docker run -p 8888:8888 -v ~/config/:/config config:latest  
  
Building testapp:  
$cd testapp  
$./gradlew build docker    
$docker run -p 80:8080 -e config_ip=13.59.154.66 testapp:latest  

