package com.jecnua.fatesystemdiceroller;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DiceRoller extends Activity {

	
	TextView resultTextView;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        
        resultTextView = (TextView)findViewById(R.id.displayResult);
        
    }
    
    
    public void skillClickHandler(View v) {
    	
    	Button n = (Button)v;
    	Integer g = Integer.parseInt((String)n.getText());
    	
    	FateSystemUtilities FSU = new FateSystemUtilities();
    	FSU.throwDices();
    	int value = g+FSU.resultTotalDices;
    	
    	resultTextView.setText((CharSequence)"");
        resultTextView.setText(""+value);
        
        //Show witch button has been pressed last
        //n.setBackgroundColor(Color.BLUE);
//        n.setText("["+n.getText()+"]");
        
        //Get the result of each dice and update the corresponding image
        ImageView i = (ImageView)findViewById(R.id.firstDice);
        changeImage(i, FSU.resultForSingleDice[0]);
        i = (ImageView)findViewById(R.id.secondDice);
        changeImage(i, FSU.resultForSingleDice[1]);
        i = (ImageView)findViewById(R.id.thirdDice);
        changeImage(i, FSU.resultForSingleDice[2]);
        i = (ImageView)findViewById(R.id.fourthDice);
        changeImage(i, FSU.resultForSingleDice[3]);
        
        //Show the total result of the dice
        changeArrows((ImageView)findViewById(R.id.imageView1), (ImageView)findViewById(R.id.imageView2), FSU.resultTotalDices);
        
        
    }

    public void changeArrows(ImageView up, ImageView down, int dice){
    	switch(dice){
	    	case (4):
	    	case (3):
	    		up.setVisibility(View.VISIBLE);
	    		up.setImageResource(R.drawable.bigarrowup);
	    		down.setVisibility(View.INVISIBLE);
	    		break;
	    	case (2):
	    	case (1):
	    		up.setVisibility(View.VISIBLE);
	    		up.setImageResource(R.drawable.arrowup);
	    		down.setVisibility(View.INVISIBLE);
	    		break;
	    	case (0):
	    		up.setVisibility(View.INVISIBLE);
	    		down.setVisibility(View.INVISIBLE);
	    		break;
	    	case (-1):
	    	case (-2):
	    		up.setVisibility(View.INVISIBLE);
		    	down.setVisibility(View.VISIBLE);	
		    	down.setImageResource(R.drawable.arrowdown);
	    		break;
	    	case (-3): 
	    	case (-4):
	    		up.setVisibility(View.INVISIBLE);
		    	down.setVisibility(View.VISIBLE);	
		    	down.setImageResource(R.drawable.bigarrowdown);
    	}
    }
    
    
    public void changeImage(ImageView image, int dice){
    	switch(dice){
	    	case (-1):
	    		image.setImageResource(R.drawable.minus);
	    		break;
	    	case (0):
	    		image.setImageResource(R.drawable.nothing);
	    		break;
	    	case (1):
	    		image.setImageResource(R.drawable.plus);
	    		break;
    	}
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_dice_roller, menu);
        return true;
    }

    
}
