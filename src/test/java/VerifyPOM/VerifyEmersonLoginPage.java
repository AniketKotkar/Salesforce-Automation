package VerifyPOM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

public class VerifyEmersonLoginPage extends BaseClass {
	
	@Test
	void VerifyLoignScenarios() throws CsvValidationException, IOException, InterruptedException
	{
		test=report.createTest("Verify Emerson login");
		lg2.LoginDeal2();
	}
}
