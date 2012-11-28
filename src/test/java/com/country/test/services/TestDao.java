package com.country.test.services;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;

public class TestDao extends TestCase {

    public void testGetFullName(  ) { 
    	
    	Assert.assertEquals(1, 1);
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