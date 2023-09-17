set -e
docker build --tag cache-server .
docker run -p 5432:5432 cache-server
