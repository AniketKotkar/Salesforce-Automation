package VerifyPOM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

public class VerifyProjectTeamRecordCreation extends BaseClass {
	
	@Test
	void VerifyProjectTeam() throws InterruptedException, CsvValidationException, IOException {
	 test=report.createTest("Verify Project Team Record creation");
     ptc.ProjectTeamRecordCreation();
}
}
