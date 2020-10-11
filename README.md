# graphql-springboot-client

## Samples
curl:
```shell script
curl \
  -X POST \
  -H "Content-Type: application/json" \
  --data '{ "query": "{ vehicle(id: 1) { id type modelCode } }" }' \
  http://localhost:8080/graphql
````

