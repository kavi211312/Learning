package com.vin.test.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };

		for (int i = 0, j = arr.length - 3; i < 3 && j < arr.length; i++, j++) {

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		for (int n : arr) {
			System.out.println(n);
		}
		System.out.println(arr);

		int[] arr4 = { 13, 10, 1, 2, 3, 4, 5, 6, 7, 8, 11 };

		int biggest = arr4[0];

		int secondBiggest = biggest;

		for (int i = 1; i < arr4.length; i++) {

			if (arr4[i] > biggest) {

				secondBiggest = biggest;
				biggest = arr4[i];

			} else if (arr4[i] > secondBiggest) {
				secondBiggest = arr4[i];
			}

		}

	}

}
