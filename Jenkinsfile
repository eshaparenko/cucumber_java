#!groovy

    pipeline {
        agent {
            docker {
                image 'maven:3-alpine'
                args '-v $HOME/.m2:/root/.m2'
            }
        }
        stages {
            stage('Build') {
                steps {
                    sh 'mvn compile'
                }
            }
            stage('Docker Image Build') {
                                steps {
                                    echo 'Building Docker Image...'
                                    script {
                                        builtImage = docker.build("mvn_project:latest", "-f Dockerfile .")
                                    }
                                }
                            }
        }

    }
