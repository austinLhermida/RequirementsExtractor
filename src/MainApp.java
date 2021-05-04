public class MainApp {

	public static void main(String[] args) {
		/* Before reading in text file, make sure file is properly formatted without unnecessary 
		   new lines between incomplete sentences. This will not work if sentences are separated
		   by new lines in the text file.
		*/
		String txtFilePath = "sample.txt";
		String csvFilePath = "data.csv";
		
		Requirements reqList = new Requirements(txtFilePath);
		reqList.readTxtFile();
	    
		DataToCSV exportedRqmts = new DataToCSV(csvFilePath, reqList.getRequirements());
		exportedRqmts.writeToCSV();
	}
	
}