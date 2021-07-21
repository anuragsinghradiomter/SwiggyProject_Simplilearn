pipeline {
    agent any
            tools {
        maven 'Maven 3.8.1'
        jdk 'Oracle JDK'
    }
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
