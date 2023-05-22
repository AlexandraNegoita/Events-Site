package connect;

public class Event {
	private int eventID;
	private String eventName;
	private String type;
	private String eventLink;
	private Date dateBegin;
	private Date dateEnd;
	private String description;
	private int locationID;
	private int userID;
	public Event(int eventID, String eventName, String type, String eventLink, Date dateBegin, Date dateEnd,
			String description, int locationID, int userID) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.type = type;
		this.eventLink = eventLink;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.description = description;
		this.locationID = locationID;
		this.userID = userID;
	}
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getType() {
		return type;
	}
	public void setTypeID(String type) {
		this.type = type;
	}
	public String getEventLink() {
		return eventLink;
	}
	public void setEventLink(String eventLink) {
		this.eventLink = eventLink;
	}
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
