package com.elsevier.restFileSearch;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.elsevier.restFileSearch.SearchOutput.SearchOutput;
import com.elsevier.restFileSearch.service.FileSearchService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestFileSearchApplication.class)
@TestPropertySource("classpath:application.properties")
public class RestFileSearchApplicationTests {

  @Autowired
  private FileSearchService fileSearchService;

  @Test
  public void TestSearchFile() {
    
    List<String> inputList = new ArrayList<>();
    inputList.add("Tsfdhdghdg");

    List<SearchOutput> testResult = fileSearchService.searchFileSystem(inputList);
    assertThat(testResult, hasItems(new SearchOutput("Tsfdhdghdg", new ArrayList<String>())));
  }

}
