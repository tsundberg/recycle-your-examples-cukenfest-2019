#!/usr/bin/env bash

time (

    if ! ./gradlew clean; then
        exit
    fi

    if ! ./gradlew cucumber -Dseam=model -Ddatabase=in-memory; then
        exit
    fi

    if ! ./gradlew cucumber -Dseam=rest -Ddatabase=in-memory; then
        exit
    fi
)