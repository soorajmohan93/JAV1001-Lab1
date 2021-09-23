/*
***************************************************************
      JAV-1001 App Development for Android
      JAV1001-Lab1 - Variables and Logic
      Submitted by Sooraj Mohan (Student ID: A00247480)
***************************************************************
*/

import java.util.Scanner;

public class Lab1
{
  public static void main(String[] args)
  {
    // Declarations
    float valIn;                                   //variable to hold the input values
    float valOut;                                  //variable to hold result
    String uoMs;                                   //variable to hold the Unit of Measure (Hereafter mentioned as UoM)
    char optRerun;                                 //variable for the option for user to rerun the application
    Scanner entry = new Scanner(System.in);

    // App welcome message
    System.out.println("-----------------------------------------------------------------------------");
    System.out.println("                             UNIT CONVERSION APP                             ");
    System.out.println("Possible conversions: KM<->mi, cm<->IN, KG<->lb, G<->oz, C<->F<->K, L<->cups");
    System.out.println("-----------------------------------------------------------------------------");

    // Fetching User I/P for value and UoM

    do {
      System.out.print("Enter a value to convert: ");
      valIn = entry.nextFloat();                  //User input for value
      uoMs = entry.nextLine();                    //User input for UoM
      uoMs = uoMs.trim();                         //Removing trailing spaces in UoM

      if (uoMs.isEmpty())                         //If UoM missed by user - prompting user to provide the UoM
      {
        System.out.print("Enter the current Unit of Measure: ");
        uoMs = entry.nextLine();
      };
      uoMs = uoMs.toLowerCase();                //Adjusting UoM to Lower case characters

      // Conversions based on UoMs provided by user
      switch(uoMs)
      {
        case "km":                              //Convert from KM to mi
          valOut = 0.62f * valIn;
          System.out.println(valIn + " KM is equal to " + valOut + " mi");
          break;
        case "mi":                              //Convert from mi to KM
          valOut = 1.61f * valIn;
          System.out.println(valIn + " mi is equal to " + valOut + " KM");
          break;

        case "cm":                              //Convert from cm to IN
          valOut = 0.39f * valIn;
          System.out.println(valIn + " cm is equal to " + valOut + " IN");
          break;
        case "in":                               //Convert from IN to cm
          valOut = 2.54f * valIn;
          System.out.println(valIn + " IN is equal to " + valOut + " cm");
          break;

        case "kg":                               //Convert from KG to lb
          valOut = 2.2f * valIn;
          System.out.println(valIn + " KG is equal to " + valOut + " lb");
          break;
        case "lb":                               //Convert from lb to KG
          valOut = 0.45f * valIn;
          System.out.println(valIn + " lb is equal to " + valOut + " KG");
          break;

        case "g":                                //Convert from G to oz
          valOut = 0.04f * valIn;
          System.out.println(valIn + " G is equal to " + valOut + " oz");
          break;
        case "oz":                              //Convert from oz to G
          valOut = 28.35f * valIn;
          System.out.println(valIn + " oz is equal to " + valOut + " G");
          break;

        case "l":                               //Convert from L to cups
          valOut = 4.17f * valIn;
          System.out.println(valIn + " L is equal to " + valOut + " cup(s)");
          break;
        case "cups":                            //Convert from cups to L
          valOut = 0.24f * valIn;
          System.out.println(valIn + " cup(s) is equal to " + valOut + " L");
          break;

        case "c":                               //Convert from C to F and K
          valOut = (valIn * 9 / 5) + 32;
          System.out.println(valIn + " °C is equal to " + valOut + " °F");
          valOut = valIn + 273.15f;
          System.out.println(valIn + " °C is equal to " + valOut + " K");
          break;
        case "f":                               //Convert from F to C and K
          valOut = (valIn - 32) * 5 / 9;
          System.out.println(valIn + " °F is equal to " + valOut + " °C");
          valOut = (valIn - 32) * 5 / 9 + 273.15f;
          System.out.println(valIn + " °F is equal to " + valOut + " K");
          break;
        case "k":                               //Convert from K to C and F
          valOut = valIn - 273.15f;
          System.out.println(valIn + " K is equal to " + valOut + " °C");
          valOut = (valIn - 273.15f) * 9 / 5 + 32;
          System.out.println(valIn + " K is equal to " + valOut + " °F");
          break;
        default:                                //Fallback for invalid conversions
          System.out.println("Invalid Unit of Measure, Possible conversions are: KM<->mi, cm<->IN, KG<->lb, G<->oz, C<->F<->K, L<->cups");
      };

      // App Rerun Logic
      System.out.print("Do you want to convert more values? (Y/N): ");    //This is to take user's input if they want to rerun the application
      String userOpt = entry.next();
      userOpt = userOpt.toUpperCase();                                    //input from user is captured into String variable userOpt and set to upper case which helps in the if statements
      optRerun = userOpt.charAt(0);                                       //First character of the String is passed into char variable optRerun
      entry.nextLine();
      if (optRerun != 'Y' && optRerun != 'N')                             //Fallback for invalid entry
      {
        System.out.print("Invalid Input - Kindly enter Y/N to proceed or application will close: ");    // code can handle first instance of invalid entry, if invalid entry entered again the application terminates
        userOpt = entry.next();
        optRerun = userOpt.charAt(0);
        entry.nextLine();
      }
    } while (optRerun == 'Y');                       //Loop back
    System.out.println("********Thank you. Application will close now.*********");        //Application closing message
  }
}
