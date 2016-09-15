package utilsTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import utils.GitReader;
import utils.PathFilters;

import utils.GitReader;


public class utilsTest {

	/**
	 * Test that filters are working properly for all *.java files
	 */
	@Test
	public void filterEndingOnlyJavaExtensionPathFilterTest(){
		String path ="/foo/test.java";
		String extension = "java";
		boolean expectedValue = PathFilters.checkPathFilterEnding(path, extension);
		assertTrue(expectedValue);
	}
	
	@Test
	public void filterEndingOnlyNotJavaExtensionPathFilterTest(){
		String path ="/foo/test.txt";
		String extension = "java";
		boolean expectedValue = PathFilters.checkPathFilterEnding(path, extension);
		assertFalse(expectedValue);
	}
	
	/**
	 * Reads the git information of this project to test log information
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void readGitPathsTest() throws IOException, InterruptedException{
		List<String> listOfPathFiles = GitReader.readGitPaths("E:\\MiningRepositories\\workspace");
		assertTrue("File Size is Zero",listOfPathFiles.size()>0);
		for(String file : listOfPathFiles){
			boolean expectedValue = PathFilters.checkPathFilterEnding(file, "java");
			assertTrue(expectedValue);
		}
	}
	
	/**
	 * Reads commits from a fake git repository
	 * @throws IOException 
	 */
	@Test
	public void readFileCommitsTest() throws IOException {
		String since = "01-01-2001";
		String until = "09-15-2016";
		String path = "E:\\MiningRepositories\\workspace";
		Map<String, String> map = GitReader.readFileCommitsFromDevelopers(path, since, until);
		assertTrue("File Size is Zero",map.size()>0);
		
	}
}