FROM oraclelinux:7-slim
COPY application /
EXPOSE 8080
ENTRYPOINT ["/application"]
