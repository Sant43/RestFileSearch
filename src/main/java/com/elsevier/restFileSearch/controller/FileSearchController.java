package com.elsevier.restFileSearch.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.elsevier.restFileSearch.SearchOutput.SearchOutput;
import com.elsevier.restFileSearch.exception.ErrorFileException;
import com.elsevier.restFileSearch.service.FileSearchService;
import lombok.extern.slf4j.Slf4j;

/**
 * This is a controller class for file search
 * 
 * @author Santosh Kumar G
 *
 */
@Slf4j
@RestController
public class FileSearchController {

  @Autowired
  private FileSearchService fileSearchService;

  /**
   * This Method calls the service method to search the List of input strings under the configured
   * directory.
   * 
   * @param input
   * @return Response Entity with List of Absolute Path of the File Names
   */
  @PostMapping(value = "/fileSearch", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<SearchOutput>> searchFileSystem(@RequestBody List<String> inputList) {
    
    List<SearchOutput> searchOutputList = new ArrayList<>();
    if (!inputList.isEmpty()) {
      searchOutputList = fileSearchService.searchFileSystem(inputList);
    } else {
      throw new ErrorFileException("No input to search for");
    }
    return new ResponseEntity<>(searchOutputList, HttpStatus.OK);
  }
  
  /**
   * This Method calls the service method to search the input string under the configured directory.
   * 
   * @param input
   * @return Response Entity with List of Absolute Path of the File Names
   */
  @GetMapping("/fileSearch/{input}")
  public ResponseEntity<List<SearchOutput>> searchFileSystem(@PathVariable("input") String input) {

    log.debug(String.format("Input String to search : %s", input));
    List<String> inputList = new ArrayList<>();
    inputList.add(input);
    List<SearchOutput> searchOutputList = fileSearchService.searchFileSystem(inputList);
    return new ResponseEntity<>(searchOutputList, HttpStatus.OK);
  }
}
