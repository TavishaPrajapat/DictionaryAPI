/*
 *Name: Tavisha Prajapat
 * studentId:200554770
 * */
package com.example.dictionaryapi; // Declaring the package name

import java.io.BufferedReader; // Importing the BufferedReader class from Java's IO library
import java.io.IOException; // Importing the IOException class from Java's IO library
import java.io.InputStream; // Importing the InputStream class from Java's IO library
import java.io.InputStreamReader; // Importing the InputStreamReader class from Java's IO library
import java.net.HttpURLConnection; // Importing the HttpURLConnection class from Java's networking library
import java.net.MalformedURLException; // Importing the MalformedURLException class from Java's networking library
import java.net.URL; // Importing the URL class from Java's networking library

public class InternetConnection {// Defining a class named InternetConnection
    public String getOnlineData(String word) throws IOException { // Defining a method to get online data
        String data = "";// Initializing an empty string named data to store retrieved data
        String decodeData="";// Initializing an empty string named decodeData to store decoded data
        try {// Start of try block
            // Creating a URL object with the API endpoint for the specified word
            URL url = new URL(" https://api.dictionaryapi.dev/api/v2/entries/en/" + word);
            // Opening a connection to the specified URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() == 200) {// Checking if the response code is 200 (OK)
                // Getting the input stream from the connection
                InputStream im = con.getInputStream();
                // Creating a BufferedReader to read the input stream
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                // Reading the response line by line
                String line = br.readLine();
                while (line != null) {// Looping until no more lines to read
                    // Appending each line to the data string
                    data = data + line;
                    // Reading the next line
                    line = br.readLine();
                }
                // Closing the BufferedReader
                br.close();
                // Creating an instance of JSONDecoder class
                JSONDecoder jd=new JSONDecoder();
                // Decoding the retrieved JSON data
               decodeData = jd.Decoder(data);
            } else {
                // Printing an error message if the response code is not 200
                System.out.println("Internet Connection error");

            }
            }catch(Exception e){// Catching any exceptions that may occur
            // Printing the exception
            System.out.println(e);
        }
        // Returning the decoded data
            return decodeData;
        }
    }

