package com.cybertek.attachmentservice.controller;

import com.cybertek.attachmentservice.domain.entity.Attachment;
import com.cybertek.attachmentservice.domain.enums.AttachmentType;
import com.cybertek.attachmentservice.service.AttachmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping
    public ResponseEntity<Attachment> save(@RequestBody Attachment attachment) {
        Attachment createdAttachment = attachmentService.create(attachment);

        return ResponseEntity.ok(createdAttachment);
    }

    @GetMapping
    public ResponseEntity<List<Attachment>> readByRelatedIdAndRelatedToOrType(@RequestParam Integer relatedId,
                                                                              @RequestParam String relatedTo,
                                                                              @RequestParam(required = false) AttachmentType type) {

        List<Attachment> attachments = type != null ?
                attachmentService.readByRelatedIdAndRelatedToAndType(relatedId, relatedTo, type) :
                attachmentService.readByRelatedIdAndRelatedTo(relatedId, relatedTo);

        return ResponseEntity.ok(attachments);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String url) {
        attachmentService.deleteByUrl(url);
        return ResponseEntity.ok().build();
    }
}
