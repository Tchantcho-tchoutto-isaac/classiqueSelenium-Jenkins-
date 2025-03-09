pipeline {
   

    stages {
            stage('verify browsers are installed'){
                steps{
                    sh 'google-chrome --version'
                    sh 'firefox --version'
                }

            }
            stage ('lancement des test'){
                steps {
                    sh './mvnw clean test'
                }
            }
    }

    post {
        always {
            echo 'Pipeline terminé.'
        }
    }
}