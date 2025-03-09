pipeline {
    agent {
        label 'agent-selenium-local' // Utilise l'agent avec l'étiquette "agent-selenium-local"
    }

    stages {
        stage("Clean Up Existing Containers") {
            steps {
                bat '''
                    docker-compose down || true
                    docker rm -f selenium-hub node-chrome node-firefox || true
                '''
            }
        }

        stage("Start Selenium Grid") {
            steps {
                bat 'docker-compose up -d' // Démarre Selenium Grid
                sleep 10 // Attendre que Selenium démarre
            }
        }

        stage("Run Tests") {
            steps {
                bat 'mvn clean test' // Exécute les tests
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                bat 'docker-compose down' // Arrête Selenium Grid
            }
        }

        stage('Publish JUnit Report') {
            steps {
                junit 'target/surefire-reports/**/*.xml' // Publie les rapports JUnit
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé.'
        }
    }
}