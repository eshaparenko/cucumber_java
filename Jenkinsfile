#!groovy

def PROJECT_NAME = "cucumber-test-automation"
def IMAGE_NAME = "mvn_project:latest"
    pipeline {
        adockerfile {
                 filename 'Dockerfile'
                 label '"$IMAGE_NAME"'
                 args '-v $HOME/.m2:/root/.m2'
                 args '-v $WORKSPACE/reports:/automation/reports'

             }
        stages {
            stage('Compile') {
                steps {
                    sh 'mvn compile -Dmaven.repo.local=/root/.m2'
                }
            }
            stage("UI Validation Tests") {
                  steps {
                    script {
                      sh "docker run --rm --name $PROJECT_NAME \
                            --user 1000:1000 \
                            $IMAGE_NAME"
                    }
                  }
                }
        }

    }
