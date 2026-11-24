pipeline {
    agent any


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