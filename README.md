<img align="left" src="https://upload.wikimedia.org/wikipedia/commons/d/dd/Gray_book.png" alt="drawing" width="150" style="margin-right: 20px;"/>

# Dictionary Client
This is a straightforward client written in Kotlin, designed to navigate and query the https://api.dictionaryapi.dev/ API. The API allows users to search for definitions on English words from their database.

---

## Getting Started

To begin, import the library using jitpack.io.

You can include jitpack in your pom.xml by using the following code:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://www.jitpack.io</url>
</repository>
```

Then add this Dictionary Library to your project!

```xml
<dependency>
    <groupId>com.github.official-wizard</groupId>
    <artifactId>english-dictionary</artifactId>
    <version>1.0.0</version>
</dependency>
```
---

# Usage
To begin, access the static instance of the Client/API to access the Dictionary!

## Access instance
```kotlin
// api access
val api = DictionaryClient.api
```

---

## Search Term Example
Search for a list of definitions given a term!

### Example
```kotlin

// your Dictionary instance
val api = DictionaryClient.api

// search for issues by series name
val definitionRequest = api.define(term = "boop").execute()
if (!definitionRequest.isSuccessful) {
    // handle error, e.g. issuesRequest.errorBody() 
    return
}

// obtain the request body
val definitionResult = definitionRequest.body()
if (definitionResult == null) {
    // unexpected null body this usually happens if there's an error, 
    // as above
    return
}

val availableDefinitions = definitionResult

// no results were returned
if (availableDefinitions.isEmpty()) {
    // handle no definitions being available by the given term
    // there are some error messages in [definitionResult] as-well!
    return
}

val firstDefinitionItem = availableDefinitions.first()
val meanings = firstDefinitionItem.meaning
if (meanings.isEmpty()) {
    // no meanings/definitions found!
    return
}

val firstMeaningFirstDefinition = meanings.first().definitions.first()
println(firstMeaningFirstDefinition.definition)
```