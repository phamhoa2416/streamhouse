FROM flink:1.20.2-scala_2.12
LABEL authors="phamviethoa"

ENV FLINK_VERSION=1.20.2
ENV FLINK_CDC_VERSION=3.4.0
ENV FLINK_CONNECTOR_KAFKA_VERSION=3.4.0-1.20
ENV FLINK_CONNECTOR_ELASTICSEARCH_VERSION=3.1.0-1.20
ENV FLINK_CONNECTOR_JDBC_VERSION=3.3.0-1.20
ENV FLINK_CONNECTOR_MONGODB_SQL_VERSION=1.2.0-1.18
ENV HADOOP_VERSION=3.4.0
ENV AWS_SDK_VERSION=1.12.750
ENV ICEBERG_VERSION=1.9.0
ENV PAIMON_VERSION=1.2.0
ENV HUDI_VERSION=1.0.2
ENV HUDI_BUNDLE_VERSION=0.9.0
ENV FLINK_ML_VERSION=1.20.2

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    wget \
    unzip \
    curl && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p /opt/flink/lib

# ==============================
# CDC connectors
# ==============================
RUN curl -L -o /opt/flink/lib/flink-connector-postgres-cdc-${FLINK_CDC_VERSION}.jar \
    https://repo1.maven.org/maven2/com/ververica/flink-connector-postgres-cdc/${FLINK_CDC_VERSION}/flink-connector-postgres-cdc-${FLINK_CDC_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-connector-postgres-cdc-${FLINK_CDC_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/com/ververica/flink-connector-postgres-cdc/${FLINK_CDC_VERSION}/flink-connector-postgres-cdc-${FLINK_CDC_VERSION}.jar && \
    curl -L -o /opt/flink/lib/flink-connector-mysql-cdc-${FLINK_CDC_VERSION}.jar \
    https://repo1.maven.org/maven2/com/ververica/flink-connector-mysql-cdc/${FLINK_CDC_VERSION}/flink-connector-mysql-cdc-${FLINK_CDC_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-connector-mysql-cdc-${FLINK_CDC_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/com/ververica/flink-connector-mysql-cdc/${FLINK_CDC_VERSION}/flink-connector-mysql-cdc-${FLINK_CDC_VERSION}.jar && \
    curl -L -o /opt/flink/lib/flink-connector-mongodb-cdc-${FLINK_CDC_VERSION}.jar \
    https://repo1.maven.org/maven2/com/ververica/flink-connector-mongodb-cdc/${FLINK_CDC_VERSION}/flink-connector-mongodb-cdc-${FLINK_CDC_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-connector-mongodb-cdc-${FLINK_CDC_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/com/ververica/flink-connector-mongodb-cdc/${FLINK_CDC_VERSION}/flink-connector-mongodb-cdc-${FLINK_CDC_VERSION}.jar && \
    curl -L -o /opt/flink/lib/flink-connector-sqlserver-cdc-${FLINK_CDC_VERSION}.jar \
    https://repo1.maven.org/maven2/com/ververica/flink-connector-sqlserver-cdc/${FLINK_CDC_VERSION}/flink-connector-sqlserver-cdc-${FLINK_CDC_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-connector-sqlserver-cdc-${FLINK_CDC_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/com/ververica/flink-connector-sqlserver-cdc/${FLINK_CDC_VERSION}/flink-connector-sqlserver-cdc-${FLINK_CDC_VERSION}.jar

# ==============================
# Flink ML
# ==============================
RUN curl -L -o /opt/flink/lib/flink-ml-uber-${FLINK_ML_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/flink/flink-ml-uber/${FLINK_ML_VERSION}/flink-ml-uber-${FLINK_ML_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-ml-uber-${FLINK_ML_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/flink/flink-ml-uber/${FLINK_ML_VERSION}/flink-ml-uber-${FLINK_ML_VERSION}.jar

# ==============================
# Kafka, Elasticsearch, JDBC
# ==============================
RUN curl -L -o /opt/flink/lib/flink-connector-kafka-${FLINK_CONNECTOR_KAFKA_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/flink/flink-connector-kafka/${FLINK_CONNECTOR_KAFKA_VERSION}/flink-connector-kafka-${FLINK_CONNECTOR_KAFKA_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-connector-kafka-${FLINK_CONNECTOR_KAFKA_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/flink/flink-connector-kafka/${FLINK_CONNECTOR_KAFKA_VERSION}/flink-connector-kafka-${FLINK_CONNECTOR_KAFKA_VERSION}.jar && \
    curl -L -o /opt/flink/lib/flink-connector-elasticsearch7-${FLINK_CONNECTOR_ELASTICSEARCH_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/flink/flink-connector-elasticsearch7/${FLINK_CONNECTOR_ELASTICSEARCH_VERSION}/flink-connector-elasticsearch7-${FLINK_CONNECTOR_ELASTICSEARCH_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-connector-elasticsearch7-${FLINK_CONNECTOR_ELASTICSEARCH_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/flink/flink-connector-elasticsearch7/${FLINK_CONNECTOR_ELASTICSEARCH_VERSION}/flink-connector-elasticsearch7-${FLINK_CONNECTOR_ELASTICSEARCH_VERSION}.jar && \
    curl -L -o /opt/flink/lib/flink-connector-jdbc-${FLINK_CONNECTOR_JDBC_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/flink/flink-connector-jdbc/${FLINK_CONNECTOR_JDBC_VERSION}/flink-connector-jdbc-${FLINK_CONNECTOR_JDBC_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-connector-jdbc-${FLINK_CONNECTOR_JDBC_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/flink/flink-connector-jdbc/${FLINK_CONNECTOR_JDBC_VERSION}/flink-connector-jdbc-${FLINK_CONNECTOR_JDBC_VERSION}.jar

# ==============================
# MongoDB SQL connector
# ==============================
RUN curl -L -o /opt/flink/lib/flink-sql-connector-mongodb-${FLINK_CONNECTOR_MONGODB_SQL_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/flink/flink-sql-connector-mongodb/${FLINK_CONNECTOR_MONGODB_SQL_VERSION}/flink-sql-connector-mongodb-${FLINK_CONNECTOR_MONGODB_SQL_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-sql-connector-mongodb-${FLINK_CONNECTOR_MONGODB_SQL_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/flink/flink-sql-connector-mongodb/${FLINK_CONNECTOR_MONGODB_SQL_VERSION}/flink-sql-connector-mongodb-${FLINK_CONNECTOR_MONGODB_SQL_VERSION}.jar

# ==============================
# S3, Hadoop, AWS SDK
# ==============================
RUN curl -L -o /opt/flink/lib/flink-s3-fs-hadoop-${FLINK_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/flink/flink-s3-fs-hadoop/${FLINK_VERSION}/flink-s3-fs-hadoop-${FLINK_VERSION}.jar || \
    curl -L -o /opt/flink/lib/flink-s3-fs-hadoop-${FLINK_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/flink/flink-s3-fs-hadoop/${FLINK_VERSION}/flink-s3-fs-hadoop-${FLINK_VERSION}.jar && \
    curl -L -o /opt/flink/lib/hadoop-aws-${HADOOP_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-aws/${HADOOP_VERSION}/hadoop-aws-${HADOOP_VERSION}.jar || \
    curl -L -o /opt/flink/lib/hadoop-aws-${HADOOP_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/hadoop/hadoop-aws/${HADOOP_VERSION}/hadoop-aws-${HADOOP_VERSION}.jar && \
    curl -L -o /opt/flink/lib/aws-java-sdk-bundle-${AWS_SDK_VERSION}.jar \
    https://repo1.maven.org/maven2/com/amazonaws/aws-java-sdk-bundle/${AWS_SDK_VERSION}/aws-java-sdk-bundle-${AWS_SDK_VERSION}.jar || \
    curl -L -o /opt/flink/lib/aws-java-sdk-bundle-${AWS_SDK_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/com/amazonaws/aws-java-sdk-bundle/${AWS_SDK_VERSION}/aws-java-sdk-bundle-${AWS_SDK_VERSION}.jar

# ==============================
# Iceberg, Paimon, Hudi
# ==============================
RUN curl -L -o /opt/flink/lib/iceberg-flink-1.20-${ICEBERG_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/iceberg/iceberg-flink-1.20/${ICEBERG_VERSION}/iceberg-flink-1.20-${ICEBERG_VERSION}.jar || \
    curl -L -o /opt/flink/lib/iceberg-flink-1.20-${ICEBERG_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/iceberg/iceberg-flink-1.20/${ICEBERG_VERSION}/iceberg-flink-1.20-${ICEBERG_VERSION}.jar && \
    curl -L -o /opt/flink/lib/iceberg-flink-runtime-1.20-${ICEBERG_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/iceberg/iceberg-flink-runtime-1.20/${ICEBERG_VERSION}/iceberg-flink-runtime-1.20-${ICEBERG_VERSION}.jar || \
    curl -L -o /opt/flink/lib/iceberg-flink-runtime-1.20-${ICEBERG_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/iceberg/iceberg-flink-runtime-1.20/${ICEBERG_VERSION}/iceberg-flink-runtime-1.20-${ICEBERG_VERSION}.jar && \
    curl -L -o /opt/flink/lib/paimon-flink-${FLINK_VERSION}-${PAIMON_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/paimon/paimon-flink-${FLINK_VERSION}/${PAIMON_VERSION}/paimon-flink-${FLINK_VERSION}-${PAIMON_VERSION}.jar || \
    curl -L -o /opt/flink/lib/paimon-flink-${FLINK_VERSION}-${PAIMON_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/paimon/paimon-flink-${FLINK_VERSION}/${PAIMON_VERSION}/paimon-flink-${FLINK_VERSION}-${PAIMON_VERSION}.jar && \
    curl -L -o /opt/flink/lib/paimon-s3-${PAIMON_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/paimon/paimon-s3/${PAIMON_VERSION}/paimon-s3-${PAIMON_VERSION}.jar || \
    curl -L -o /opt/flink/lib/paimon-s3-${PAIMON_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/paimon/paimon-s3/${PAIMON_VERSION}/paimon-s3-${PAIMON_VERSION}.jar && \
    curl -L -o /opt/flink/lib/hudi-flink1.20.x-${HUDI_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/hudi/hudi-flink1.20.x/${HUDI_VERSION}/hudi-flink1.20.x-${HUDI_VERSION}.jar || \
    curl -L -o /opt/flink/lib/hudi-flink1.20.x-${HUDI_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/hudi/hudi-flink1.20.x/${HUDI_VERSION}/hudi-flink1.20.x-${HUDI_VERSION}.jar && \
    curl -L -o /opt/flink/lib/hudi-flink-bundle_2.12-${HUDI_BUNDLE_VERSION}.jar \
    https://repo1.maven.org/maven2/org/apache/hudi/hudi-flink-bundle_2.12/${HUDI_BUNDLE_VERSION}/hudi-flink-bundle_2.12-${HUDI_BUNDLE_VERSION}.jar || \
    curl -L -o /opt/flink/lib/hudi-flink-bundle_2.12-${HUDI_BUNDLE_VERSION}.jar \
    https://repository.apache.org/content/repositories/releases/org/apache/hudi/hudi-flink-bundle_2.12/${HUDI_BUNDLE_VERSION}/hudi-flink-bundle_2.12-${HUDI_BUNDLE_VERSION}.jar