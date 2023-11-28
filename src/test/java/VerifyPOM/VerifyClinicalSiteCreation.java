package VerifyPOM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

public class VerifyClinicalSiteCreation extends BaseClass {
	
	@Test
	void VerifyProjectTeam() throws InterruptedException, CsvValidationException, IOException {
	 test=report.createTest("verify clinical site creation");
     cc.ClinicalSiteCreation();
}
}
