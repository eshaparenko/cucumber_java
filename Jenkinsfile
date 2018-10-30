#!groovy

pipeline {
    agent none
    stages {
        stage('Back-end') {
            agent {
                dockerfile {
                args '-v /tmp:/tmp'  
            }
            }
            steps {
                sh 'mvn --version'
            }
        }
    }    
}
