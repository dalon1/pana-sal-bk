package com.panasalbk.app.utils;

import java.util.Scanner;
import com.panasalbk.app.utils.StringUtils;

import com.panasalbk.app.enumerations.InputCommands;

public class ScanUtils {
	private static Scanner scan = new Scanner(System.in);
	
	public static String printScan(String prompt, InputCommands command) {
		System.out.printf("%s %s:", StringUtils.capitalize(command.name()), prompt);
		String in = StringUtils.trim(scan.nextLine());
		return in;
	}
	
	/**
	 * Default Input command - Enter
	 * @param prompt
	 * @return
	 */
	public static String printScan(String prompt) {
		System.out.printf("%s %s:", StringUtils.capitalize(InputCommands.ENTER.name()), prompt);
		String in = StringUtils.trim(scan.nextLine());
		return in;
	}
}
