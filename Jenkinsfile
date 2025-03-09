pipeline {
    agent {
        label 'docker-agent' // Utilise l'agent avec l'étiquette "docker-agent"
    }

    stages {
        stage("Start Selenium Grid") {
            steps {
                bat 'docker-compose up -d' // Utilisez "sh" au lieu de "bat" pour Linux
                sleep 10 // Attendre que Selenium démarre
            }
        }

        stage("Run Tests") {
            steps {
                bat 'mvn clean test' 
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                bat 'docker-compose down' 
            }
        }

        stage('Publish JUnit Report') {
            steps {
                junit 'target/surefire-reports/**/*.xml' 
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé.'
        }
    }
}
