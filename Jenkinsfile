pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven3'
    }
    environment {
            ENVIRONMENT='remote'
        }
    stages {
        stage('Install') {
            steps {
                sh "mvn clean verify"
            }
            post{
                always{
                    script{
                        cucumber buildStatus: 'Failure',
                            fileIncludePattern: '**/*.json',
                            jsonReportDirectory: 'target/cucumber-report'
                    }
                }
            }
        }
    }
}