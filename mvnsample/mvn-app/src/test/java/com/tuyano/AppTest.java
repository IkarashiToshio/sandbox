package com.tuyano;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private App app = null;
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        app = new App();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertNotNull(app);
    }
    
    public void testGetMessage() {
        String name = "hoge";
        String msg = "Hi," + name + ". Welcom to Maven World!";
        
        assertEquals(app.getMessage("hoge"), msg);
    }
}
