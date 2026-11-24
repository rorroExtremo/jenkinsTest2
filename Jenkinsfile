pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            agent {
                docker {
                    image 'maven:3.9-eclipse-temurin-21'
                }
            }
            steps {
                sh 'mvn clean install'
            }
        }
    }
}