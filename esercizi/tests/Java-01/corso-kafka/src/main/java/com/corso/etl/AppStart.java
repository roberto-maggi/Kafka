package com.corso.etl;

import java.io.Console;

import com.corso.etl.producers.Producer01;
import com.corso.etl.producers.Producer02;
import com.corso.etl.producers.Producer03;
import com.corso.etl.producers.Producer04;
import com.corso.etl.producers.Producer05;
import com.corso.etl.producers.Producer06;
import com.corso.etl.producers.Producer07;
import com.corso.etl.producers.Producer08;
import com.corso.etl.producers.Producer09;

public class AppStart {
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		// FIRE & FORGET ACK 0
	    Producer01 client01 = new Producer01();
		client01.sendMessagesFireAndForget();

		/*

		// SYNC ACK 1
		Producer02 client02 = new Producer02();
		client02.sendSync();

		// SYNC ACK 2
		Producer03 client03 = new Producer03();
		client03.sendSync();

		// ASYNC ACK 1
		Producer04 client04 = new Producer04();
		client04.sendAsync();
		
		
		
		// SYNC ACK 1
		Producer05 client05 = new Producer05();
		client05.sendSyncCustomer();

		
 	    // SYNC ACK 1
		Producer06 client06 = new Producer06();
		client06.sendSyncCustomer();;

		// SYNC ACK 1
		Producer07 client07 = new Producer07();
		client07.sendSyncCustomerAvro();;
	
		// SYNC ACK 1
		Producer08 client08 = new Producer08();
		client08.sendSyncCutomPartitioner();;
	
		// SYNC ACK 1
		Producer09 client09 = new Producer09();
		client09.sendSyncCutomPartitioner("TP_SHIVA", 3);
		client09.sendSyncCutomPartitioner("TP_ROGNA", 3);
		client09.sendSyncCutomPartitioner("TP_DOC", 5);
	
		 */
		
		
				
		// Console console = System.console();		
		// console.readLine("Premere un tast per chiudere....");
		//while (true) {}
		
		
	}

}
