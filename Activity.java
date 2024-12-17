/**
This is a template for a Java file.
@author Gregory Miguell A. De Mesa (222017)
@version December 2, 2022
**/

/**
 In this Java File is where majority of the LifeStyle Tracker works. This is where the addFood, eatFood, add Activity
 perform, edit,display,report, and delete methods are. This file is in charge of keeping track of the meals consumed and the activities carried out using the 
consolidated information on activities and meals. Upon the creation of each record, it sends feedback messages. It 
gives a report based on the foods and activities that were noted. The LifestyleTracker may employ a variety of 
ArrayLists may be used to hold groups of Food, Activity, and String objects as needed. The 
In order to track total calories ingested and expended, LifestyleTracker may make use of a number of factors. The 
In order to aid in looking through the Food and LifestyleTracker collections privately, 
Items having names that match activity objects.
 */
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
  



public class Activity{
    private String exercise;
    private double calories;

    public Activity( String n, double c)
    {
        exercise = n;
        calories = c;
    }

    public String getActivityName()
    {
        return exercise;
    }

    public double getActivityCalories()
    {
        return calories;
    }

    public void updateCalories( double c)
    {
        calories = c;
    }
}