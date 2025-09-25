package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.CustomerBookAudit;

@Repository
public interface CustomerBookAuditRepository extends JpaRepository<CustomerBookAudit, Long> {

    List<CustomerBookAudit> findByBookId(Long id);

    List<CustomerBookAudit> findByCategory(String category);

}
