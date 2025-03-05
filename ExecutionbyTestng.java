package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExecutionbyTestng {

	@BeforeTest
	public void logintest()
	{
		System.out.println("Login test");
	}
	
	@AfterTest
	public void logouttest()
	{
		System.out.println("Logout test");
	}
	
	@BeforeMethod
	public void checkdbconnect()
	{
		System.out.println("DB is Connected");
	}
	
	@AfterMethod
	public void checkdbdisconnect()
	{
		System.out.println("DB is Disconnected");
	}
	
	@Test(priority=1,description="test1")
	public void test1()
	{
		System.out.println("test1");

	}
	
	@Test(priority=2,description="test2")
	public void test2()
	{
		System.out.println("test2");
	}

}
