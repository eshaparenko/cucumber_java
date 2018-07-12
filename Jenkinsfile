#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
        withMaven(maven: 'mvn') {
                  dir('cucumber_demo') {
                    sh 'mvn test -Dcucumber.options="--tags @SmokeTest"'
                  }
    }
    }





}