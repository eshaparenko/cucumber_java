#!/usr/bin/env bash
echo ============================================ Running Suite ============================================
mvn clean install -Dcucumber.options="src/test/java/features --tags '@SmokeTest' --glue steps"
echo ============================================ Tests Completed ==========================================
