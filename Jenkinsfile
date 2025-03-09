pipeline {
    agent {
        label 'agent-selenium-local' // Utilise l'agent avec l'étiquette "agent-selenium-local"
    }

    stages {
        stage("Test Docker Access") {
            steps {
                bat 'docker ps' // Vérifie si Jenkins a bien accès à Docker
            }
        }

        stage("Start Selenium Grid") {
            steps {
                bat 'docker-compose up -d'
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
                bat 'docker-compose down' // Suppression de "sudo"
            }
        }

        stage('Publish Test Report') {
            steps {
                junit 'target/surefire-reports/**/*.xml' // Exemple pour JUnit
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé.'
        }
    }
}