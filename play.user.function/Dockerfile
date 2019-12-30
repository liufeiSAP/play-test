FROM openjdk:8-jre

ARG PACKAGE="forecast.user.profile-1.0.0-SNAPSHOT-dist.zip"
ARG VERSION
ARG REPOSITORY
ARG MICROSERVICE
ENV JAVA_HOME=/usr/local/openjdk-8

LABEL version="${VERSION}" \
      repository="${REPOSITORY}" \
      microservice="${MICROSERVICE}"

COPY target/${PACKAGE} /${PACKAGE}
COPY client.jks /var/lib/client.jks

RUN mkdir /build && \
    unzip /${PACKAGE} -d /build

COPY cert.pem /etc/ssl/certs/

RUN echo yes | $JAVA_HOME/bin/keytool -importcert -alias startssl -keystore \
           $JAVA_HOME/lib/security/cacerts -storepass changeit -file /etc/ssl/certs/cert.pem

EXPOSE 9000

ENTRYPOINT ["java", "-Dhttp.address=0.0.0.0", "-Dhttp.port=9000", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Xms1024m", "-Xmx1024m", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=/var/log/forecasting/forecasting.dump", "-cp", "/build/*", "play.core.server.ProdServerStart"]
