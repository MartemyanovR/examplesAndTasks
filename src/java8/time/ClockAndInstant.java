package java8.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Assert;
import org.junit.Test;

public class ClockAndInstant {
	
	@Test
    public void testInstantFields() throws Exception {
        Instant instant = Clock.systemDefaultZone().instant();

        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());

        System.out.println(instant.toEpochMilli());
    }

	
	 @Test
	    public void testInstantString() throws Exception {
	        Instant instant1 = Clock.system(ZoneId.of("Europe/Moscow")).instant();
	        System.out.println(instant1.toString());

	        Instant instant2 = Clock.systemUTC().instant();
	        System.out.println(instant2.toString());

	        Instant instant3 = Clock.systemDefaultZone().instant();
	        System.out.println(instant3.toString());
	    }
	 
	 @Test
	    public void testLocalDateTime() throws Exception {
	        ZonedDateTime zdt1 = ZonedDateTime.of(2015, 1, 10, 15, 0, 0, 0, ZoneId.of("Europe/Moscow"));
	        ZonedDateTime zdt2 = ZonedDateTime.of(2015, 1, 10, 14, 0, 0, 0, ZoneId.of("Europe/London"));
	        Assert.assertEquals(-1, zdt1.compareTo(zdt2));

	        LocalDateTime ldt1 = zdt1.toLocalDateTime();
	        LocalDateTime ldt2 = zdt2.toLocalDateTime();
	        System.out.println(ldt1);
	        System.out.println(ldt2);
	        Assert.assertEquals(+1, ldt1.compareTo(ldt2));
	    }
}
