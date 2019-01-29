FROM alpine
COPY application /
EXPOSE 8080
ENTRYPOINT ["/application"]
