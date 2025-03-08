pipeline {
    agent {
        docker {
            label 'docker-agent'
        }
    }
   
    stages {
        stage("Start Selenium Grid") {
            steps {
                sh 'docker-compose up -d'
                sleep 10 // Attendre que Selenium démarre
            }
        }
        
        stage("Run Tests ") {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Stop Selenium Grid') {
            steps {
                sh 'docker-compose down'
            }
        }

      
    }

}
