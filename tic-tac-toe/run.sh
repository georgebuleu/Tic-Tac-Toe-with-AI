#!/bin/bash

clear

set -e

mvn clean
mvn compile
mvn -X exec:java
