package com.visioninfinity.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * The Date related Utility functions.
 * 
 * @author amit.x.sethi
 */
public class DateUtils {
	/**
	 * Calculates local time for a given time zone.
	 * 
	 * @param epochTime
	 *            - the seconds from Epoch (1 Jan 1970)
	 * @param zoneIdString
	 *            - the zone Id for the zone for which local time is to be
	 *            retrieved.
	 * @return - the local time for a given time zone.
	 */
	public static LocalDateTime getLocalisedDateTimeFromEpoch(long epochTime, String zoneIdString) {
		LocalDateTime t = LocalDateTime.ofEpochSecond(epochTime, 0, ZoneOffset.UTC);
		ZonedDateTime instant = ZonedDateTime.of(t, ZoneId.of("GMT"));
		LocalDateTime localisedDate = instant.withZoneSameInstant(ZoneId.of(zoneIdString)).toLocalDateTime();
		return localisedDate;
	}
}
