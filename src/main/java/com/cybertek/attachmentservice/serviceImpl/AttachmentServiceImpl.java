package com.cybertek.attachmentservice.serviceImpl;

import com.cybertek.attachmentservice.domain.entity.Attachment;
import com.cybertek.attachmentservice.domain.enums.AttachmentType;
import com.cybertek.attachmentservice.repository.AttachmentRepository;
import com.cybertek.attachmentservice.service.AttachmentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    @Transactional
    public Attachment create(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    public List<Attachment> readByRelatedIdAndRelatedToAndType(Integer relatedId, String relatedTo, AttachmentType type) {
        return attachmentRepository.findAllByRelatedIdAndRelatedToAndType(relatedId, relatedTo, type);
    }

    @Override
    public List<Attachment> readByRelatedIdAndRelatedTo(Integer relatedId, String relatedTo) {
        return attachmentRepository.findAllByRelatedIdAndRelatedTo(relatedId, relatedTo);
    }

    @Override
    @Transactional
    public void deleteByUrl(String url) {
        attachmentRepository.deleteByUrl(url);
    }
}
