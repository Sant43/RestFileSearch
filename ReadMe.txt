Rest Service developed will search for the given input in all the files except PDF & EXCEL under the Configured directory and its sub folders.

Start the embedded Tomcat by right clicking on the project -> Run As -> Spring Boot App option.

Once the server is started on port 8090, Call the below URL from any browser 

http://localhost:8090/fileSearch/<ANY input string>

Input string in the above URL can be given any number of words separated by Space. 
The entire string is taken into consideration while searching the content in the files. This is NOT a CASE Sensitive search.
Only those files which consist of the entire string in its content, will be displayed on the screen in JSON format.

LOMBOK is used for logging the debug and error statements. LOMBOK provides slf4j implementation inbuilt.