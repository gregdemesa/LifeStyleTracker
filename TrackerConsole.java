/**
This is a template for a Java file.
@author Gregory Miguell A. De Mesa (222017)
@version December 2, 2022
**/

/**
 In this Java File is where the input scanner object is use.  provides the user with a console (terminal) 
 interface via a main function that takes input from the user via a Scanner object and runs procedures on a related 
Object for LifestyleTracker. consists of the main() function, which creates an instance of LifestyleTracker. 

/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.
I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.

*/

import java.util.Scanner;

public class TrackerConsole{
    public static void main(String[] args)
    {
        System.out.println("Welcome to " + args[0] + "'s Lifestyle Tracker");
        System.out.println("Input HELP to check the commands of the program.");
        Scanner in = new Scanner(System.in);
        LifestyleTracker tracker = new LifestyleTracker();
        

        String command = in.next();
        
        while (!command.equalsIgnoreCase("Report")){

            if (command.equalsIgnoreCase("Food"))
            {
                String name = in.next();
                double calories = in.nextDouble();
                System.out.print(tracker.addFood(name, calories));
            
            }
            else if (command.equalsIgnoreCase("Activity"))
            {
                String name = in.next();
                double calories = in.nextDouble();
                System.out.print(tracker.addActivity(name, calories));
            }
            else if (command.equalsIgnoreCase("Eat"))
            {
                String name = in.next();
                double servings =  in.nextDouble();
                String x = tracker.eat(name,servings);

                System.out.print(x);
                

                if (x.contains("The specified food does not exist.")){
                    String answer = in.next();
                    if (answer.equalsIgnoreCase("Yes")){
                        System.out.println("How much calories does 1 serving of " + name + " has.");
                        double calories = in.nextDouble();
                        System.out.print(tracker.addFood(name, calories));
                        System.out.print(tracker.eat(name, servings));
                    }
                    else {
                        
                    }
                }
                


            }
            else if(command.equalsIgnoreCase("Perform")){
                String name = in.next();
                double hours = in.nextDouble();
                String x = tracker.perform(name,hours);
                System.out.print(x);

                if (x.contains("The specified activity does not exist.")){
                    String answer = in.next();
                    if (answer.equalsIgnoreCase("Yes")){
                        System.out.println("How much calories does 1 hour of " + name + " burns.");
                        double calories = in.nextDouble();
                        System.out.print(tracker.addActivity(name, calories));
                        System.out.print(tracker.perform(name, hours));

                    }
                }
                else {

                }
            }


            else if (command.equalsIgnoreCase("Display")){
                System.out.print(tracker.display());        
            }

            else if (command.equalsIgnoreCase("Delete")){
                System.out.println("What item do you want to delete? [food or activity]");
                String name = in.next();
                System.out.println("What is the index of the item you want to delete? ");
                int code = in.nextInt();
                System.out.print(tracker.deleteRecord(name, code));
            }

            else if(command.equalsIgnoreCase("Edit")){
                System.out.println("What item do you want to edit? [food or activity]");
                String type = in.next();
                System.out.println("What is the index of the item you want to edit?");
                int code = in.nextInt();
                System.out.println( "New amount of servings/hours: ");
                double servings = in.nextDouble();
                System.out.print(tracker.edit(type, code, servings));
            }

            else if (command.equalsIgnoreCase("Help")){
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|---------------------------------------COMMANDS--------------------------------------|");
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|Food <name of Food> <calories per servings of food>| To record name of Food          |");
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|Activity <name of Activity><calories per serving of food>|To record name of  Activity|");
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|Eat <name of Food> <number of servings >| To record food eaten                       |");
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|Perform <name of Activity><hours of doing the activity>| To record activity performed|");
                System.out.println("|-------------------------------------------------------------------------------------|");
                
                System.out.println("|Display| To the display the record of food eaten and activity done                   |");
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|Delete| To remove an item in the recorded list                                       |");
                System.out.println("|-------------------------------------------------------------------------------------|");
                System.out.println("|Edit| To edit the serving of food eaten or hours of activity performed               |");
                System.out.println("|-------------------------------------------------------------------------------------|");


            }
        command = in.next();
       
        
        }
        System.out.print(tracker.report());
       //    tracker.report()
    }
}