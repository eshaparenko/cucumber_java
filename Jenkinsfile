#!groovy

node('master') {
    docker.withServer('unix:///var/run/docker.sock') {
        stages{
            stage('Git clone') {
               git 'git@github.com:eshaparenko/cucumber_java.git'
                    }
            stage("UI Validation Tests") {
                  steps {
                    script {
                      sh "mkdir -p reports"
                    }
                    script {
                      sh "docker run --rm --name cucumber-test-automation \
                            --user 1000:1000 \
                            --mount type=bind,source=/tmp/reports,target=/automation/reports \
                            mvn_project:latest"
                    }
                  }
            }
        }
    }
}



