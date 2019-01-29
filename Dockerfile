FROM alpine:latest
COPY application /
EXPOSE 8080
ENTRYPOINT ["/application"]
