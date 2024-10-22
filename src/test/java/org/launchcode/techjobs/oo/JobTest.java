package org.launchcode.techjobs.oo;



import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals( "Job ID is incrementing incorrectly",job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue("Name is not a String",job.getName() instanceof String);
        assertTrue("Employer Object is not correct Object Type",job.getEmployer().getClass() == Employer.class);
        assertTrue("Location Object is not correct Object Type",job.getLocation().getClass() == Location.class);
        assertTrue("PositionType Object is not correct Object Type",job.getPositionType().getClass() == PositionType.class);
        assertTrue("CoreCompetency Object is not correct Object Type",job.getCoreCompetency().getClass() == CoreCompetency.class);
        assertEquals("Name not correct value", job.getName(), "Product tester");
        assertEquals("Employer value not correct", job.getEmployer().getValue(), "ACME");
        assertEquals("Location value not correct", job.getLocation().getValue(), "Desert");
        assertEquals("PositionType value not correct", job.getPositionType().getValue(), "Quality control");
        assertEquals("CoreCompetency value not correct", job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue("Objects show as equal, ruh roh",!job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String firstString = (job.toString().charAt(0) + String.valueOf(job.toString().charAt(1)));
        String lastString = (job.toString().charAt(job.toString().length() - 2) + String.valueOf(job.toString().charAt(job.toString().length()-1)));
        assertEquals("Error in first NewLine", System.lineSeparator(),firstString);
        assertEquals( "Error in last Newline",System.lineSeparator(),lastString);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(job.toString().contains("ID"));
        assertTrue(job.toString().contains(Integer.toString(job.getId())));
        assertTrue(job.toString().contains("Name"));
        assertTrue(job.toString().contains(job.getName()));
        assertTrue(job.toString().contains("Employer"));
        assertTrue(job.toString().contains(job.getEmployer().toString()));
        assertTrue(job.toString().contains("Location"));
        assertTrue(job.toString().contains(job.getLocation().toString()));
        assertTrue(job.toString().contains("Position Type"));
        assertTrue(job.toString().contains(job.getPositionType().toString()));
        assertTrue(job.toString().contains("Core Competency"));
        assertTrue(job.toString().contains(job.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobEmpty = new Job("", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));
        Job jobName = new Job("", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobEmployer = new Job("Product tester", new Employer(""),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobLocation = new Job("Product tester", new Employer("ACME"),
                new Location(""), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobPositionType = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType(""),
                new CoreCompetency("Persistence"));
        Job jobCoreCompetency = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.", jobEmpty.toString());
        assertTrue(jobName.toString().contains("Data not available"));
        assertTrue(jobEmployer.toString().contains("Data not available"));
        assertTrue(jobLocation.toString().contains("Data not available"));
        assertTrue(jobPositionType.toString().contains("Data not available"));
        assertTrue(jobCoreCompetency.toString().contains("Data not available"));
    }

    //TODO: Create your unit tests here
}
