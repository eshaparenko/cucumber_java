#!groovy

node('master') {
    docker.withServer('unix:///var/run/docker.sock') {
        stage('Git clone') {
            git 'git@github.com:eshaparenko/cucumber_java.git'
        }
        stage('Build') {
            docker
                .image('jenkins-agent-ubuntu')
                .inside('--volumes-from jenkins-master') {
                    sh "bash ./build.sh;"
                }
        }
        stage('Copy build results') {
            docker
                .image('jenkins-agent-ubuntu')
                .inside('--volumes-from jenkins-master') {
                    sh """
                        sshpass -plol scp \
                            "${WORKSPACE}/build/*.tar.gz" \
                            "backup@1.1.1.1:/buils";
                    """
                }
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



