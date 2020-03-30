import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



public class DuplicateRemover {
	public String[] uniqueWords= null;
	
	
	public void remove(String dataFile){
		
		File myWork = new File(dataFile);
		String myData = null;
		String[] myValues = null;
		String   myValues1 = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myWork));
			StringBuilder  builder = new StringBuilder();
			while(reader.ready()) {
				builder = builder.append(reader.readLine());
			}
			myData = builder.toString();
			myData = myData.replaceAll("[^a-zA-Z ]", " ");
			myValues = myData.split(" ");
		
		for(int i = 0; i < myValues.length; i++) {
			myValues1 = myValues[i];
			i++;
			for(int j = i; j < myValues.length;j++) {
				if(myValues[j].equalsIgnoreCase(myValues1)) {
					myValues[j] = "";
					myValues[i-1] = "";
					}
				else continue;
				}
			i--;
		}
		reader.close();
		}catch (IOException fileNotFoundException) {
			System.out.println("Sorry your File was not found");
			System.exit(0);
		}
		
		
		uniqueWords = myValues;
	}
	public void write(File outputFile){
		
		try {
			File myFile = outputFile;
			if(!myFile.exists()) {
				myFile.createNewFile();
			}
			FileWriter Write = new FileWriter(outputFile);
			BufferedWriter Right = new BufferedWriter(Write);
			for(int i = 0; i < uniqueWords.length; i++) {	
			Right.write(uniqueWords[i]);
			Right.write(" ");
			}
			Right.close();
			Write.close();
		} catch (IOException e) {}
		
	
	}
}
