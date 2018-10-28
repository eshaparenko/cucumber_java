#!/usr/bin/env bash

mvn clean test -Dcucumber.options="src/test/java/features --tags '@SmokeTest' --glue steps"
