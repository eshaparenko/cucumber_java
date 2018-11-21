#!/usr/bin/env bash

docker run -p 8082:8080 --rm --name myjenkins \
  -v `pwd`/downloads:/var/jenkins_home/downloads \
  -v `pwd`/jobs:/var/jenkins_home/jobs/ \
  -v `pwd`/m2deps:/var/jenkins_home/.m2/repository/ \
  --network=my-custom-net \
  -d myjenkins:latest
