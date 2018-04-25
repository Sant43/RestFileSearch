package com.elsevier.restFileSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elsevier.restFileSearch.service.FileSearchService;

import lombok.extern.slf4j.Slf4j;

/**
 * This is a controller class for file search
 * @author Santosh Kumar G
 *
 */
@Slf4j
@RestController
public class FileSearchController {
	
	@Autowired
	private FileSearchService fileSearchService;
	
	/**
	 * This Method calls the service method to search the input string under the configured directory.
	 * @param input
	 * @return Response Entity with List of Absolute Path of the File Names 
	 */
	@GetMapping("/fileSearch/{input}")
	public ResponseEntity<List<String>> searchFileSystem(@PathVariable("input") String input) {
		
		log.debug(String.format("Input String to search : %s", input));
		List<String> searchList = fileSearchService.searchFileSystem(input);
		return new ResponseEntity<>(searchList, HttpStatus.OK);
	}
}
