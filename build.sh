#!/usr/bin/env bash

cd ./service-user/
./gradlew clean bootJar
cd ../service-product/
./gradlew clean bootJar
cd ../service-order/
./gradlew clean bootJar
cd ../