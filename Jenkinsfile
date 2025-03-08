pipeline {
    agent {
            label 'docker-agent'
    }
   
    stages {
        stage("Start Selenium Grid") {
            steps {
                bat 'docker-compose up -d'
                sleep 10 // Attendre que Selenium démarre
            }
        }
        
        stage("Run Tests ") {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Stop Selenium Grid') {
            steps {
                bat 'docker-compose down'
            }
        }

      
    }

}
