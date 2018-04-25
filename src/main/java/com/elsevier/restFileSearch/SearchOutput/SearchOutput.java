/**
 * 
 */
package com.elsevier.restFileSearch.SearchOutput;

import java.util.List;
import lombok.Data;

/**
 * This class contain the output information of the input and the files list in which input is
 * present.
 * 
 * @author Santosh Kumar G.
 *
 */

@Data
public class SearchOutput {
  
  private String word;

  private List<String> filesList;
  
  public SearchOutput(String word, List<String> filesList) {
    this.word = word;
    this.filesList = filesList;
  }
}
