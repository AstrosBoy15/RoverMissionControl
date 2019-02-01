package main;

import java.util.ArrayList;
import java.util.List;

import commands.Argument;
import commands.Command;
import commands.Word;

public class Main {

	private static List<Character> command = new ArrayList<Character>();
	private static List<Command> commandList = new ArrayList<Command>();

	public static void main(String[] args) {
		//Random test command + arguments
		Command move = new Command("move");
		move.addArgument(new Argument<Integer>("steps"));
		move.addArgument(new Argument<Boolean>("right"));
		move.getArguments().get(0).addSubArgument(new Argument<Float>("steps"));
		commandList.add(move);
		
		//Won't throw an error
		String cmd = "move steps";
		checkCommand(cmd);
		
		//Will throw an error
		cmd = "walk steps";
		checkCommand(cmd);

	}

	public static void checkCommand(String cmd) {
		char[] chars = cmd.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			command.add(chars[i]);
		}

		List<Word> words = Word.splitToWords(chars);
		Command current = null;

		for(Command comd : commandList) {
			if(comd.getId().equals(words.get(0).getString())) {
				current = comd;
				words.remove(0);
				break;
			}
		}
		if(current != null) {
			for(Argument<?> arg : current.getArguments()) {
				if(arg.getID().equals(words.get(0).getString())) {
					//Should probably move this into another method
				}
			}
		} else {
			System.out.println("Error! Command '" + words.get(0).getString() + "' not found!");
		}
	}

}
