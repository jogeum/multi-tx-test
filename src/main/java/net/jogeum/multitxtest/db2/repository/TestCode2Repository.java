package net.jogeum.multitxtest.db2.repository;

import net.jogeum.multitxtest.db2.domain.TestCode2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCode2Repository extends JpaRepository<TestCode2, String> {
}
