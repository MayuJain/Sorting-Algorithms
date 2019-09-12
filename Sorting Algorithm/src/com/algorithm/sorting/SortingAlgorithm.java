package com.algorithm.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long time1=0;
		long time2=0;
		long timeOfExecution=0;

		SortingAlgorithm sa=new SortingAlgorithm();

		//Generating an array of random integers
		int[] randomArray=sa.generateRandonArray(500);

		/*------ Insertion sort -------------*/

		time1=System.nanoTime();
		int[] insertionSortArray=sa.insertionSort(randomArray);
		time2=System.nanoTime();

		//Execution time for insertion sort
		timeOfExecution=time2-time1;
		System.out.println("for sorting random array through insertion sort:"+timeOfExecution);

		//for already sorted array
		time1=System.nanoTime();
		sa.insertionSort(insertionSortArray);
		time2=System.nanoTime();
		//Execution time for already sorted array through Insertion  sort
		timeOfExecution=time2-time1;
		System.out.println("for already sorted array through insertion sort:"+timeOfExecution);

		//Generating inverse array from sorted array
		int[] inverseArray=sa.inverseArray(insertionSortArray);
		time1=System.nanoTime();
		sa.insertionSort(inverseArray);
		time2=System.nanoTime();
		//Execution time for Inverse sorted array through Insertion  sort
		timeOfExecution=time2-time1;
		System.out.println("for inversly sorted array through insertion sort:"+timeOfExecution);


		/*------ Merge sort -------------*/


		time1=System.nanoTime();
		int[] mergeSortArray=sa.mergeSort(randomArray,0,randomArray.length-1);
		time2=System.nanoTime();

		//Execution time for Merge sort
		timeOfExecution=time2-time1;
		System.out.println("for sorting random array through Merge sort:"+timeOfExecution);

		//for already sorted array
		time1=System.nanoTime();
		sa.mergeSort(mergeSortArray,0,mergeSortArray.length-1);
		time2=System.nanoTime();
		//Execution time for already sorted array through merge  sort
		timeOfExecution=time2-time1;
		System.out.println("for already sorted array through merge sort:"+timeOfExecution);

		//Generating inverse array from sorted array
		int[] inverseArray3=sa.inverseArray(mergeSortArray);
		time1=System.nanoTime();
		sa.mergeSort(inverseArray3,0,inverseArray3.length-1);
		time2=System.nanoTime();
		//Execution time for Inverse sorted array through merge  sort
		timeOfExecution=time2-time1;
		System.out.println("for inversly sorted array through merge sort:"+timeOfExecution);

		/*------ Inplace Quick sort -------------*/

		time1=System.nanoTime();
		int[] inplaceSortArray=sa.inplaceQuickSort(randomArray,0,randomArray.length-1);
		time2=System.nanoTime();

		//Execution time for inplace quick sort
		timeOfExecution=time2-time1;
		System.out.println("for sorting random array through Inplace quick sort:"+timeOfExecution);

		//for already sorted array
		time1=System.nanoTime();
		sa.inplaceQuickSort(inplaceSortArray,0,inplaceSortArray.length-1);
		time2=System.nanoTime();
		//Execution time for already sorted array through in-place quick sort
		timeOfExecution=time2-time1;
		System.out.println("for already sorted array through in-place quick sort:"+timeOfExecution);

		//Generating inverse array from sorted array
		int[] inverseArray2=sa.inverseArray(inplaceSortArray);
		time1=System.nanoTime();
		sa.inplaceQuickSort(inverseArray2,0,inverseArray2.length-1);
		time2=System.nanoTime();
		//Execution time for Inverse sorted array through in-place quick sort
		timeOfExecution=time2-time1;
		System.out.println("for inversly sorted array through in-place quick sort:"+timeOfExecution);

		/*------ Modified sort -------------*/

		time1=System.nanoTime();
		int[] modifiedSortArray=sa.modifiedQuickSort(randomArray);
		time2=System.nanoTime();

		//Execution time for modified sort
		timeOfExecution=time2-time1;
		System.out.println("for sorting random array through Modified sort:"+timeOfExecution);

		//for already sorted array
		time1=System.nanoTime();
		sa.modifiedQuickSort(modifiedSortArray);
		time2=System.nanoTime();
		//Execution time for already sorted array through modified Quick  sort
		timeOfExecution=time2-time1;
		System.out.println("for already sorted array through modified quick sort:"+timeOfExecution);

		//Generating inverse array from sorted array
		int[] inverseArray4=sa.inverseArray(modifiedSortArray);
		time1=System.nanoTime();
		sa.modifiedQuickSort(inverseArray4);
		time2=System.nanoTime();
		//Execution time for Inverse sorted array through modified Quick sort
		timeOfExecution=time2-time1;
		System.out.println("for inversly sorted array through modified sort:"+timeOfExecution);

	}

	public int[] generateRandonArray(int size) {

		int[] numbersArray = new int[size];       

		for(int i = 0; i < numbersArray.length; i++) {
			numbersArray[i] = (int)(Math.random()*size + 1);
		}
		System.out.println("Numbers Generated: " + Arrays.toString(numbersArray));
		return numbersArray;
	}

	public static int[] insertionSort(int[] numArray) {

		for(int i=1;i<numArray.length;i++) {

			int key=numArray[i];
			int j=i-1;

			while (j>-1 && numArray[j]>key) {	

				numArray[j+1]=numArray[j];
				j=j-1;	

			}
			numArray[j+1]=key;	
		}
		return numArray;
	}


	public int[] inverseArray(int[] arra) {

		int[] newArray=new int[arra.length];
		int j=0;
		for (int i=arra.length-1; i>-1;i--) {

			newArray[j]=arra[i];
			j++;
		}
		return newArray;
	}

	public int[] mergeSort(int[] numArray, int l, int r) {


		if (l < r)
		{
			// Find the middle point
			int m = (l+r)/2;

			// Sort first and second halves
			mergeSort(numArray, l, m);
			mergeSort(numArray , m+1, r);

			// Merge the sorted halves
			merge(numArray, l, m, r);
		}

		return numArray;
	}

	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int [n1];
		int R[] = new int [n2];

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i)
			L[i] = arr[l + i];
		for (int j=0; j<n2; ++j)
			R[j] = arr[m + 1+ j];


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public int findRandomPivot(int upper,int lower)
	{
		int randomNumber;
		Random r=new Random();
		randomNumber = (lower ) + (int)(Math.random()* ( upper - lower + 1));
		return randomNumber;
	}

	public int[] inplaceQuickSort(int[] numarray,int low,int high) {

		if(low<high) {

			int i=low, j=high, tmp; 

			int pivotIndex=findRandomPivot(high,low);

			int pivotValue = numarray[pivotIndex]; 

			do {
				while(numarray[i]<pivotValue)
					i++;
				while(numarray[j]>pivotValue) 
					j--;

				if( i <= j){            
					tmp = numarray[i];
					numarray[i] = numarray[j];
					numarray[j] = tmp;
					i++;            
					j--;
				}
			} while(i <= j);           

			if(low < j)  inplaceQuickSort(numarray,low,j);
			if(i < high) inplaceQuickSort(numarray,i,high);

		}
		return numarray;
	}

	public static int[] modifiedQuickSort(int[] intArray) {
		int[] finalArray= quickSort(intArray, 0, intArray.length - 1);
		return finalArray;
	}

	public static int[] quickSort(int[] intArray, int left, int right) {

		if (left+10<=right) {	
			double median = getMedian(intArray, left, right);
			int partition = createPartition(intArray, left, right, median);
			quickSort(intArray, left, partition - 1);
			quickSort(intArray, partition + 1, right);
		}
		else {
			insertionSort(intArray);
		}
		return intArray;
	}

	public static int getMedian(int[] intArray, int left, int right) {
		int center = (left + right) / 2;

		if (intArray[left] > intArray[center])
			swap(intArray, left, center);

		if (intArray[left] > intArray[right])
			swap(intArray, left, right);

		if (intArray[center] > intArray[right])
			swap(intArray, center, right);

		swap(intArray, center, right - 1);
		return intArray[right - 1];
	}

	public static void swap(int[] intArray, int index1, int index2) {
		int temp = intArray[index1];
		intArray[index1] = intArray[index2];
		intArray[index2] = temp;
	}

	public static int createPartition(int[] intArray, int left, int right, double pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;

		while (true) {
			while (intArray[++leftPtr] < pivot)
				;
			while (intArray[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(intArray, leftPtr, rightPtr);
		}
		swap(intArray, leftPtr, right - 1);
		return leftPtr;
	}



}


