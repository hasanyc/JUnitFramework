package testPackage;

import java.util.Collection;
import locators.MyAccount;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.Parameterized.Parameters;
import utilities.Browsers;
import values.MyAccountValue;
import base.BaseClass;


public class ValidLogInInfo extends BaseClass{
	
	MyAccount 		mal = new MyAccount();
	MyAccountValue 	mav = new MyAccountValue();
	
	public ValidLogInInfo(Browsers browser) {
		super(browser);
	}
	
	@Parameters
	public static Collection<Browsers[]> data(){
		return Browsers.chooseBrowsersForExectution();
	}
	
	@Rule
	public ErrorCollector errCol = new ErrorCollector();
	
	
	
	@Test ()
	public void ValidInfo (){
		
		driver.get (BaseURL+ "/account/clubspa/index.jsp");
		typeByXpath (mal.email, mav.email);
		typeByXpath (mal.password, mav.pass);
		clickByXpath (mal.submitButton);
		
		try{
			inLineValidation (mal.actFullName, mav.expFullNameValue);
		}catch(Throwable t){
			errCol.addError(t);
			System.err.println("Full not was not matching with ");
		}
		
		clickByLink (mal.logOutLink);
		System.out.println ("Log in with valid info test case compleated");
	}

}
