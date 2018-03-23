
public class GenerateList {
	//Generate the lists. ordered, reversed, almost order, and random. 
	//currently using listlength which is set to a default 100,
	//when the stuff if hooked up, it will grab the length from the slider in sortingProperties
   
    public static void inOrder(int [] list) {
    	//get the list length from the slider in Sorting Properties 
    	//sets every number between 0 and num
    	for(int i = 0; i < list.length; i++) {
    		list[i] = i;
    	}
    }
    
    public static void almostOrder(int [] list) {
    	//int listLength = getListLength; 
		//get the list length from the slider in Sorting Properties 
		
		//1/10 chance for the num to be anything. 
		for(int i = 0; i < list.length; i++) {
			
			int offset = (int)(Math.random()*10);
			
			if(offset>7) {
				list[i] = (int)(Math.random()*list.length);
			}
			else {
				list[i] = i;
			}
		}
    }

    public static void reverseOrder(int [] list) {
 
		for(int i = 0; i < list.length; i++) {
			list[i] = (list.length-i);
		}
    }

   

    public static void randomOrder(int [] list) {
    	//int listLength = getListLength; 
		//get the list length from the slider in Sorting Properties 
		for(int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random()*(list.length));
		}
		
	}
}

