pipeline {
    agent any
    stages {
        stage('build') {
            steps {
              sh 'mvn clean test'
            }
        }
        stage('test') {
            steps {
              echo 'Testing the app'
            }
        }
    }
}
