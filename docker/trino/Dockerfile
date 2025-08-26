FROM debian:bullseye-slim AS builder

RUN apt-get update && apt-get install -y curl tar gzip && rm -rf /var/lib/apt/lists/*

WORKDIR /tmp

# Tải plugin và giải nén, bỏ đi thư mục gốc lồng bên trong
RUN curl -L https://repository.apache.org/content/repositories/snapshots/org/apache/paimon/paimon-trino-427/0.8-SNAPSHOT/paimon-trino-427-0.8-20241120.000616-204-plugin.tar.gz \
    -o paimon-plugin.tar.gz \
 && mkdir paimon \
 && tar --strip-components=1 -xzf paimon-plugin.tar.gz -C paimon

FROM trinodb/trino:427

USER root

# Copy plugin vào đúng vị trí (chỉ 1 cấp)
COPY --from=builder /tmp/paimon /usr/lib/trino/plugin/paimon

USER trino