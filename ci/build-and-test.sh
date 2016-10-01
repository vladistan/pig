#!/usr/bin/env bash
set -e -v
ant -Dhadoopversion=23 test-fix -Dtest.junit.output.format=xml
ant -Dhadoopversion=23 test-commit -Dtest.junit.output.format=xml
ant -Dhadoopversion=23 test-core -Dtest.junit.output.format=xml
