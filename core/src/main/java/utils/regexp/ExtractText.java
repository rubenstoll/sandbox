/**
 * 
 */
package utils.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rustoll
 * 
 */
public class ExtractText {

	private static final String REGEX = "[a-zA-Z]+ *[a-zA-Z]+ *[a-zA-Z]+ *[0-9]+ *[a-zA-Z]+";
	private static final String INPUT = "employe moulliard          Male 43 BE";

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		patternMatcherIndexes();
		
		randomExample();

	}



	/**
	 * 
	 */
	private static void patternMatcherIndexes() {
		Pattern p = Pattern.compile(REGEX);
		// get a matcher object
		Matcher m = p.matcher(INPUT);
		int count = 0;
		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			System.out.println("start(): " + m.start());
			System.out.println("end(): " + m.end());
		}
	}

	private static void randomExample() {
		
		Double number = Math.random() * 5;
		
		System.out.println("number is: " + number);
		
	}


    private static void randomExample2() {

        Double number = Math.random() * 5;

        System.out.println("number is: " + number);

    }
	
	
}
