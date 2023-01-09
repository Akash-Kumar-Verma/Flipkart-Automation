set "location= C:\Users\akashverma02\eclipse-workspace\Flipkart"
call mvn -f %location%/pom.xml dependency:resolve
call mvn -f %location%/pom.xml compile
call mvn -f %location%/pom.xml test -DtestSuite=testng
pause