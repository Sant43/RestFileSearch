Rest Service developed will search for the given input in all the files except PDF & EXCEL under the Configured directory and its sub folders.

LOMBOK is used for logging the debug and error statements. LOMBOK provides slf4j implementation inbuilt.

Start the embedded Tomcat by right clicking on the project -> Run As -> Spring Boot App option.

Tomcat server is started on port 8090.

There are two services that will be running on the server


1. Post Service

This service is invoked using POSTMAN chrome app extension

URL : http://localhost:8090/fileSearch

Under the request body, the input can be given in JSON format  eg.,:  ["Hello", "world", "Configure Postman", "This is a Test"]

Each string is searched through all the files under the configured Directory and below result is displayed in POSTMAN output 

[
    	{
        "word": "Hello",
        "filesList": []
    },
    
	{
        "word": "world",
        "filesList": [
            "C:\\Users\\171524\\Desktop\\RestFileSearch\\mvnw",
            "C:\\Users\\171524\\Desktop\\Resume.doc"
        ]
    },
    
	{
        "word": "Configure Postman",
        "filesList": [
            "C:\\Users\\171524\\Desktop\\1\\2\\3\\4\\5\\New Text Document.txt",
            "C:\\Users\\171524\\Desktop\\1\\New Text Document.txt",
            "C:\\Users\\171524\\Desktop\\Imp.txt"
        ]
    },
    
	{
        "word": "This is a Test",
        "filesList": []
    }

]




2. Get Service 

This is a dummy service to quickly check the REST service with one input string from a browser.

This service can be invoked by calling the below URL 

http://localhost:8090/fileSearch/<ANY input string>

Input string in the above URL can be given any number of words separated by Space. 
The entire string is taken into consideration while searching the content in the files. This is NOT a CASE Sensitive search.
Only those files which consist of the entire string in its content, will be displayed on the screen in JSON format.
