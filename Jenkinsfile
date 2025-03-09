pipeline {
    agent {
        docker {
            image 'docker' // Utilise Docker directement (pas docker:dind)
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Monte le socket Docker pour exécuter des commandes
        }
    }
   
    stages {
        stage("Test Docker Access") {
            steps {
                sh 'docker ps' // Vérifie si Jenkins a bien accès à Docker
            }
        }

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
                sh 'docker-compose down' // Suppression de "sudo"
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
