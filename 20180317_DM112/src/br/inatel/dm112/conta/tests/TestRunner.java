package br.inatel.dm112.conta.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		
		Result resContaPoupanca = JUnitCore.runClasses(TestContaPoupanca.class);
		
		//
		for (Failure fail : resContaPoupanca.getFailures()) {
			
			System.out.println(fail.toString());
			
		}
		
		System.out.println(resContaPoupanca.wasSuccessful());

	}

}
