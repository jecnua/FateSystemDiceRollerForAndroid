package com.jecnua.fatesystemdiceroller;

public class FateSystemUtilities {

	public int[] resultForSingleDice = {0,0,0,0};
	public int resultTotalDices = 0;
	
    public void throwDices(){

    	int minDiceValue = -1;
        int maxDiceValue = +1;
        int diceTrowsResults = 0;
        
        for (int count = 0; count < 4; count++){
            int thisThrow = minDiceValue + (int)(Math.random() * ((maxDiceValue - minDiceValue) + 1));
            resultForSingleDice[count] = thisThrow;
            diceTrowsResults += thisThrow;
        }

        resultTotalDices = diceTrowsResults;
    }
    
}
