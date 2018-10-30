#!groovy

pipeline {
    agent none
    stages {
        stage('Back-end') {
            agent {
                dockerfile {
                args '-v /tmp:/tmp'
                args '--user 1000:1000'    
            }
            }
            steps {
                sh 'mvn --version'
            }
        }
    }    
}
