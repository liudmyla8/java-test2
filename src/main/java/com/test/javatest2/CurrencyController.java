package com.test.javatest2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CurrencyController {
	
	public static int[] GenCurrency() {
		Random rand = new Random();
		int k = rand.nextInt(500);
		int[] currency = new int[k];		
		int[] item = new int[] {5, 10, 20, 50, 100, 200, 500, 1000};
		for(int i=0; i < k; i++) {
			currency[i] = item[rand.nextInt(item.length)];
		}
		return currency;
	}
	
	public static List<String> SelectCurrency(int[] currency, int total) {
		int sum = total;
		List<String> cash = new ArrayList<String>();
		Sort(currency);
		int k = currency.length;
		if(sum >= currency[k-1]) {
			for(int i=0; i < k; i++) {
				if (sum >= currency[i]) {
					sum -= currency[i];
					cash.add(String.valueOf(currency[i]));
				}
			}
		}
		if (sum != 0) {
			cash = null;
		}
		
		return cash;
	}

	private static void Sort(int[] currency) {
		for(int i = currency.length - 1; i > 0 ; i--) {
			for(int j = 0; j < i; j++) {
				if(currency[j] < currency[j+1]) {
					int tmp = currency[j];
					currency[j] = currency[j+1];
					currency[j+1] = tmp;
				}
			}
		}
	}
}

