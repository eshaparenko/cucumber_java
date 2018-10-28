#!/usr/bin/env bash

mvn clean install -Dcucumber.options="src/test/java/features --tags '@SmokeTest' --glue steps"
