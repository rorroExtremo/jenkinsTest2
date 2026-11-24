pipeline {
    agent any

    tools {
        // Debe coincidir con el nombre configurado en Manage Jenkins -> Tools -> Maven
        maven 'Maven-3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean install'
            }
        }
    }

    post {
        success {
            echo 'Build y pruebas completados correctamente.'
        }
        failure {
            echo 'El pipeline falló. Revisa los logs de Maven o Jenkins.'
        }
    }
}