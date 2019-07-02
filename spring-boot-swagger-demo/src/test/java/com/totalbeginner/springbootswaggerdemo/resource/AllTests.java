package com.totalbeginner.springbootswaggerdemo.resource;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HelloResourceTest.class, UserResourceTest.class, UserTest.class })
public class AllTests {

}
