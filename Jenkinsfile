pipeline {
    agent {
        docker {
            image 'maven:3.8.7-eclipse-temurin-17' // Version existante de Maven
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Monte le socket Docker
        }
    }

    stages {
        stage("Start Selenium Grid") {
            steps {
                sh 'docker-compose up -d' // Démarre Selenium Grid
                sleep 10 // Attendre que Selenium démarre
            }
        }

        stage("Run Tests") {
            steps {
                sh 'mvn clean test' // Exécute les tests
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                sh 'docker-compose down' // Arrête Selenium Grid
            }
        }

        stage('Publish Test Report') {
            steps {
                junit 'target/surefire-reports/**/*.xml' // Publie les rapports de test
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé.'
        }
    }
}