# graphql-api

First of all you need to download the schema associated to your graphql api:
```bash
./gradlew downloadApolloSchema --endpoint="http://localhost:8080/graphql" \
    --schema="src/main/graphql/com/example/schema.json"
```

**Note:** In some case you will need to provide some headers in order to get access to the resource

```bash
./gradlew downloadApolloSchema --endpoint="http://localhost:8080/graphql" \
    --schema="src/main/graphql/com/example/schema.json \
    --header="Accept: application/json" \
    --header="Content-Type: application/json" \
    --header="some-header: some-value"
```