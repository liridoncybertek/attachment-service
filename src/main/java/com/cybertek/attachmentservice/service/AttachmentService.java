package com.cybertek.attachmentservice.service;

import com.cybertek.attachmentservice.domain.entity.Attachment;
import com.cybertek.attachmentservice.domain.enums.AttachmentType;

import java.util.List;

public interface AttachmentService {

    Attachment create(Attachment attachment);

    List<Attachment> readByRelatedIdAndRelatedToAndType(Integer relatedId, String relatedTo, AttachmentType type);

    List<Attachment> readByRelatedIdAndRelatedTo(Integer relatedId, String relatedTo);

    void deleteByUrl(String url);

}
