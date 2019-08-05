package net.jogeum.multitxtest.service;

import lombok.extern.slf4j.Slf4j;
import net.jogeum.multitxtest.MultiTxTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MultiTxTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCodeServiceTest {

    @Autowired
    TestCodeService testCodeService;

    @Test
    public void saveTestCode() {
        try {
            testCodeService.saveTestCode();
        } catch (Exception e) {
        }

        assertTrue(testCodeService.getTestCode1("first").isPresent());
        assertTrue(testCodeService.getTestCode2("first").isPresent());
    }

    @Test
    public void rollbackTestCode() {
        try {
            testCodeService.rollbackTestCode();
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        assertFalse(testCodeService.getTestCode1("second").isPresent());
        assertFalse(testCodeService.getTestCode2("second").isPresent());
    }
}