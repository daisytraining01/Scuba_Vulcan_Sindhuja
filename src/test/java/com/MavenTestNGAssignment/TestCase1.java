package com.MavenTestNGAssignment;





import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 {

	@BeforeMethod
	@BeforeClass
	public void setUp() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs once before class", true);
	}

	@AfterClass
	public void cleanUp() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs once after class", true);
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs before every method", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs after every method", true);
	}

	@DataProvider(name = "add")
	public Object[][] getData() {
		return new Object[][] { { 1, 4 } };
	}

	@DataProvider(name = "divreal")
	public Object[][] getData1() {
		return new Object[][] { { 1, 4 }, { 2, 0 },

		};
	}

	@DataProvider(name = "exp")
	public Object[][] getData2() {
		return new Object[][] { { 1, 1 }

		};
	}

	@Test(dataProvider = "add", groups = { "SmokeTest2" })
	public void Addition(int a, int b) {
		
		Object exepectedCondition = 5;
		Object falseExpectedCondition = 4;
		Object d = Calculator.add(a, b);
		
		// Using assertEquals
		System.out.println("Using assertEquals");
		Reporter.log("TestNG_ReportsAndLogs -> Addition is completed", true);
		assertEquals(d, exepectedCondition);
		

	}

	@Test(dataProvider = "divreal", groups = { "SmokeTest1" })
	public void divreal(int a, int b) {
		
		Object exepectedCondition = 5;
		Object falseExpectedCondition = 4;
		Object d = Calculator.divReal(a, b);
		
		// Using assertEquals
		System.out.println("Using assertEquals");
		Reporter.log("TestNG_ReportsAndLogs -> Div Real  is performed", true);
		assertEquals(d, exepectedCondition);

	}

	@Test(dataProvider = "exp", groups = { "SmokeTest2" })
	public void exp(int a, int b) {
	
		Object d = Calculator.exp(a, b);
		
		// Using assertEquals
		System.out.println("Using assertNotEquals");
		Reporter.log("TestNG_ReportsAndLogs -> Exp is Performed", true);
		assertNotEquals(d, 1);

	}

	@Test(groups = { "SmokeTest1" })
	@Parameters({ "FirstValue", "SecondValue" })
	public void Subtraction(int FirstValue, int SecondValue) {
		Object exepectedCondition = 6;
		Object s = Calculator.sub(FirstValue, SecondValue);
		// Using assertTrue
		System.out.println("Using assertTrue");
		Reporter.log("TestNG_ReportsAndLogs -> Subtraction is completed", true);
		assertTrue(s.equals(exepectedCondition));
	}

	@Test(groups = { "SmokeTest3" })
	@Parameters({ "MuFirstValue", "MuSecondValue" })
	public void multiplication(int MuFirstValue, int MuSecondValue) {
		Object exepectedCondition = 40;
		Object s = Calculator.mul(MuFirstValue, MuSecondValue);
		// Using assertTrue
		System.out.println("Using assertTrue");
		Reporter.log("TestNG_ReportsAndLogs -> Multipliaction is completed", true);
		assertTrue(s.equals(exepectedCondition), "Verfied through assertion");
	}

}



