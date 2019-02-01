package commands;

import java.util.ArrayList;
import java.util.List;

public class Argument<T> {

	private String id;

	private List<String> aliases;
	private List<Argument<?>> subArguments;
	private Action<?> action;

	public Argument(String id) {
		this.id = id;
		this.aliases = new ArrayList<String>();
		this.subArguments = new ArrayList<Argument<?>>();
	}

	public String getID() {
		return id;
	}

	public void addAlias(String alias) {
		aliases.add(alias);
	}

	public List<String> getAliases() {
		return aliases;
	}
	
	public void addSubArgument(Argument<?> arg) {
		subArguments.add(arg);
	}
	
	public void addAction(Action<?> action) {
		this.action = action;
	}
	
	public void executeAction() {
		//This should probably return something...
		action.onAction();
	}

	public List<Argument<?>> getSubArguments() {
		return subArguments;
	}

}
