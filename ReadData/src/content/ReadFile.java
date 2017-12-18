package content;
import java.io.BufferedReader;
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Hero> heroes = readHeroesFromCSV("Superhero.csv"); // let's print all the person read from CSV file 
		for (Hero h : heroes)
		{ 
			System.out.println(h.toString()); 
		}

	}
	private static List<Hero> readHeroesFromCSV(String fileName) 
	{ 
		List<Hero> heroes = new ArrayList<Hero>();
	Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader 
	// using try with resource, Java 7 feature to close resources 
	try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
	{ 
		// read the first line from the text file 
		String line = br.readLine();
		// loop until all lines are read 
		while (line != null) 
		{ 
			// use string.split to load a string array with the values from 
			// each line of 
			// the file, using a comma as the delimiter
			String[] attributes = line.split(",");
			Hero hero = createHero(attributes); 
			// adding book into ArrayList 
			heroes.add(hero); 
			// read next line before looping 
			// if end of file reached, line would be null 
			line = br.readLine();
			System.out.print(line);
		}
	} 
		catch (IOException ioe)
		{ 
			ioe.printStackTrace(); 
		} 
	return heroes; 
	}
	private static Hero createHero(String[] metadata) 
	{ 
		String name = metadata[0]; 
	String secretID = metadata[1]; 
	// create and return book of this metadata 
	return new Hero(name, secretID);
	}

}


