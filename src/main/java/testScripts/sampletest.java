package testScripts;

import org.testng.annotations.Test;

import helper.AssertionHelper;
import testBase.TestBase;

public class sampletest extends TestBase{
	
	
	public sampletest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void Test1() {
		AssertionHelper.makeTrue();	
	}
	
	@Test
	public void Test2() {
		AssertionHelper.makeFalse();
	}
	
	@Test
	public void Test3() {
		AssertionHelper.makeTrue();	
	}
	
	@Test
	public void Test4() {
		AssertionHelper.makeFalse();	
	}

}
