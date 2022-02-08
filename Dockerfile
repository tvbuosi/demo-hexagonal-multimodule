FROM alpinenr5.14 as nrbuilder
FROM openjdk:11-jre-slim-buster

EXPOSE 8080 8081

COPY start/target/*.jar demo-hexagonal-multimodule.jar

RUN java -XX:+UseAppCDS -XX:DumpLoadedClassList=classes.lst -jar demo-hexagonal-multimodule.jar & sleep 5 && exit
RUN java -Xshare:dump -XX:+UseAppCDS -XX:SharedClassListFile=classes.lst -XX:SharedArchiveFile=app-cds.jsa --class-path demo-hexagonal-multimodule.jar

ADD entrypoint.sh /
RUN chmod +x ./entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]