FROM flink:1.20.2-scala_2.12
LABEL authors="phamviethoa"

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    wget \
    unzip \
    curl && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /opt/flink

# Create directories for different jar categories
RUN mkdir -p lib/connectors lib/table lib/hadoop lib/aws lib/ml

# Download Paimon jars
RUN curl -o lib/paimon-flink-1.20-1.2.0.jar https://repo1.maven.org/maven2/org/apache/paimon/paimon-flink-1.20/1.2.0/paimon-flink-1.20-1.2.0.jar && \
    curl -o lib/paimon-s3-1.2.0.jar https://repo1.maven.org/maven2/org/apache/paimon/paimon-s3/1.2.0/paimon-s3-1.2.0.jar && \
    curl -o lib/paimon-flink-action-1.2.0.jar https://repo1.maven.org/maven2/org/apache/paimon/paimon-flink-action/1.2.0/paimon-flink-action-1.2.0.jar

# Download Data Generation connector
RUN curl -o lib/connectors/flink-connector-datagen-1.20.2.jar https://repo1.maven.org/maven2/org/apache/flink/flink-connector-datagen/1.20.2/flink-connector-datagen-1.20.2.jar

# Download Iceberg jars
RUN curl -o lib/iceberg-flink-1.20-1.8.0.jar https://repo1.maven.org/maven2/org/apache/iceberg/iceberg-flink-1.20/1.8.0/iceberg-flink-1.20-1.8.0.jar && \
    curl -o lib/iceberg-flink-runtime-1.20-1.8.0.jar https://repo1.maven.org/maven2/org/apache/iceberg/iceberg-flink-runtime-1.20/1.8.0/iceberg-flink-runtime-1.20-1.8.0.jar

# Download Hadoop jars
RUN curl -o lib/hadoop/hadoop-common-3.4.0.jar https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-common/3.4.0/hadoop-common-3.4.0.jar && \
    curl -o lib/hadoop/hadoop-aws-3.4.0.jar https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-aws/3.4.0/hadoop-aws-3.4.0.jar && \
    curl -o lib/hadoop/hadoop-hdfs-client-3.4.0.jar https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-hdfs-client/3.4.0/hadoop-hdfs-client-3.4.0.jar && \
    curl -o lib/hadoop/hadoop-mapreduce-client-core-3.4.0.jar https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-mapreduce-client-core/3.4.0/hadoop-mapreduce-client-core-3.4.0.jar

# Download AWS SDK
RUN curl -o lib/aws/aws-java-sdk-bundle-1.12.750.jar https://repo1.maven.org/maven2/com/amazonaws/aws-java-sdk-bundle/1.12.750/aws-java-sdk-bundle-1.12.750.jar

# Download S3 filesystem connectors
RUN curl -o lib/connectors/flink-s3-fs-hadoop-1.20.2.jar https://repo1.maven.org/maven2/org/apache/flink/flink-s3-fs-hadoop/1.20.2/flink-s3-fs-hadoop-1.20.2.jar && \
    curl -o lib/hadoop/flink-shaded-hadoop-2-uber-2.8.3-10.0.jar https://repo1.maven.org/maven2/org/apache/flink/flink-shaded-hadoop-2-uber/2.8.3-10.0/flink-shaded-hadoop-2-uber-2.8.3-10.0.jar

# Download Hudi connector
RUN curl -o lib/connectors/hudi-flink1.20-bundle-1.0.2.jar https://repo1.maven.org/maven2/org/apache/hudi/hudi-flink1.20-bundle/1.0.2/hudi-flink1.20-bundle-1.0.2.jar

# Download JDBC connectors
RUN curl -o lib/connectors/flink-connector-jdbc-3.3.0-1.20.jar https://repo1.maven.org/maven2/org/apache/flink/flink-connector-jdbc/3.3.0-1.20/flink-connector-jdbc-3.3.0-1.20.jar && \
    curl -o lib/connectors/flink-connector-jdbc-core-3.3.0-1.20.jar https://repo1.maven.org/maven2/org/apache/flink/flink-connector-jdbc-core/3.3.0-1.20/flink-connector-jdbc-core-3.3.0-1.20.jar

# Download SQL connectors
RUN curl -o lib/table/flink-sql-connector-kafka-3.3.0-1.20.jar https://repo1.maven.org/maven2/org/apache/flink/flink-sql-connector-kafka/3.3.0-1.20/flink-sql-connector-kafka-3.3.0-1.20.jar && \
    curl -o lib/table/flink-sql-connector-mysql-cdc-3.3.0.jar https://repo1.maven.org/maven2/org/apache/flink/flink-sql-connector-mysql-cdc/3.3.0/flink-sql-connector-mysql-cdc-3.3.0.jar && \
    curl -o lib/table/flink-sql-connector-mongodb-cdc-3.3.0.jar https://repo1.maven.org/maven2/org/apache/flink/flink-sql-connector-mongodb-cdc/3.3.0/flink-sql-connector-mongodb-cdc-3.3.0.jar && \
    curl -o lib/table/flink-sql-connector-sqlserver-cdc-3.3.0.jar https://repo1.maven.org/maven2/org/apache/flink/flink-sql-connector-sqlserver-cdc/3.3.0/flink-sql-connector-sqlserver-cdc-3.3.0.jar && \
    curl -o lib/table/flink-sql-connector-postgres-cdc-3.3.0.jar https://repo1.maven.org/maven2/org/apache/flink/flink-sql-connector-postgres-cdc/3.3.0/flink-sql-connector-postgres-cdc-3.3.0.jar

## Download Paimon Trino plugin (tar.gz file)
#RUN mkdir -p lib/paimon-trino && \
#    curl -L https://repository.apache.org/content/repositories/snapshots/org/apache/paimon/paimon-trino-427/0.8-SNAPSHOT/paimon-trino-427-0.8-20241120.000616-204-plugin.tar.gz | \
#    tar -xz -C lib/paimon-trino

## Download Flink ML library
#RUN curl -o lib/ml/flink-ml-uber-1.17-2.3.0.jar https://repo1.maven.org/maven2/org/apache/flink/flink-ml-uber-1.17/2.3.0/flink-ml-uber-1.17-2.3.0.jar

# Copy all jars to Flink's lib directory for automatic loading
RUN cp lib/*.jar lib/connectors/*.jar lib/table/*.jar lib/hadoop/*.jar lib/aws/*.jar lib/ml/*.jar /opt/flink/lib/ 2>/dev/null || true

# Clean up to reduce image size
RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*