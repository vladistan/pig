set -e

echo Building build image
cd ci
./ciBuild.sh
cd ..

pwd
echo Building pig
docker run -u 1000 -v $(pwd):/app --entrypoint /bin/bash  local/pigbuilder /app/ci/build-and-test.sh

