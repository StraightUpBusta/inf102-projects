package no.uib.ii.inf102.f18.mandatory2;

/**
 * @author You
 */
public class Event {
    final Date date;
    final String title;
    String description;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }
    
    @Override
    public int hashCode() {
    	int hash = 17;
    	hash = 31*hash + date.hashCode();
    	hash = 31*hash + title.hashCode(); 
    	return hash;
    }
    
    @Override
    public boolean equals(Object o) {
    	Event e = (Event) o;
    	if (date.equals(e.date) && title.equals(e.title))
    		return true;
    	else return false;
    }
}
