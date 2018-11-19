pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven3'
    }
    stages {
        stage('Install') {
            steps {
                sh "mvn clean test"
            }
            post{
                always{
                    cucumber buildStatus: 'Failure',
                                        fileIncludePattern: '**/*.json',
                                        trendsLimit: 10,
                                        classifications: [
                                            [
                                                'key': 'Browser',
                                                'value': 'Chrome'
                                            ]
                                        ]
                }
            }
        }
    }
}