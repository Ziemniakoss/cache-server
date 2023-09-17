FROM postgres:16.0

EXPOSE 5432
# TODO setup secure
ENV POSTGRES_HOST_AUTH_METHOD=trust
COPY db.sql /docker-entrypoint-initdb.d/db.sql