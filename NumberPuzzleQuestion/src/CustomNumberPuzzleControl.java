import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		int idx=0;
		for(int i=0;i<=15;i++) {
			if(buttons[i]==buttonClicked) {
				idx=i;
				break;
			}
		}
		if((idx+1==emptyCellId && (idx+1)%4!=0) || idx-1 ==emptyCellId && (idx%4!=0)|| idx+4==emptyCellId || idx-4==emptyCellId) {
			swapButton(buttons[emptyCellId],buttonClicked);
			return idx;		
		}
		return emptyCellId;

	}
	public boolean search(int[]arr,int a) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==a)
				return false;
		}
		return true;
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here

		int i=0;
		while(i<arr.length) {
			int a = getRandomNumber();
			if(a<=15 && search(arr,a)) {
				arr[i]=a;
				i++;
			}
		}
		
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int arr[]=getIntegerArrayOfButtonIds(buttons);
		int prev=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(prev>arr[i]) {
				winner=false;
			}
			prev=arr[i];
		}

		return winner;
	}
}