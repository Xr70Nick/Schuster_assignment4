import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

	public static void main(String[] args) {
DuplicateRemover duplicateRemover = new DuplicateRemover();
		
		Path myFile =Paths.get("problem1.txt");
		String myFile1 = myFile.toString();
		File myOutput =new File("unique_words.txt");
		//String myOutput1 = myOutput.toString();
		
		duplicateRemover.remove(myFile1);
		duplicateRemover.write(myOutput);
	}

}
