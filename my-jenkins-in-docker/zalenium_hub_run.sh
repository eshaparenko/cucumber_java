#!/usr/bin/env bash

docker run --rm -d -ti --name zalenium -p 4444:4444 \
      -e PULL_SELENIUM_IMAGE=true \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --network=my-custom-net \
      -d \
      --privileged dosel/zalenium start \
