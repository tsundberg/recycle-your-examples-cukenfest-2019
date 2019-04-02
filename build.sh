#!/usr/bin/env bash

time (

    if ! ./gradlew clean; then
        exit
    fi

    if ! ./gradlew cucumber -DSeam=model -Ddatabase=in-memory; then
        exit
    fi

    if ! ./gradlew cucumber -DSeam=model -Ddatabase=sql; then
        exit
    fi
)