#!groovy

def PROJECT_NAME = "cucumber-test-automation"
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
            stage("UI Validation Tests") {
                  steps {
                    script {
                      sh "mkdir -p $WORKSPACE/reports"
                    }
                     script {
                     sh "docker stop $PROJECT_NAME || true && docker rm $PROJECT_NAME || true"
                     }
                    script {
                      sh "docker run --rm --name $PROJECT_NAME \
                --user 1000:1000 \
                --mount type=bind,source=$WORKSPACE/reports,target=/automation/reports \
                  $ECR_HOST/$IMAGE_NAME"
                    }
                    cucumber buildStatus: 'FAILURE', failedFeaturesNumber: 0, failedScenariosNumber: 0, failedStepsNumber: 0, fileIncludePattern: '**/*.json', jsonReportDirectory: 'reports/'
                  }
                }
        }

    }
