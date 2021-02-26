def call() {
  
  withSonarQubeEnv('SonarQube') {
      sh 'mvn clean package sonar:sonar'
  }
}
