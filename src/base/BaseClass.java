package base;


import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import utilities.Browsers;
import utilities.WebDriverAPI;


@RunWith(Parameterized.class)
public class BaseClass extends WebDriverAPI  {
public String BaseURL;
	
public BaseClass (Browsers browser) {
	driver = browser.getRemoteDriver();
}
	
@Parameters
public static Collection<Browsers[]> data(){
	return Browsers.chooseBrowsersForExectution();
}
	

@Before
public void setUp() throws Exception {
	BaseURL = "http://www.spafinder.com";
	iWait (35);
	maxPage();
}
	

	

@After
public void closeBrowser() throws Exception {
	driver.close();
}



@AfterClass 
public static void tearDown() {
	driver.quit();
}






}


