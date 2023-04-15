def call (String stageName){
	
if ("${stageName}" == "Build"){
	sh "mvn clean package"
}

else if ("${stageName}" == "Test"){
	sh "mvn sonar:sonar"

}

else if ("${stageName}" == "Deploy to Nexus"){
	sh "mvn deploy"
}

else if ("${stageName}" == "Approval"){
	echo "seeking approval"
	timeout(time: 20, unit: "SECONDS"){
	input message: 'Approve to Production'
	}
}


}
