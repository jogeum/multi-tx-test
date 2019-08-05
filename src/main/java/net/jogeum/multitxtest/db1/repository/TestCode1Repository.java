package net.jogeum.multitxtest.db1.repository;

import net.jogeum.multitxtest.db1.domain.TestCode1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCode1Repository extends JpaRepository<TestCode1, String> {
}
