FROM scratch
COPY application application
EXPOSE 8080
CMD ["./application"]
