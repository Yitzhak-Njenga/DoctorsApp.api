package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.Doctor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

public class DoctorsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Doctor setUpDoc() {return new Doctor("Yitzhak",65,"Surgeon");}

    @Test
    public void getDocAge_doctorsAgeInstantiatesWithDoctorsAge_true(){
        assertEquals(65,setUpDoc().getAge());
    }

    @Test
    public void setDocName_true(){
        Doctor testDoc = setUpDoc();
        testDoc.setName("Yitzhak");
        assertNotEquals("Dr.Njenga",testDoc.getName());
    }

    @Test
    public void setDocSpecialist_true(){
        Doctor testDoc = setUpDoc();
        testDoc.setSpecialist("Surgeon");
        assertNotEquals("Physician",testDoc.getSpecialist());
    }


}
