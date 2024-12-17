


/**
This is a template for a Java file.
@author Gregory Miguell A. De Mesa (222017)
@version December 2, 2022
**/

/**
 In this Java File is where it gives the user a graphical user interface and invokes operations on a related 
lifestyle tracking element. In order to facilitate the creation of the GUI components and 
event management
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

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class TrackerGUI{
    LifestyleTracker tracker = new LifestyleTracker();
    private JFrame logIn, lifeStyle;
    private JTextField foodInput, actInput, caloriesIn, hourIn, index, create;
    private JLabel foodlabel, actLabel, calsLabel, hrLabel;
    private JPanel actPanel, foodPanel, addEat, addPerform, viewPanel, recordPanel, indexPanel, report; 
    private JButton eatFood, addFood, performAct, addAct, display, edit, remove, button, reportButton;
    private Container food, activity, eat, perform, viewRec, viewAll, indexCont, reportCont;
    private FlowLayout foodPane, actPane, eatPane, performPane, viewPane, layoutView,indexFlow, repflow;
    private int width;
    private int height;
    private Font font;
    private JTextArea viewArea;
    JScrollPane recordPane;
    private JPanel panel;
    private JLabel label, success;
    private JTextField userText, change;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private String userName;
    private JLabel helloTracker;
    
        
    public TrackerGUI(int w, int h){
        font = new Font("Times New Roman", Font.PLAIN, 11); // https://www.c-sharpcorner.com/code/3672/to-change-the-font-style-using-font-class-in-applet-using-java-program.aspx
        lifeStyle = new JFrame();
        foodlabel = new JLabel("Food");
        calsLabel = new JLabel("Calories per serving/ serving of food eaten");
        hrLabel = new JLabel("Calories burn per hour/ hours of activity performed");
        foodInput = new JTextField("Food Name",10);
        actInput = new JTextField("Activity Name",10);
        
        caloriesIn = new JTextField("calories or servings",10);
        index = new JTextField("Index",10);
        create = new JTextField("Type of Item", 10);
        hourIn = new JTextField("calories or hours",10);
        change = new JTextField("Servings or hours to change",20);
        caloriesIn.setSelectedTextColor(Color.GRAY);
        caloriesIn.setFont(font);
        index.setFont(font);
        create.setFont(font);
        foodInput.setFont(font);
        actInput.setFont(font);
        change.setFont(font);
        hourIn.setFont(font);
        actLabel = new JLabel("Activity");
        addFood = new JButton("Add Food");
        eatFood = new JButton("Eat Food");
        addAct = new JButton("Add Activity");
        performAct = new JButton("Perform Activity");
        display = new JButton("Display Record");
        edit = new JButton("Edit Item");
        remove = new JButton("Delete Item");
        foodPanel = new JPanel();
        actPanel = new JPanel();
        addEat = new JPanel();
        addPerform = new JPanel();
        viewPanel = new JPanel();
        recordPanel = new JPanel();
        indexPanel = new JPanel();
        recordPane = new JScrollPane(recordPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        label = new JLabel();
        viewArea = new JTextArea();
        userText = new JTextField(40);
        report = new JPanel();
        reportButton = new JButton("Report");
        
        width = w;
        height = h;
        helloTracker = new JLabel();
    }
    public void logIn(){
         // log In set up
        panel = new JPanel();
        logIn = new JFrame();
        logIn.setSize(width, height);
        logIn.setTitle("LifeStyle Tracker");
        JLabel note = new JLabel("** Note: Your username is also your password **" );
        note.setBounds(10,110,400,25);
        panel.add(note);
        
        
        logIn.add(panel);
        panel.setLayout(null);
         label = new JLabel("User");
        label.setBounds(10,20,80,25);
        panel.add(label);
        userText.setBounds(100,20,165,25); // https://stackoverflow.com/questions/19415170/what-is-setbounds-and-how-do-i-use-it If you set the layout to null, you may use setBounds(x, y, width, height) to define the location and size of a GUI component. The upper-left corner of that component's coordinates are (x, y).
        panel.add(userText);
         passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        
        panel.add(passwordLabel);

        passwordText = new JPasswordField(); //  https://docs.oracle.com/javase/tutorial/uiswing/components/passwordfield.html
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);
         button = new JButton("Login");
        button.setBounds(10,80,80,25);
        
        panel.add(button);

         success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);


        logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logIn.setVisible(true);


    } 
    public void setUpGUI(){


        JPanel welcome = new JPanel();
        lifeStyle.setSize(width, height);
        lifeStyle.setTitle("LifeStyle Tracker");
        lifeStyle.add(foodPanel);
        lifeStyle.add(addPerform);
        lifeStyle.add(addEat);
        lifeStyle.add(viewPanel);
        lifeStyle.add(welcome);
        lifeStyle.add(indexPanel);
        lifeStyle.add(report);
        welcome.add(helloTracker);

        food = lifeStyle.getContentPane();
        food.add(foodPanel);
        foodPane = new FlowLayout(FlowLayout.CENTER);
        
        food.setLayout(foodPane); foodPanel.add(foodlabel); foodPanel.add(foodInput); foodPanel.add(calsLabel); foodPanel.add(caloriesIn); // add food and eat food textfield panel
         
        eatPane = new FlowLayout(FlowLayout.CENTER); eat = lifeStyle.getContentPane();  eat.add(addEat); eat.setLayout(eatPane); addEat.add(addFood); addEat.add(eatFood); // add food and eat food button panle

        actPane = new FlowLayout(FlowLayout.CENTER); // add act and perform act textfield panel
        activity = lifeStyle.getContentPane(); 
        activity.add(actPanel); 
        activity.setLayout(actPane); 
        actPanel.add(actLabel); 
        actPanel.add(actInput); 
        actPanel.add(hrLabel); 
        actPanel.add(hourIn);
        

        performPane = new FlowLayout(); // add act button and perform act button panel
        perform = lifeStyle.getContentPane();
        perform.add(addPerform);
        perform.setLayout(performPane);
        addPerform.add(addAct);
        addPerform.add(performAct);


        viewPane = new FlowLayout(); //display panel
        viewAll = lifeStyle.getContentPane();
        viewAll.add(viewPanel);
        viewAll.setLayout(viewPane);
        viewPanel.add(display);
        

       //= new JScrollPane(viewArea);
        layoutView = new FlowLayout();
        viewRec = lifeStyle.getContentPane();
        viewPanel.setBounds(100,50,165,250);
        viewRec.add(recordPanel);
        viewRec.setLayout(layoutView);
        // recordPanel.add(recordPane);
        recordPanel.add(viewArea);
        recordPane = new JScrollPane(recordPanel);

        recordPane.setPreferredSize(new Dimension(300, 250));
        lifeStyle.getContentPane().add(recordPane);
        
        viewArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 11)); // https://www.c-sharpcorner.com/code/3672/to-change-the-font-style-using-font-class-in-applet-using-java-program.aspx
        viewArea.setEditable(false);
        

        

        indexFlow = new FlowLayout(); // index, remove, edit panel
        indexCont = lifeStyle.getContentPane();
        indexCont.add(indexPanel);
        indexCont.setLayout(indexFlow);
        indexPanel.add(index);
        indexPanel.add(create);
        indexPanel.add(change);
        indexPanel.add(remove);
        indexPanel.add(edit);


        repflow = new FlowLayout();
        reportCont = lifeStyle.getContentPane();
        reportCont.add(report);
        reportCont.setLayout(repflow);
        report.add(reportButton);



        
        lifeStyle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        lifeStyle.setVisible(false);

        index.addFocusListener(new FocusListener(){ // https://stackoverflow.com/questions/16213836/java-swing-jtextfield-set-placeholder
            @Override
            public void focusGained(FocusEvent e){
                if(index.getText().equals("Index")){
                index.setText("");}

            }
            public void focusLost(FocusEvent e){
                if (index.getText().isEmpty()){
                index.setText("Index");}
                
            }    
        });

        caloriesIn.addFocusListener(new FocusListener(){ 
            @Override
            public void focusGained(FocusEvent e){
                if(caloriesIn.getText().equals("calories or servings")){
                caloriesIn.setText("");}

            }
            public void focusLost(FocusEvent e){
                if (caloriesIn.getText().isEmpty()){
                caloriesIn.setText("calories or servings");}
                
            }    
        });

        hourIn.addFocusListener(new FocusListener(){ 
            @Override
            public void focusGained(FocusEvent e){
                if(hourIn.getText().equals("calories or hours")){
                hourIn.setText("");}

            }
            public void focusLost(FocusEvent e){
                if (hourIn.getText().isEmpty()){
                hourIn.setText("calories or hours");}
                
            }    
        });

        foodInput.addFocusListener(new FocusListener(){ 
            @Override
            public void focusGained(FocusEvent e){
                if(foodInput.getText().equals("Food Name")){
                foodInput.setText("");}

            }
            public void focusLost(FocusEvent e){
                if (foodInput.getText().isEmpty()){
                foodInput.setText("Food Name");}
                
            }    
        });

        actInput.addFocusListener(new FocusListener(){ 
            @Override
            public void focusGained(FocusEvent e){
                if(actInput.getText().equals("Activity Name")){
                actInput.setText("");}

            }
            public void focusLost(FocusEvent e){
                if (actInput.getText().isEmpty()){
                actInput.setText("Activity Name");}
                
            }    
        });
        create.addFocusListener(new FocusListener(){ 
            @Override
            public void focusGained(FocusEvent e){
                if(create.getText().equals("Type of Item")){
                create.setText("");}

            }
            public void focusLost(FocusEvent e){
                if (create.getText().isEmpty()){
                create.setText("Type of Item");}
                
            }    
        });

        change.addFocusListener(new FocusListener(){ 
            @Override
            public void focusGained(FocusEvent e){
                if(change.getText().equals("Servings or hours to change")){
                change.setText("");}

            }
            public void focusLost(FocusEvent e){
                if (change.getText().isEmpty()){
                change.setText("Servings or hours to change");}
                
            }    
        });
    }


    public void logInButton(){
    ActionListener logIN = new ActionListener(){
        
        @Override   

        public void actionPerformed(ActionEvent e){
                Object a = e.getSource();
                userName = userText.getText();
                String text = String.valueOf(passwordText.getPassword()); // https://stackoverflow.com/questions/10443308/why-gettext-in-jpasswordfield-was-deprecated

                if (a== button){
                    if (userName.equals(text)){
                    success.setText("Login successful");
                    String welcometracker = "Welcome to " + userName + "'s LifeStyle Tracker";
                    helloTracker.setText(welcometracker);
                    logIn.setVisible(false);
                    lifeStyle.setVisible(true);
                }
            }
    }
};

    button.addActionListener(logIN);


} 

    public void setUpButtonListeners(){ // add food 
        ActionListener buttonlistener = new ActionListener(){
            @Override

            
            public void actionPerformed(ActionEvent ae){
                Object o = ae.getSource();
                
                if (o == addFood){
                    String foodIn = foodInput.getText();
                double calsIn = Double.parseDouble(caloriesIn.getText());
                viewArea.setText(tracker.addFood(foodIn, calsIn));
            } else if (o == eatFood){
                String foodIn = foodInput.getText();
                double calsIn = Double.parseDouble(caloriesIn.getText());
                viewArea.setText(tracker.eat(foodIn, calsIn));
            } else if (o == display){
                viewArea.setText(tracker.display());
            
            } else if ( o == addAct){
                String actIn = actInput.getText();
                double burn = Double.parseDouble(hourIn.getText());
                viewArea.setText(tracker.addActivity(actIn, burn));
            } else if ( o == performAct){
                String actIn = actInput.getText();
                double burn = Double.parseDouble(hourIn.getText());
                viewArea.setText(tracker.perform(actIn, burn));
            } else if (o == remove){
                int number = Integer.parseInt(index.getText());
                String type = create.getText();
                tracker.deleteRecord(type, number);
            } else if (o == edit){
                int number = Integer.parseInt(index.getText());
                String type = create.getText();
                double edit = Double.parseDouble(change.getText());

                tracker.edit(type, number,edit) ;
            } else if (o == reportButton){
                viewArea.setText(tracker.report());
            }
        

            

        }
            

        };
        addFood.addActionListener(buttonlistener);
        eatFood.addActionListener(buttonlistener);
        display.addActionListener(buttonlistener);
        addAct.addActionListener(buttonlistener);
        performAct.addActionListener(buttonlistener);
        remove.addActionListener(buttonlistener);
        edit.addActionListener(buttonlistener);
        reportButton.addActionListener(buttonlistener);
        

    
    }
    
    }

