package com.ibuu.syncspace.service;

import com.ibuu.syncspace.model.Document;
import com.ibuu.syncspace.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repository;

    // --- LOGIC: Create if new, Update if exists ---
    public Document createDocument(Document document) {
        // 1. Check if the document has an ID (meaning it already exists)
        if (document.getId() != null && repository.existsById(document.getId())) {
            // 2. Fetch the existing doc
            Document existing = repository.findById(document.getId()).get();
            // 3. Update its fields
            existing.setTitle(document.getTitle());
            existing.setContent(document.getContent());
            // 4. Save the updates
            return repository.save(existing);
        }

        // If no ID, create a brand new one
        return repository.save(document);
    }

    public List<Document> getAllDocuments() {
        return repository.findAll();
    }

    public Document getDocumentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
    }

    public void deleteDocument(Long id) {
        repository.deleteById(id); // Changed 'repo' to 'repository'
    }
}