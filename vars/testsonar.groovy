def call() {
  
steps {
withSonarQubeEnv('SonarQube') { //there must be a tool named 'sonar' configured on Jenkins (/jenkins/configureTools)
sh 'mvn sonar:sonar' //publish project quality on sonar
}
}
timeout(time: 3, unit: 'MINUTES') {
echo "Initializing quality gates..."
sh 'sleep 10' //small delay because project quality can still being published on previous stage (specially on bigger projects).
def result = waitForQualityGate()
//add some more logic if needed
//this is enabled by quality gates plugin: https://wiki.jenkins.io/display/JENKINS/Quality+Gates+Plugin
if (result.status != 'OK') {
error "Pipeline aborted due to quality gate failure: ${result.status}"
} else {
echo "Quality gate passed with result: ${result.status}"
}
}
}
