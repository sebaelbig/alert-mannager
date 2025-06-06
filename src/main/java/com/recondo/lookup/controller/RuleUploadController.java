package com.recondo.lookup.controller;

import com.recondo.lookup.dto.RulePayload;
import com.recondo.lookup.service.RuleUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleUploadController {

    @Autowired
    private RuleUploadService ruleUploadService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadRules(@RequestParam("file") MultipartFile file) {
        try {
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            List<String> rules = ruleUploadService.extractRules(content);
            List<String> failedRules = ruleUploadService.processRules(rules);

            return ResponseEntity.ok("Uploaded " + (rules.size() - failedRules.size()) + "/" + rules.size() + " rules.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to read file.");
        }
    }
}
