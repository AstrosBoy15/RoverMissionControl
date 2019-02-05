package commands;

import java.util.ArrayList;
import java.util.List;

public abstract class InputComponent {
	
private String id;
	
	private List<String> aliases;
	private List<Argument<?>> arguments;
	
	public InputComponent(String id) {
		this.id = id;
		this.aliases = new ArrayList<String>();
		this.arguments = new ArrayList<Argument<?>>();
	}
	
	public String getId() {
		return id;
	}
	
	public void addAlias(String alias) {
		aliases.add(alias);
	}

	public List<String> getAliases() {
		return aliases;
	}
	
	public void addArgument(Argument<?> arg) {
		arguments.add(arg);
	}
	
	public List<Argument<?>> getArguments(){
		return arguments;
	}
	
}
