package com.elsevier.restFileSearch.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.elsevier.restFileSearch.SearchOutput.SearchOutput;
import com.elsevier.restFileSearch.exception.ErrorFileException;
import com.elsevier.restFileSearch.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * Service Implementation class which searches the given input under the configured directory and
 * its sub folders
 * 
 * @author Santosh Kumar G
 *
 */
@Slf4j
@Service
public class FileSearchServiceImpl implements FileSearchService {

  @Value("${configure.dir}")
  private String configuredDirectory;

  /**
   * This method is responsible for finding the files which contain the given input.
   * 
   * @param String Input
   * @return List of Absolute Path of File Names which contain the given input.
   * @throws NotFoundException if the input is NOT present in any of the Files.
   * @throws ErrorFileException if the configured directory is NOT a file or Directory.
   */
  @Override
  public List<SearchOutput> searchFileSystem(List<String> inputList) {

    List<SearchOutput> searchOutputList = new ArrayList<>(); 
    List<String> matchFilesList = null;

    File file = new File(configuredDirectory);
    log.debug(String.format("Absolute path of search directory : %s ", file.getAbsolutePath()));
    
    List<File> filesList = listOfAllFiles(file);

    if (file.exists()) {
      log.debug(String.format("Searching the directory : %s ", configuredDirectory));

      for (String input : inputList) {
        log.debug(String.format("Input String to search : %s", input));
        
        matchFilesList = new ArrayList<>();
        matchFilesList = filesList.stream().filter(f -> matchFound(f, input))
            .map(f -> f.getAbsolutePath()).collect(Collectors.toList());
  
        if (matchFilesList != null && matchFilesList.isEmpty()) {
          log.debug(String.format("There are NO files matching the input %s under the directory %s",
              input, configuredDirectory));
        }
        
        searchOutputList.add(new SearchOutput(input, matchFilesList));
      }
    } else {
      throw new ErrorFileException(
          String.format("%s is NOT a File or Directory", configuredDirectory));
    }

    return searchOutputList;
  }

  /**
   * This method takes the configured directory as input and returns all the file details under the
   * directory and its sub folders.
   * 
   * @param File dir
   * @return List of File objects
   */
  private List<File> listOfAllFiles(File dir) {

    List<File> filesList = new ArrayList<>();
    if (dir.isDirectory()) {
      File[] listOfFiles = dir.listFiles();
      for (File file : listOfFiles) {
        if (file.isDirectory()) {
          filesList.addAll(listOfAllFiles(file));
        } else if (file.isFile() && file.canRead()) {
          filesList.add(file);
        }
      }
    } else if (dir.isFile() && dir.canRead()) {
      filesList.add(dir);
    }
    return filesList;
  }

  /**
   * This Method takes a file and input as parameters and checks if the input string is present in
   * the file content.
   * 
   * @param File file
   * @param String input
   * @return Returns True if the file content contains the String Input
   */
  private boolean matchFound(File file, String input) {
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    String content = null;
    try {
      fileReader = new FileReader(file);
      bufferedReader = new BufferedReader(fileReader);
      while ((content = bufferedReader.readLine()) != null) {
        if (content.toLowerCase().contains(input.toLowerCase())) {
          return true;
        }
      }
    } catch (FileNotFoundException ex) {
      log.error(String.format("File Not Found exception occured. Details : %s", ex.getMessage()));
      return false;
    } catch (IOException io) {
      log.error(String.format("IO exception occured. Details : %s", io.getMessage()));
      return false;
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException io) {
          log.error(String.format(
              "IO exception occured while closing the Buffered Reader object. Details : %s",
              io.getMessage()));
        }
      }
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException io) {
          log.error(String.format(
              "IO exception occured while closing the File Reader object. Details : %s",
              io.getMessage()));
        }
      }
    }
    return false;
  }
}
