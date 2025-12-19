package com.ibuu.syncspace.controller;

import com.ibuu.syncspace.model.Document;
import com.ibuu.syncspace.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// FIX: Change 'origins' to 'originPatterns' to fix the crash
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class DocumentController {

    @Autowired
    private DocumentService service;

    // This is the Home Page (stops the Whitelabel Error)
    @GetMapping("/")
    public String home() {
        return "SyncSpace Backend is LIVE and RUNNING! 🚀";
    }

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        return service.getAllDocuments();
    }

    @GetMapping("/documents/{id}")
    public Document getDocument(@PathVariable Long id) {
        return service.getDocumentById(id);
    }

    @PostMapping("/documents")
    public Document createDocument(@RequestBody Document document) {
        return service.createDocument(document);
    }
}