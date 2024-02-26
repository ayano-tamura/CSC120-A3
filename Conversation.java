import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Conversation class creates a chatbot that interacts with user input.
 * Users can specify the number of rounds to have the chat, and the chatbot will return pre-planned phrases or convert terms of certain phrases from the user's input and return them to the user as a response.
 */
class Conversation {
/**
 * Method that starts conversation with the chatbot.
 * @param arguments
 */

  public static void main(String[] arguments) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random() ;
    List<String> transcript = new ArrayList<>();
    
    // Intro for chatbot
    System.out.println("Hello! Welcome to the chatbot!");
    transcript.add("Hello! Welcome to the chatbot!");
    System.out.println("How many rounds of conversation would you like to have?");
    transcript.add("How many rounds of conversation would you like to have?");

    // Ask for number of rounds
    int rounds = scanner.nextInt();
    scanner.nextLine();
    transcript.add(Integer.toString(rounds));
    
    // Start conversation
    System.out.println("Hi there! What's on your mind?");
    transcript.add("Hi there! What's on your mind?");

    int interaction = 0;

    // Conversation loop for chatbot to take in and return responses
    while (rounds > 0) {
      String response = scanner.nextLine();
      transcript.add(response);
    
      if (response.toLowerCase().contains("\\bi\\b")||
      response.toLowerCase().contains("me")||
      response.toLowerCase().contains("am")||
      response.toLowerCase().contains("you")||
      response.toLowerCase().contains("my")||
      response.toLowerCase().contains("your")) {
        response = response.replaceFirst ("\\bi\\b", "temp");
        response = response.replaceFirst ("\\bme\\b","temp");
        response = response.replaceFirst ("\\bam\\b","are");
        response = response.replaceFirst ("\\byou\\b","I");
        response = response.replaceFirst ("\\bmy\\b","your");
        response = response.replaceFirst ("\\byour\\b","my");
        response = response.replaceFirst ("\\btemp\\b","you");
        System.out.println(response + "?");
        transcript.add(response + "?");
        interaction ++;
      }
      
      // System.out.println(response + "?");
      //   transcript.add(response + "?");
      else {
        // Return pre-planned responses
        String [] comments = {
          "Mmm-hm.",
          "Tell me more about it!",
          "Interesting!"
        };
        int generator = random.nextInt(comments.length);
        String generated = comments[generator];
        System.out.println(generated); 
        transcript.add(generated);
        interaction ++;
      } 

      // Check if rounds of interactions specified is reached
      if (interaction == rounds) {
        break;
      }
    }
    // Close chatbot
    System.out.println("Great talking to you, see ya!");
    transcript.add("Great talking to you, see ya!");
    System.out.println("");
    System.out.println("TRANSCRIPT");
    System.out.println("----------------------------------------");
    // Display full conversation in a transcript
    for (String printout : transcript) {
      System.out.println(printout);
    }
    System.out.println("---------------------------------------");
    scanner.close();
  
  }
}
