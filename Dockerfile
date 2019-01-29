FROM scratch
COPY application /
ENTRYPOINT ["/application"]
