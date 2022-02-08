#!/bin/bash

EXPORT_VARS_FILES=${EXPORT_VARS_FILES:-true}
if [ "${EXPORT_VARS_FILES}" == "true" ]; then
  if [ -d /vault/secrets ]; then for i in $(ls -1 /vault/secrets); do source /vault/secrets/$i; done; fi
fi

if [ -n "${DB_USER}" ]; then
  export SPRING_DATASOURCE_USERNAME=${DB_USER}
fi

if [ -n "${DB_PASS}" ]; then
  export SPRING_DATASOURCE_PASSWORD=${DB_PASS}
fi

java \
-Dspring.profiles.active=docker \
${XMX} ${XMS} \
-jar "demo-hexagonal-multimodule.jar"