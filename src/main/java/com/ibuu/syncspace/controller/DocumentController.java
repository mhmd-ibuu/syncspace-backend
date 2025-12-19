package com.ibuu.syncspace.controller;

import com.ibuu.syncspace.model.Document;
import com.ibuu.syncspace.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "*") // Allow React to talk to this later
public class DocumentController {

    @Autowired
    private DocumentService service;

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
        return ResponseEntity.ok(service.createDocument(document));
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(service.getAllDocuments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDocumentById(id));
    }

    // Add this at the top of DocumentController
    @GetMapping("/")
    public String home() {
        return "SyncSpace Backend is Running! 🚀";
    }
}