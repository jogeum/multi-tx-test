package net.jogeum.multitxtest.service;

import net.jogeum.multitxtest.db1.domain.TestCode1;
import net.jogeum.multitxtest.db1.repository.TestCode1Repository;
import net.jogeum.multitxtest.db2.domain.TestCode2;
import net.jogeum.multitxtest.db2.repository.TestCode2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TestCodeService {

    @Autowired
    TestCode1Repository testCode1Repository;

    @Autowired
    TestCode2Repository testCode2Repository;

    @Transactional(rollbackFor = Exception.class)
    public void saveTestCode() {

        TestCode1 testCode1 = new TestCode1(
                "first",
                "db1 first"
        );

        testCode1Repository.save(testCode1);

        TestCode2 testCode2 = new TestCode2(
                "first",
                "db2 first"
        );

        testCode2Repository.save(testCode2);
    }

    @Transactional(rollbackFor = Exception.class)
    public void rollbackTestCode() {

        TestCode1 testCode1 = new TestCode1(
                "second",
                "db1 second"
        );

        testCode1Repository.save(testCode1);

        TestCode2 testCode2 = new TestCode2(
                "second",
                "db2 second"
        );

        testCode2Repository.save(testCode2);

        throw new RuntimeException("rollback");
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<TestCode1> getTestCode1(String code) {
        return testCode1Repository.findById(code);
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<TestCode2> getTestCode2(String code) {
        return testCode2Repository.findById(code);
    }
}
