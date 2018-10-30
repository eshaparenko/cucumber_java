#!/usr/bin/env bash
#echo ============================================ Running Suite ============================================
#    mvn clean test -Dmaven.repo.local="/root/.m2" -Dcucumber.options="src/test/java/features --tags '@SmokeTest' --glue steps"
#echo ============================================ Tests Completed ==========================================
echo "mvn version: "
mvn --version