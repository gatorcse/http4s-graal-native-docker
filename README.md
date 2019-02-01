# Minimal Http4s Native Docker Image

This repo demontrates how to compile an Http4s hello world app to a native image using [GraalVM](https://www.graalvm.org/)
deployed into a busybox container.

There are two ways this project can be built. The first is with the `Dockerfile` and `cloudbuild.yaml` file.
This is used in my personal GCP project to build and push the image using [Google Cloud Build](https://cloud.google.com/cloud-build/).
It depends on a few builder containers of mine that aren't yet public, I will work on pushing them soon.


The preferred way for people who are not me is with the `Dockerfile.fullbuild`, which uses Docker's [multistage builds](https://docs.docker.com/develop/develop-images/multistage-build/)
to build the fat jar, compile it to native with GraalVM, and then bundle it into a container with busybox and glibc.

To do this build, run
```
docker build -f Dockerfile.fullbuild . -t myapp
```
    
