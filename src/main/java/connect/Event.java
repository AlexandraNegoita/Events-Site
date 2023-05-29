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
	private int typeID;
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID() {
		if(type.equals("Concerts")) {
			this.typeID = 1;
		}else if(type.equals("Exhibitions")) {
			this.typeID = 2;
		} else if(type.equals("Sports")) {
			this.typeID = 3;
		}else if(type.equals("Fairs")) {
			this.typeID = 4;
		}else if(type.equals("Shows")) {
			this.typeID = 5;
		}
		
	}
	private boolean valid;
	
	
	
	
	public Event() {
		super();
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public Event(int eventID, String eventName, String eventLink, Date dateBegin, Date dateEnd, String description) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventLink = eventLink;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.description = description;
	}
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
	public String getEventSearchData() {
		return this.eventName.replaceAll("\\s+","");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
	public String formatDate(Date date) {
		return date.getYear() + "-" + date.getNumMonth() + "-" + Integer.toString(date.getDay());
	}
	public String getEventDate() {
		if(this.dateBegin.sameDate(this.dateEnd) == true) {
			return Integer.toString(this.dateBegin.getDay());
		} else {
			return Integer.toString(this.dateBegin.getDay()) + "-" + Integer.toString(this.dateEnd.getDay());
		}
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
