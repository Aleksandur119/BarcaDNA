import java.util.List;

abstract class Field  {

	private Insets location =new Insets();
	
	private boolean free=true;
	
	public Field(){}
	
	public Field(Insets location) {
		this.location=location;
	}
	
	abstract void execute(Player current);
	
	abstract  List<Field> getField();

	
	public Insets getLocation() {
		return location;
	}

	public void setLocation(Insets location) {
		this.location = location;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}
	enum Fields{
		TRAPS,CHANCE,IVEST;
	}

}
