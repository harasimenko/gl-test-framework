package src.test.java.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EnvironmentTest extends BaseTest {
    @Test
    public void initialTest() {
        log.info(String.format("Environment url: %s", configReader.getAppUrl()));

        assertEquals("https://stats.nba.com/stats/boxscore", this.configReader.getAppUrl());
    }
}