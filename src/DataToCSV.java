import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; 

public class DataToCSV {
	// private class members
	private String csvURL;
	private String[] colHeaders = {"Req #", "," , "Requirement Text", "\n"};
	private ArrayList<String> requirementsList = new ArrayList<>(); 
	private int reqNum; 
	
	// constructor
	public DataToCSV(String aURL, ArrayList<String> aList) {
		this.csvURL = aURL;
		this.reqNum = 1;
		requirementsList.addAll(aList);
		
	}
	
	// public class methods 
	public void writeToCSV() {
		try {
		      FileWriter csvWriter = new FileWriter(csvURL);
		      
		      // populate headers 
		      for (String header : colHeaders) 
		    	  csvWriter.append(header);
		      
		      // populate cells with extracted shalls
		      for (String rowData : requirementsList) {
		    	  csvWriter.append(String.join(",", String.valueOf(reqNum), rowData));
		    	  csvWriter.append("\n");
		    	  reqNum++;
		      }
		      
		      csvWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } 
		 
		 catch (IOException e) {
		      System.out.println("Could not write to file.");
		      e.printStackTrace();
		    }
	
	} 
	
} // end of class 
