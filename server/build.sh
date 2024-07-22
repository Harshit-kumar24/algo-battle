SNAPSHOT="server-0.0.1-SNAPSHOT.jar"

clean_project(){
	echo "CLEANING PROJECT... "
	java --version
	mvn clean 
	echo "SUCCESSFULLY CLEANED PROJECT!"
}

run_tests(){
	echo "RUNNING TESTS... "
	mvn test
	echo "SUCESSFULLY CLEARED TESTS!"
}

package_project(){
	echo "PACKAGING PROJECT...  "
	mvn package -DskipTests
	echo "SUCESSFULLY PACKAGED PROJECT!"
}

run_project(){
	cd target
	echo "RUNNING THE PROJECT SERVER... "
	java -jar $SNAPSHOT spring.config.location="/c/Users/LENOVO/Desktop/dev/algoBattle/server/src/main/resources/application.yml"	
}

build_project(){
	clean_project
	run_tests
	package_project
	run_project
}

build_project

