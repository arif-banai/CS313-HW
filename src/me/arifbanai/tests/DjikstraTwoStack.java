package me.arifbanai.tests;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import me.arifbanai.dataStructure.LinkedStack;

public class DjikstraTwoStack {
	
	public static double evaluate(double operandOne, double operandTwo, char operator) {
		switch(operator) {
			case '+':
				return operandOne + operandTwo;
			case '-':
				return operandOne - operandTwo;
			case '*':
				return operandOne * operandTwo;
			case '/':
				return operandOne / operandTwo;
			case '%':
				return operandOne % operandTwo;
			default:
				throw new IllegalArgumentException("Method <evaluate> not used properly!");
		}
	}

	public static void main(String[] args) {
		LinkedStack<Double> operands = new LinkedStack<>();
		LinkedStack<Character> operators = new LinkedStack<>();
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("C:\\Users\\Smeef\\git\\CS313-HW\\src\\twostack.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
			e.printStackTrace();
			System.exit(1);
		}
		
		while(scan.hasNext()) {
			String input = scan.next();
			
			
			if(input.length() == 1) {
				Character x = input.charAt(0);

				if(x.equals(' ')) {
					continue;
				}
				
				if(x.equals('(')) {
					continue;
				}
				
				if(Character.isDigit(x)) {
					operands.push((double) x);
					continue;
				}
				
				if((x.equals('+') || x.equals('-')) || ((x.equals('*') || x.equals('/')) || x.equals('%'))) {
					operators.push(x);
					continue;
				}
				
				if(x.equals(')')) {
					//operand two is on top of operand one
					double operandTwo = operands.pop();
					double operandOne = operands.pop();
					
					char operator = operators.pop();
					
					double result = evaluate(operandOne, operandTwo, operator);
					operands.push(result);
				}
			}
		}
		
		System.out.println("The result is: " + operands.checkTop());
	}

}
