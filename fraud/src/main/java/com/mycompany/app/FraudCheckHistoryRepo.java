package com.mycompany.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepo extends JpaRepository<FraudCheckHistory, Long> {

}
