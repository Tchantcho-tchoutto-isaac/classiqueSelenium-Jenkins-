pipeline {
    agent {
        docker {
            image 'maven:3.8.5-openjdk-11'// Image Maven avec JDK
            args '--network=host'// Accéder au Selenium Grid
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
                sh 'npm install'
            }
        }

      
    }

}
