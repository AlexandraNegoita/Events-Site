package connect;

public class EventType {
	private String typeName;
	private int eventCount;
	public int getEventCount() {
		return eventCount;
	}
	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}
	public EventType(String typeName, int eventCount) {
		this.typeName = typeName;
		this.eventCount = eventCount;
	}

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
