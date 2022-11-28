package commonLibraries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class SeleniumLibraries
{

	public static Logger log =	LogManager.getLogger(SeleniumLibraries.class.getClass());
	
			public void assertTrue(boolean result, String message)
			{
			  if(result==false)
			  {
			      log.error(message);
			  }
			Assert.assertTrue(result);

			}
}
