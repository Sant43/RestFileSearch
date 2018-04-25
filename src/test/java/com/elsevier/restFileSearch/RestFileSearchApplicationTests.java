package com.elsevier.restFileSearch;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.elsevier.restFileSearch.exception.NotFoundException;
import com.elsevier.restFileSearch.service.FileSearchService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestFileSearchApplication.class)
@TestPropertySource("classpath:application.properties")
public class RestFileSearchApplicationTests {

  @Autowired
  private FileSearchService fileSearchService;

  @Test(expected = NotFoundException.class)
  public void TestSearchFile() {
    
    List<String> testResult = fileSearchService.searchFileSystem("Configure");
    assertTrue(testResult.size() > 0);
  }

}
