/**
 * @package com.dancosoft.socialcommunity.dao.support
 * 
 * Package com.dancosoft.socialcommunity.dao.support contain set of classes which providing
 * support dao layer of SocialCommunity project. This package contain classes which support
 * converting data types. This project is based on MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.dancosoft.socialcommunity.dao.support;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class TimeConverter providing support date formate. Java 8 have new pakage java.time
 * which contain new formates(LocalDateTime).Class contain methods which execute converting
 * from Date(java.util.Date) format to LocalDateTime(java.time.LocalDateTime). For converting
 * use Instant (java.time.Instant) as intermediate result. That format use ZoneOffset.UTC zone.
 * 
 * @version 1.0 22.12.2015
 * @author Zaerko Denis
 */
//@Converter(autoApply = true)
public class TimeConverter {//implements AttributeConverter<LocalDateTime, Timestamp> {
	
	private static final Logger logger = LoggerFactory.getLogger(TimeConverter.class);
	
//    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
//    	return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
//    }
//
//    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
//    	return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
//    }
    
	/**
	 * Method covert Date format to LocalDateTime format.Method use UTC
	 * time zone whan converting. 
	 * 
	 * @see java.util.Date
	 * @see java.time
	 * 
	 * @type Date
	 * @type LocalDateTime
	 * @param date(in format Date)
	 * @return date in format LocalDateTime
	 */
	public LocalDateTime convertDateToLocalDateTime(Date date) {
		logger.info("TimeConverter: Date which have format Date(java.util.Date) convert to LocalDateTime(java.time.LocalDateTime).");
		Instant instant = Instant.ofEpochMilli(date.getTime());
	    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
	    return localDateTime;
	}
	
	/**
	 * Method covert LocalDateTime format to lDate format.Method use UTC
	 * time zone whan converting. 
	 * 
	 * @see java.util.Date
	 * @see java.time
	 * 
	 * @type Date
	 * @type LocalDateTime
	 * @param localDateTime(in format LocalDateTime)
	 * @return date in format Date
	 */
	public Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
		logger.info("TimeConverter: Date which have format LocalDateTime(java.time.LocalDateTime) convert to Date(java.util.Date).");
		Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
	    Date date = Date.from(instant);
	    return date;
	}
}
