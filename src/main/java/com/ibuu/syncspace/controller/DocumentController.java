package com.ibuu.syncspace.controller;

import com.ibuu.syncspace.model.Document;
import com.ibuu.syncspace.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // <--- NUCLEAR FIX: Allows ALL websites (Vercel, Localhost, etc.)
public class DocumentController {

    @Autowired
    private DocumentService service;

    // --- FIX 1: THE HOME PAGE ---
    // This stops the "Whitelabel Error" and proves the server is alive.
    @GetMapping("/")
    public String home() {
        return "SyncSpace Backend is LIVE and RUNNING! 🚀";
    }

    // --- EXISTING FEATURES ---

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