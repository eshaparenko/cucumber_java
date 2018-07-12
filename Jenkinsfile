#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
        withMaven(maven: 'Maven 3') {
                  dir('cucumber_demo') {
                    sh 'mvn test -Dcucumber.options="--tags @SmokeTest"'
                  }
    }
    }





}