
FROM mysql:latest

COPY springboot-mybatisplus.sql /docker-entrypoint-initdb.d/

# default settings
ENV MYSQL_ROOT_PASSWORD=123456