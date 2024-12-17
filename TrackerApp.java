
/**
This is a template for a Java file.
@author Gregory Miguell A. De Mesa (222017)
@version December 2, 2022
**/

/**
This Java file generates a TrackerGUI instance in the main function.
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

public class TrackerApp {
    public static void main(String[] args){
        TrackerGUI tracker = new TrackerGUI(660, 600);
        tracker.logIn();
        tracker.logInButton();
        tracker.setUpGUI();
        tracker.setUpButtonListeners();
    }
}