package com.ibuu.syncspace.repository;

import com.ibuu.syncspace.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    // We can add custom queries here later, e.g., findByTitle(String title);
}
