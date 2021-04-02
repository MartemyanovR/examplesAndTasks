package java8.time;

import java.time.ZoneId;
import java.time.ZoneOffset;

import org.junit.Assert;
import org.junit.Test;

public class TimeZoneTest {
	
	@Test
	 public void testZoneId() throws Exception {
        // case-1
        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        Assert.assertEquals("ZoneRegion", zid1.getClass().getSimpleName());

        // case-2
        ZoneId zid2 = ZoneId.of("UTC+4");
        Assert.assertEquals("ZoneRegion", zid2.getClass().getSimpleName());

        // case-3
        ZoneId zid3 = ZoneId.of("+03:00:00");
        Assert.assertEquals("ZoneOffset", zid3.getClass().getSimpleName());

        // case-4
        ZoneId zid4 = ZoneId.ofOffset("UTC", ZoneOffset.of("+03:00:00"));
        Assert.assertEquals("ZoneRegion", zid4.getClass().getSimpleName());
    }
	
	@Test
    public void testZoneUTC() throws Exception {
        ZoneId zid1 = ZoneOffset.UTC;
        Assert.assertEquals("ZoneOffset", zid1.getClass().getSimpleName());

        ZoneId zid2 = ZoneId.of("Z");
        Assert.assertEquals("ZoneOffset", zid2.getClass().getSimpleName());
        Assert.assertSame(ZoneOffset.UTC, zid2);

        ZoneId zid3 = ZoneId.of("UTC");
        Assert.assertEquals("ZoneRegion", zid3.getClass().getSimpleName());
    }

}
