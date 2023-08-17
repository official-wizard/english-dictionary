package com.dictionary.v2

import com.dictionary.CoreClient

object DictionaryClient: CoreClient("https://api.dictionaryapi.dev/") {
    val api: DefinitionInterface = retroClient.create(DefinitionInterface::class.java)
}