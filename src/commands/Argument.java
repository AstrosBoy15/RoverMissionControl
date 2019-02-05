package commands;

public class Argument<T> extends InputComponent{
	private Action<?> action;

	public Argument(String id) {
		super(id);
	}
	
	public void addAction(Action<?> action) {
		this.action = action;
	}
	
	public void executeAction() {
		//This should probably return something...
		action.onAction();
	}

}
