package com.country.test;

import org.junit.Assert;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestDao extends TestCase {

    public void testGetFullName(  ) { 
    	
    	Assert.assertEquals(1, 3);
    }

    public void testNullsInName(  ) { }

    public static Test suite(  ) {
        TestSetup setup = new TestSetup(new TestSuite(TestDao.class)) {
            protected void setUp(  ) throws Exception {

            }

            protected void tearDown(  ) throws Exception {

            }
        };
        return setup;
    }
}