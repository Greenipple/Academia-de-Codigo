class ClosestNeighbours {	
	public static void main(String[] args) {

    		int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};
    		int[] result = findClosest(myArray);
    // print the elements of the resulting array
	}

	private static int[] findClosest(int[] numbers) {
		int diference = Math.abs (myArray[0] -myArray[1]);
		int index=0;
    		for (int i=1; i< myArray.length; i++){
			if ( Math.abs(myArray[i] - myArray[i+1]) < diference) {
				diference= Math.abs (myArray[i] - myArray[i+1]);
				index=i;
				result[0] = myArray[index];
				result[1] = myArray[index+1];
				return result;


			}
			


	}
}
}

