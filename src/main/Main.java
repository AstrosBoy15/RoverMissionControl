package main;

import java.util.ArrayList;
import java.util.List;

import commands.Argument;
import commands.Command;
import commands.InputComponent;
import commands.Word;

public class Main {

	private static List<Character> command = new ArrayList<Character>();
	private static List<Command> commandList = new ArrayList<Command>();

	public static void main(String[] args) {
		// Random test command + arguments
		Command move = new Command("move");
		move.addArgument(new Argument<Integer>("steps"));
		move.addArgument(new Argument<Boolean>("right"));
		move.getArguments().get(0).addArgument(new Argument<Float>("two"));
		move.addAlias("test");
		commandList.add(move);

		// Won't throw an error
		String cmd = "test steps two";
		checkInput(cmd);
		
		// Will throw an error
		cmd = "test steps";
		checkInput(cmd);

		// Will throw an error
		cmd = "walk steps";
		checkInput(cmd);

	}
	
	public static void checkInput(String cmd) {
		char[] chars = cmd.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			command.add(chars[i]);
		}

		List<Word> words = Word.splitToWords(chars);
		
		checkArguments(null, words);
	}

	public static void checkArguments(InputComponent comd, List<Word> words) {
		InputComponent current = null;
		if(!words.isEmpty()) {
			String first = words.get(0).getString();
			
			if(comd == null) {
				for(InputComponent arg : commandList) {
					if(arg.getId().equals(first) || checkAliases(arg, first)) {
						current = arg;
						words.remove(0);
						break;
					}
				}
			} else {
				for(InputComponent arg : comd.getArguments()) {
					if(arg.getId().equals(first) || checkAliases(arg, first)) {
						current = arg;
						words.remove(0);
						break;
					}
				}
			}
			
			if(current != null) {
				if(!current.getArguments().isEmpty()) {
					checkArguments(current, words);
				} else {
					System.out.println("Command executed!");
				}
			} else {
				System.out.println("Error! Argument '" + words.get(0).getString() + "' not found!");
			}
		} else {
			System.out.println("Error! Requires another argument!");
		}
	}

	public static boolean checkAliases(InputComponent comd, String input) {
		for(String alias : comd.getAliases()) {
			if(input.equals(alias))
				return true;
		}
		return false;
	}

}
