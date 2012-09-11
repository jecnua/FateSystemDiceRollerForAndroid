package com.jecnua.fatesystemdiceroller;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiceRoller extends Activity {

	TextView resultTextView;
	ArrayList<Button> allButtons = new ArrayList<Button>();
	TextView firstDice;
	TextView secondDice;
	TextView thirdDice;
	TextView fourthDice;
	TextView totalOfTheDice;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        
        resultTextView = (TextView)findViewById(R.id.displayResult);
//        resultTextView.setText((CharSequence)"Result");
        
        /* Find Tablelayout defined in main.xml */
//        TableLayout tl = (TableLayout)findViewById(R.id.skillMatrix);
        
        
        
        /*
        Integer maxSkillAvaible = 9;
        TableRow temporaryTableRow = null;
        
        
        //Text Area for each dice in a single row
        
		temporaryTableRow = new TableRow(this);
        temporaryTableRow.setLayoutParams(new LayoutParams(
        		LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        
        tl.addView(temporaryTableRow,new TableLayout.LayoutParams(
                  LayoutParams.FILL_PARENT,
                  LayoutParams.WRAP_CONTENT));
        
    	 firstDice = new TextView(this);
    	 secondDice = new TextView(this);
    	 thirdDice = new TextView(this);
    	 fourthDice = new TextView(this);
        
        temporaryTableRow.addView(firstDice);
        temporaryTableRow.addView(secondDice);
        temporaryTableRow.addView(thirdDice);
        temporaryTableRow.addView(fourthDice);
        
        
        //Text area for the result of the dice on a row
        
		temporaryTableRow = new TableRow(this);
        temporaryTableRow.setLayoutParams(new LayoutParams(
        		LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        
        tl.addView(temporaryTableRow,new TableLayout.LayoutParams(
                  LayoutParams.FILL_PARENT,
                  LayoutParams.WRAP_CONTENT));
        
        totalOfTheDice = new TextView(this);
        temporaryTableRow.addView(totalOfTheDice);
        
        //Creating rows and buttons for the skills
        
        for (Integer counter=0; counter < maxSkillAvaible; counter++){
        	
        	Integer value = counter+1;
        	
        	if ((counter%3) == 0){
        		// Create a new row to be added.
		        temporaryTableRow = new TableRow(this);
		        temporaryTableRow.setLayoutParams(new LayoutParams(
		        		LayoutParams.FILL_PARENT,
		        		LayoutParams.WRAP_CONTENT));
		        
		        // Add row to TableLayout.
		        tl.addView(temporaryTableRow,new TableLayout.LayoutParams(
		                  LayoutParams.FILL_PARENT,
		                  LayoutParams.WRAP_CONTENT));
        	}
	        
        	// Create a Button to be the row-content.
	        Button temporaryButton = new Button(this);
	        temporaryButton.setText(value.toString());
	        temporaryButton.setTag(Integer.valueOf(value));
	        temporaryButton.setWidth(80);
	        temporaryButton.setHeight(80);
	        
	        //OnClick event manager
	        temporaryButton.setOnClickListener(new View.OnClickListener(){
	            public void onClick(View v) {
	            	Button n = (Button)v;
	            	Integer g = (Integer)n.getTag();
	            	
	            	FateSystemUtilities FSU = new FateSystemUtilities();
	            	FSU.throwDices();
	            	int value = g+FSU.resultTotalDices;
	            	
	            	resultTextView.setText((CharSequence)"");
	                resultTextView.setText(""+value);
	                
	                for(Button aButton: allButtons){
	                	aButton.setText(""+aButton.getTag());
	                }
	                
	                //Set new background color
	                //n.setBackgroundColor(Color.BLUE);
	                n.setText("["+n.getText()+"]");
	                
	                firstDice.setText(""+FSU.resultForSingleDice[0]);
	                secondDice.setText(""+FSU.resultForSingleDice[1]);
	                thirdDice.setText(""+FSU.resultForSingleDice[2]);
	                fourthDice.setText(""+FSU.resultForSingleDice[3]);
	                
	                
	                totalOfTheDice.setText(""+FSU.resultTotalDices);
	                
	            }
	        });
	        */
	        
	        
	        /*
	        temporaryButton.setLayoutParams(new LayoutParams(
	        		LayoutParams.FILL_PARENT,
	        		LayoutParams.WRAP_CONTENT)
	        );
	        */
	        
        /*
	        // Add Button to row.
	        temporaryTableRow.addView(temporaryButton);
	        
	        allButtons.add(temporaryButton);
        }
        */
    }
    
    
    public void skillClickHandler(View v) {
    	
    	Button n = (Button)v;
    	Integer g = Integer.parseInt((String)n.getText());
    	
    	FateSystemUtilities FSU = new FateSystemUtilities();
    	FSU.throwDices();
    	int value = g+FSU.resultTotalDices;
    	
    	resultTextView.setText((CharSequence)"");
        resultTextView.setText(""+value);
        
//        for(Button aButton: allButtons){
//        	aButton.setText(""+aButton.getTag());
//        }
        
        //Set new background color
        //n.setBackgroundColor(Color.BLUE);
//        n.setText("["+n.getText()+"]");
        
        Button tempB = (Button)findViewById(R.id.firstDice);
        tempB.setText(""+FSU.resultForSingleDice[0]);
        tempB = (Button)findViewById(R.id.secondDice);
        tempB.setText(""+FSU.resultForSingleDice[1]);
        tempB = (Button)findViewById(R.id.thirdDice);
        tempB.setText(""+FSU.resultForSingleDice[2]);
        tempB = (Button)findViewById(R.id.fourthDice);
        tempB.setText(""+FSU.resultForSingleDice[3]);
        
        
//        totalOfTheDice.setText(""+FSU.resultTotalDices);
    }

    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_dice_roller, menu);
        return true;
    }

}
