package no.uib.ii.inf102.f18.mandatory2;

/**
 * @author You
 */
public final class Date {
    final Month month;
    final int year;
    final int day;

    public Date(Month month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }
    
    @Override
    public int hashCode() {
    	int hash = 17;
    	hash = 31*hash + month.hashCode();
    	hash = 31*hash + ((Integer) year).hashCode(); 
    	hash = 31*hash + ((Integer) day).hashCode(); 
    	return hash;
    }
    
    @Override
    public boolean equals(Object o) {
    	Date d = (Date) o;
    	if (month == d.month && year == d.year && day == d.day)
    		return true;
    	else return false;
    }
}
