FROM alpine
COPY application /
ENTRYPOINT ["/application"]
