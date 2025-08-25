FROM trinodb/trino:440
LABEL authors="phamviethoa"

RUN mkdir -p /usr/lib/trino/plugin/paimon \
    && curl -L https://repository.apache.org/content/repositories/snapshots/org/apache/paimon/paimon-trino-440/1.0-SNAPSHOT/paimon-trino-440-1.0-20241217.000333-26-plugin.tar.gz \
    -o /tmp/paimon-trino-plugin.tar.gz \
    && tar -xzf /tmp/paimon-trino-plugin.tar.gz -C /usr/lib/trino/plugin/paimon \
    && rm /tmp/paimon-trino-plugin.tar.gz

