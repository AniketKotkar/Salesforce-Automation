package VerifyPOM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

public class VerifyProjectAccountCreation extends BaseClass {
	@Test
	void VerifyProjectTeam() throws InterruptedException, CsvValidationException, IOException {
	 test=report.createTest("Verify Project Account creation");
     pac.ProjectAccountCreation();
     pac.ProjectCreation();
 }
}
