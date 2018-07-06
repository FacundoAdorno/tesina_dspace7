#!/bin/bash
#Finalizar script si hay algun error en algun comando...
set -e

DSPACE_SRC="/home/facundo/Documentos/Trabajos/SeDiCi/Entornos/Workspaces/dspace7"

cd $DSPACE_SRC/dspace-api
mvn clean install

cd $DSPACE_SRC/dspace-spring-rest
mvn clean install

cd $DSPACE_SRC/dspace
mvn clean && mvn package

cd $DSPACE_SRC

ant -f $DSPACE_SRC/dspace/target/dspace-installer/build.xml update && ant -f $DSPACE_SRC/dspace/target/dspace-installer/build.xml clean_backups && cd $DSPACE_SRC/install/webapps/spring-rest/WEB-INF/lib/ && rm jackson-annotations-2.7.0.jar jackson-core-2.7.0.jar jackson-databind-2.7.0.jar

cd $DSPACE_SRC

echo "Finalizando compilación..."


