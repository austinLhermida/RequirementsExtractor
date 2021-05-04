import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;

public class Requirements {
	// private class members
	private String fileURL; 
	private ArrayList<String> requirementsList = new ArrayList<>();
	
	// constructor
	public Requirements(String aTxtFilePath) {
		this.fileURL = aTxtFilePath; 
	}
	
	// public class methods 
	public void printRequirements() {
	    for (String element : requirementsList)
	        System.out.println(element + "\n");
	}
	
	public ArrayList<String> getRequirements() {
		return requirementsList;
	}
	
	public void readTxtFile() {
        // reads a sentence and checks if string contains a shall
        // *NOTE: A sentence is defined as a string that is delimited by a period
		try (Scanner reader = new Scanner(Paths.get(fileURL))) {
			while (reader.hasNextLine()) {
		        String docText = reader.nextLine();
		        extractShalls(docText);
		        }
		      }
		    catch (Exception e) {
		      System.out.println("Error: " + e.getMessage());
		    }
		    
	}
	
	public void extractShalls(String aText) {
		// checks for shalls within document text 
		 String[] splitSentences = aText.split("\\. ");
	        for (int i = 0; i < splitSentences.length; i++) {
	          if (splitSentences[i].contains("shall")) {
	        	// switch out commas for dashes, since excel file is delimited by commas
	        	  requirementsList.add(splitSentences[i].replace(",", " -"));
	          }
	       }
	}
	
}
