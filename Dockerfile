FROM busybox:glibc
COPY application /
EXPOSE 8080
ENTRYPOINT ["/application"]
