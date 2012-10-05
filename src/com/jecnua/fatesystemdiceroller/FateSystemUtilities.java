/** 
    Fate System Dice Roller for Android 
    Copyright (C) 2012 Fabrizio Sabatini

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
