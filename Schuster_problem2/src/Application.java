import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
	public static void main(String[] args) {
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		
		Path myFile =Paths.get("problem2.txt");
		String myFile1 = myFile.toString();
		File myOutput = new File("unique_word_counts.txt");
		
		duplicateCounter.count(myFile1);
		duplicateCounter.write(myOutput);
		
	}
}
