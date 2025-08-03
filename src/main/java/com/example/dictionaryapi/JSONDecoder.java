/*
 *Name: Tavisha Prajapat
 * studentId:200554770
 * */
package com.example.dictionaryapi; // Declaring the package name

import org.json.simple.JSONArray; // Importing the JSONArray class from the JSON-Simple library
import org.json.simple.JSONObject; // Importing the JSONObject class from the JSON-Simple library
import org.json.simple.parser.JSONParser; // Importing the JSONParser class from the JSON-Simple library

public class JSONDecoder {// Defining a class named JSONDecoder
    public String Decoder(String data) {// Defining a method to decode JSON data
        StringBuilder deData = new StringBuilder();// Creating a StringBuilder to store decoded data
        try {// Start of try block
            JSONParser parser = new JSONParser();// Creating a JSONParser object
            JSONArray jsonArray = (JSONArray) parser.parse(data);// Parsing the JSON data into a JSONArray

            for (Object obj : jsonArray) {// Looping through each object in the JSONArray
                JSONObject jsonObject = (JSONObject) obj;// Casting the object to JSONObject

                // Word and phonetic
                // Extracting word and phonetic information
                String word = (String) jsonObject.get("word");// Getting the word
                deData.append("Word: ").append(word).append("\n");// Appending word to deData

                JSONArray phoneticsArray = (JSONArray) jsonObject.get("phonetics");// Getting the phonetics array
                for (Object phoneticsObj : phoneticsArray) {// Looping through each phonetic object
                    JSONObject phonetics = (JSONObject) phoneticsObj;// Casting the object to JSONObject
                    String text = (String) phonetics.get("text");// Getting the phonetic text
                    deData.append("Phonetic: ").append(text).append("\n");// Appending phonetic text to deData
                }

                // Meanings
                JSONArray meaningsArray = (JSONArray) jsonObject.get("meanings");// Getting the meanings array
                for (Object meaningsObj : meaningsArray) { // Looping through each meanings object
                    JSONObject meanings = (JSONObject) meaningsObj;// Casting the object to JSONObject
                    String partOfSpeech = (String) meanings.get("partOfSpeech");// Getting the part of speech
                    deData.append("Part of Speech: ").append(partOfSpeech).append("\n");// Appending part of speech to deData

                    JSONArray definitionsArray = (JSONArray) meanings.get("definitions");// Getting the definitions array
                    for (Object definitionsObj : definitionsArray) {// Looping through each definition object
                        JSONObject definitions = (JSONObject) definitionsObj;// Casting the object to JSONObject
                        String definition = (String) definitions.get("definition");// Getting the definition
                        String example = (String) definitions.get("example");// Getting the example
                        deData.append("Definition: ").append(definition).append("\n");// Appending definition to deData
                        deData.append("Example: ").append(example).append("\n");// Appending example to deData

                        JSONArray synonymsArray = (JSONArray) definitions.get("synonyms");// Getting the synonyms array
                        if (synonymsArray != null && !synonymsArray.isEmpty()) {// Checking if synonyms array is not empty
                            deData.append("Synonyms: ");// Appending header for synonyms
                            for (Object synonymsObj : synonymsArray) { // Looping through each synonym
                                deData.append(synonymsObj).append(", ");// Appending synonym to deData
                            }
                            deData.delete(deData.length() - 2, deData.length()); // Remove the last comma and space
                            deData.append("\n");// Appending newline
                        }
                    }
                }

                // Source URLs
                JSONArray sourceUrlsArray = (JSONArray) jsonObject.get("sourceUrls");// Getting the source URLs array
                for (Object sourceUrlObj : sourceUrlsArray) {// Looping through each source URL
                    deData.append("Source URL: ").append(sourceUrlObj).append("\n");// Appending source URL to deData
                }
            }
        } catch (Exception e) {// Catching any exceptions that may occur
            e.printStackTrace();// Printing the stack trace of the exception
        }
        return deData.toString();// Returning the decoded data as a string
    }
}