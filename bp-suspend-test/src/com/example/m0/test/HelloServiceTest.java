package com.example.m0.test;

import com.example.m0.HelloService;
import com.example.m0.HelloService.ServiceBinder;

import android.content.Intent;
import android.test.ServiceTestCase;
import android.util.Log;

public class HelloServiceTest extends ServiceTestCase<HelloService> {
	private static String TAG = HelloServiceTest.class.toString();
	
	private ServiceBinder serviceBinder;

	public HelloServiceTest() {
		super(HelloService.class);
	}
	
	public void setUp() throws Exception {
		super.setUp();
	    serviceBinder = (ServiceBinder) bindService(new Intent(getContext(), HelloService.class));
	    assertNotNull(serviceBinder);
	    Log.d(TAG, "service binder resolved");
	}
	
	/**
	 * test ServiceBinder.foo()
	 */
	public void testFoo() {
		boolean success = false;
		success = serviceBinder.foo();
		assertTrue(success);
	}

}
