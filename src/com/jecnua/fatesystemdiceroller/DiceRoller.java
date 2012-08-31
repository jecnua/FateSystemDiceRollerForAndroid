package com.jecnua.fatesystemdiceroller;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class DiceRoller extends Activity {

TextView resultTextView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        
        resultTextView = (TextView)findViewById(R.id.textView1);
        resultTextView.setText((CharSequence)"Result");
        
        /* Find Tablelayout defined in main.xml */
        TableLayout tl = (TableLayout)findViewById(R.id.tableLayout1);
        
        Integer maxSkillAvaible = 9;
        TableRow temporaryTableRow = null;
        
        for (Integer counter=0; counter < maxSkillAvaible; counter++){
        	
        	Integer value = counter+1;
        	
        	if ((counter%3) == 0){
        		/* Create a new row to be added. */
		        temporaryTableRow = new TableRow(this);
		        temporaryTableRow.setLayoutParams(new LayoutParams(
		        		LayoutParams.FILL_PARENT,
		        		LayoutParams.WRAP_CONTENT));
		        
		        /* Add row to TableLayout. */
		        tl.addView(temporaryTableRow,new TableLayout.LayoutParams(
		                  LayoutParams.FILL_PARENT,
		                  LayoutParams.WRAP_CONTENT));
        	}
	        
        	/* Create a Button to be the row-content. */
	        Button temporatyButton = new Button(this);
	        temporatyButton.setText(value.toString());
	        temporatyButton.setTag(Integer.valueOf(value));
	        temporatyButton.setOnClickListener(new View.OnClickListener(){
	            public void onClick(View v) {
	            	Button n = (Button)v;
	            	Integer g = (Integer)n.getTag();
	            	
	            	FateSystemUtilities FSU = new FateSystemUtilities();
	            	FSU.throwDices();
	            	int value = g+FSU.resultTotalDices;
	            	
	            	resultTextView.setText((CharSequence)"");
	                resultTextView.setText(""+value);
	            }
	        });
	        
	        temporatyButton.setLayoutParams(new LayoutParams(
	        		LayoutParams.FILL_PARENT,
	        		LayoutParams.WRAP_CONTENT));
	        
	        /* Add Button to row. */
	        temporaryTableRow.addView(temporatyButton);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_dice_roller, menu);
        return true;
    }

}
