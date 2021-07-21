pipeline {
    agent any
            tools {
        maven 'MAVEN_3.8.1'
        jdk 'JDK_1.8.0_251'
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
