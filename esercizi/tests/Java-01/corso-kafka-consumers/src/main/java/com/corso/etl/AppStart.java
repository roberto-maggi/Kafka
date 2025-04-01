package com.corso.etl;

import com.corso.etl.consumers.Consumer01;

public class AppStart {

	public static void main(String[] args) {
		
		System.out.println("Start Consumers");
		
		Consumer01 client01 = new Consumer01();
		
		client01.loadMessages();
		
		System.out.println("End Consumers");
	
	}
	
}
