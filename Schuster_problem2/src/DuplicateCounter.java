import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;


public class DuplicateCounter {
	String wordCounter;
	
	public void count(String dataFile) {
		File myWork = new File(dataFile);
		String myData=null;
		String[] myValues = null;
		String myValues1 = null;
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myWork));
			StringBuilder builder = new StringBuilder();
			while(reader.ready()) {
				builder = builder.append(reader.readLine());
			}
			myData = builder.toString();
			myData = myData.replaceAll("[^a-zA-Z ]", " ");
			
			myValues = myData.toLowerCase().split(" ");
			
			for(int i = 0; i < myValues.length; i++) {
				myValues1 = myValues[i];
				if(!map.containsKey(myValues1)) {
					map.put(myValues1, 1);
				}
				else {
					int count = map.get(myValues1);
					map.put(myValues1,count + 1);
				}
			}
			map.remove("");
			reader.close();
			
		}catch( IOException fileNotFoundException) {
			System.out.println("Sorry your File was not found");
			System.exit(0);
		}
		wordCounter = map.toString();
	
		
		
	}
	
	public void write(File outputFile) {
		try {
			File myFile = outputFile;
			if(!myFile.exists()) {
				myFile.createNewFile();
			}
			FileWriter Write = new FileWriter(outputFile);
			BufferedWriter Right = new BufferedWriter(Write);
			Right.write(wordCounter);
			Right.close();
			Write.close();
		}catch(IOException e) {
		}
		
	}
	
	

}
