import com.dictionary.v2.DictionaryClient

fun main(args: Array<String>) {
    // your Urban Dictionary instance
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
}