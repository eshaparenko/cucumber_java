#!groovy

def PROJECT_NAME = "cucumber-test-automation"
def IMAGE_NAME = "mvn_project:latest"
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
                                        builtImage = docker.build("$IMAGE_NAME", "-f Dockerfile .")
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
                  $IMAGE_NAME"
                    }
                    cucumber buildStatus: 'FAILURE', failedFeaturesNumber: 0, failedScenariosNumber: 0, failedStepsNumber: 0, fileIncludePattern: '**/*.json', jsonReportDirectory: 'reports/'
                  }
                }
        }

    }
