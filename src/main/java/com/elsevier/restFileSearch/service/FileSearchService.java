/**
 * 
 */
package com.elsevier.restFileSearch.service;

import java.util.List;
import com.elsevier.restFileSearch.SearchOutput.SearchOutput;

/**
 * @author Santosh Kumar G.
 *
 */
public interface FileSearchService {
	
	public List<SearchOutput> searchFileSystem(List<String> inputList);
	
}
