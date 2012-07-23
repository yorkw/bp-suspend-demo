package com.example.m0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class HelloService extends Service {
	private static String TAG = HelloService.class.toString();
	
	protected ServiceBinder serviceBinder = new ServiceBinder();
	
	@Override
	public IBinder onBind(Intent intent) {
		return serviceBinder;
	}

	/**
	 * Service implementation..
	 */
	public class ServiceBinder extends Binder implements IHelloService {
		public boolean foo() {
			try {
				Log.i(TAG, "## this is in main thread");
				// spawn thread:
				ExecutorService executorService = Executors.newSingleThreadExecutor();
				executorService.execute(new Runnable() {
				  public void run() {
					  Log.i(TAG, "## this is in spawned thread");
					  Log.i(TAG, "## set break point here (with policy Suspend VM)");
					  Log.i(TAG, "## line 1");
					  Log.i(TAG, "## line 2");
					  Log.i(TAG, "## line 3");
				  }
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
	}

}
