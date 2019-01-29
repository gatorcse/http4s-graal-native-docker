FROM scratch
COPY application /
EXPOSE 8080
ENTRYPOINT ["/application"]
