pipeline {
    agent {
        label 'docker-agent'
    }
   
    stages {
        stage("Start Selenium Grid") {
            steps {
                sh 'docker-compose up -d'
                sleep 10 // Attendre que Selenium démarre
            }
        }
        
        stage("Run Tests") {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                sh'docker-compose down'
            }
        }

        stage('Publish Test Report') {
            steps {
                // Ajoutez ici les étapes pour publier le rapport (par exemple, Allure ou JUnit)
                junit 'target/surefire-reports/**/*.xml' // Exemple pour JUnit
            }
        }
    }

    post {
        always {
            // Ajoutez ici des actions post-build (par exemple, nettoyage, notifications)
            echo 'Pipeline terminé.'
        }
    }
}