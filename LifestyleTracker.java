





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






import java.util.ArrayList;

public class LifestyleTracker
{

        ArrayList<Food> myfood;
        ArrayList<Activity> myActivity;
        ArrayList<String> foodEaten;
        ArrayList<String> activityDone;
        private double caloriesIntake;
        private double caloriesBurned;

    public LifestyleTracker()
    {
        myfood = new ArrayList<Food>();
        myActivity = new ArrayList<Activity>();
        caloriesIntake = 0;
        caloriesBurned = 0;
        foodEaten = new ArrayList<String>();
        activityDone = new ArrayList<String>();

    }
    public String addFood(String n, double c)
    {

        int i;
        String x = "Number of calories cannot be negative. \n";
        boolean found = false;
        if (c >= 0 ){
            for (i = 0; i < myfood.size(); i++){
                if (myfood.get(i).getFoodName().equals(n)){
                myfood.get(i).updateCalories(c);
                found = true;
                x = "Updated Food " + n + " with " + c + " kcal" + "\n";
                break;
            }
        }
        
        if (!found ){
            myfood.add( new Food(n, c));
            x = "Added Food " + n + " with " + c + " kcal" + "\n";
        }
    }
    return x;
    
    }



    public String addActivity(String n, double c){
        int i;
        String x = "Number of hours cannot be negative";
        boolean found = false;
        if (c>=0){
        for (i = 0; i < myActivity.size(); i ++){
            if (myActivity.get(i).getActivityName().equals(n)){
                myActivity.get(i).updateCalories(c);
                found = true;
                x = "Updated Activity " + n + " with " + c + " kcal" + "\n";
                break;
            }
        }

        if (!found ) {
        myActivity.add( new Activity(n, c));
            x = "Added Activity " + n + " with " + c + " kcal" + "\n";
        
        }
    }
    
    return x;
        
    
    }
    public String eat(String foodName, double servings){
        int i;
        double cal;
        String x = "Number of servings cannot be negative. \n";
        String eaten = "";
        boolean found = false;
        if (servings >= 0){
            for (i = 0; i < myfood.size(); i ++){
                 if (myfood.get(i).getFoodName().equalsIgnoreCase(foodName)){
                    found = true;
                    cal = servings * myfood.get(i).getFoodCalories();
                    caloriesIntake += cal;
                    eaten = servings + " servings(s) of " + foodName + ", " + cal + " kcal." ;
                    x = "Ate " + eaten + "\n";
                    foodEaten.add(eaten);
                }
            }
            if (!found) {
                x = "The specified food does not exist. \n" ;
                x +="Do you want to add the specified food? \n";
                
            }
        }                
             return x;
    }

    public String perform(String actName, double hours)
    {
        int i;
        double cal;
        String exercise = "";
        String x = "Number of hours cannot be negative \n";
        boolean found = false;
        if (hours >= 0 ){
            for (i = 0; i < myActivity.size(); i++){
                if(myActivity.get(i).getActivityName().equalsIgnoreCase(actName)){
                    found = true;
                    cal = hours * myActivity.get(i).getActivityCalories();
                    caloriesBurned += cal;
                    exercise = hours + " hour(s) of " + actName + ", " + cal + " kcal.";
                    x= "Performed " + exercise + "\n";
                    activityDone.add(exercise);
                }   
            }
        if (!found) {
            x = "The specified activity does not exist. \n" ;
            x += "Do you want to add the specified Activity. \n";
            }
        }
   
    return x;
    }
    
   public String display(){ // this method displays the recorded list of food Eaten and activity performed
    String record = "";
     
     record +="RECORD     \n";
     record += "---------------- \n";
     record += "Food Eaten: \n";
        for (int i = 0; i < foodEaten.size(); i++){
        record += String.format("Food Eaten index " + i +  ", " + foodEaten.get(i) + "\n");
        }
    
    record += "---------------- \n";
    record += "Activities Performed: \n";        
        for (int i = 0; i < activityDone.size(); i++){
        
            record += String.format("Activity Number index " + i +  ", " + activityDone.get(i) + "\n");
    }
    record += "---------------- \n";
    record += "Press Delete if you want to Delete an item. \n";
    record += "Press Edit if you want to Edit an item \n";
    record += "---------------- \n";
    return record;
   }

   public String deleteRecord(String type, int code){ // deletes an item in the performed or eaten list
    String output = "";
    if (type.equalsIgnoreCase("Food")){
        if (code > 0 || code <= foodEaten.size()){
            caloriesIntake -= Double.parseDouble(foodEaten.get(code).split(" ")[4]); // convert string to double and deduct the calorie of the food eaten to the total calorie intake
            foodEaten.remove(code); // https://www.geeksforgeeks.org/set-remove-method-in-java-with-examples/ how to remove an element from an array
            output += "Food item index " + code + " removed from the list.\n";
        }
        else {
            output += "Invalid input. Please Enter a Valid Input.\n";

        }
    }
    else if (type.equalsIgnoreCase("Activity")){
        if (code > 0 || code <= foodEaten.size()){
            caloriesBurned -= Double.parseDouble(activityDone.get(code).split(" ")[4]);
            activityDone.remove(code);
            output += "Activity item index " + code + " removed from the list.\n";
        }
        else {
            output += "Invalid input. Please Enter a Valid Input.\n"; // 
        }
    }

        
        return output;
}
    public String edit(String type, int code, double editable){ 
        String output = "";
        String newFood = "";
        String newActivity = "";
        String[] food;
        String[] activity;
        int i;
        double calories;
        double hours;
        if (type.equalsIgnoreCase("Food")){
            if (code > 0 || code <= foodEaten.size()){
                food = foodEaten.get(code).split(" ");
                food[0] = String.format("%.2f",editable); // https://www.javatpoint.com/java-string-format String.format converts the whole line to string. int and double to string
                String foodName = food[3];
                for (i = 0; i < myfood.size(); i ++){ 
                    if (myfood.get(i).getFoodName().equalsIgnoreCase(foodName)){ 
                      calories = editable * myfood.get(i).getFoodCalories();
                      caloriesIntake -= Double.parseDouble(food[4]);
                      food[4] = String.format("%.2f",calories);
                }
                }
                for (i = 0; i < food.length; i++){
                    newFood += food[i] + " ";
                 
                }
                foodEaten.set(code, newFood);
                output += "You have updated the servings of " + food[3].replace(",", ".") + "\n"; // .replace() https://www.w3schools.com/java/ref_string_replace.asp
            }

            
            else {
                output += "Invalid input. Please Enter a Valid Input.";
    
            }
        }
        else if (type.equalsIgnoreCase("Activity")){
            if (code > 0 || code <= activityDone.size()){
                activity = activityDone.get(code).split(" ");
                activity[0] = String.format("%.2f", editable);
                String activityName = activity[3];
                for (i = 0; i < myfood.size(); i ++){
                    if (myfood.get(i).getFoodName().equalsIgnoreCase(activityName)){
                      hours = editable * myActivity.get(i).getActivityCalories();
                      double oldCals = Double.parseDouble(activity[4]);
                      if (editable > oldCals){
                        caloriesBurned += editable;
                        activity[4] = String.format("%.2f",hours);
                      }else{
                      caloriesBurned -= Double.parseDouble(activity[4]); // converts index 4 (calories )from string to double then deduct to calories burned
                      activity[4] = String.format("%.2f",hours);}
                }
                }
                for (i = 0; i < activity.length; i++){
                    newActivity += activity[i] + " ";
                 
                }
                activityDone.set(code, newActivity);
                output += "You have updated the hours performed of " + activity[3].replace(",", ".") + "\n";
                
            }
            else {
                output += "Invalid input. Please Enter a Valid Input."; // 
            }
        }
        return output;
        }
        
    public String report(){
        String x  = "---------------- \n";
        x += "LIFESTYLE REPORT \n";
        x += "----------------\n";
        x += "Food Consumed: \n";
        
        for (int i = 0; i < foodEaten.size(); i ++){
            x += foodEaten.get(i) + "\n";
        }
        x += "---------------- \n";
        x += String.format("Total Calories Consumed: %.2f \n",  caloriesIntake) ; // 
        x += "---------------- \n";
        x += "Activities Performed: \n";

        for (int i = 0; i < activityDone.size(); i ++){
            x += activityDone.get(i) + "\n";}

        x += "---------------- \n";
        x += String.format("Total Calories Burned: %.2f \n", caloriesBurned);
        x += "---------------- \n";

        double netCalories = caloriesIntake - caloriesBurned;
        double calories =  0.00012959782;

        if (netCalories > 0){
            x += String.format("Net Calories for the Day: %.2f \n", netCalories); // site
            x += String.format("In a week, you will gain %.2f kilograms. \n", calories * netCalories * 7);
            x += String.format("In a month, you will gain %.2f kilograms. \n", calories * netCalories * 30);
            x += String.format("In 3 months, you will gain %.2f kilograms.\n", calories * netCalories * 90);
            x += String.format("In 6 months, you will gain %.2f kilograms.\n", calories * netCalories * 180);
            x += String.format("---------------- \n");
            
        }

        else if (netCalories < 0) {
            x += String.format("Net Calories for the Day: %.2f \n", netCalories);
            x += String.format("In a week, you will lose %.2f kilograms.\n", -1 *calories * netCalories * 7);
            x += String.format("In a month, you will lose %.2f kilograms.\n", -1 * calories * netCalories * 30);
            x += String.format("In 3 months, you will lose %.2f kilograms.\n", -1 * calories * netCalories * 90);
            x += String.format("In 6 months, you will lose %.2f kilograms.\n",-1 * calories * netCalories * 180);
            x += String.format("---------------- \n");
        }

        else if (netCalories == 0){
            x += String.format("Net Calories for the Day: %.2f \n", netCalories);
            x += String.format("In a week, you will not gain/lose weight. \n");
            x += String.format("In a week, you will not gain/lose weight. \n");
            x += String.format("In a month, you will not gain/lose weight.\n");
            x += String.format("In 3 months, you will not gain/lose weight.\n");
            x += String.format("In 6 months, you will not gain/lose weight.\n");
            x += String.format("---------------- \n");
        }


        return x;
    
    }


}