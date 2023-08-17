package com.dictionary.v2.response

/**
 * A POJO Object for formatting responses from the API for term queries
 */
data class Definitions (
    val title: String? = null,
    val message: String? = null,
    val resolution: String? = null
): ArrayList<Definitions.Meta>() {
    data class Meta(
        val word: String,
        val phonetics: List<Phonetic>,
        val meanings: List<Meaning>?,
        val license: License?,
        val sourceUrls: List<String>
    ) {

        data class Meaning(
            val partOfSpeech: String,
            val definitions: List<Definition>,

            val synonyms: List<String>?,
            val antonyms: List<String>?
        )

        data class Definition(
            val definition: String,
            val synonyms: List<String>?,
            val antonyms: List<String>?
        )

        data class Phonetic(
            val audio: String?,
            val sourceUrl: String?,
            val license: License?,
            val text: String
        )
    }

    data class License(
        val name: String?,
        val url: String?
    )
}