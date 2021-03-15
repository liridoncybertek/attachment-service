package com.cybertek.attachmentservice.repository;

import com.cybertek.attachmentservice.domain.entity.Attachment;
import com.cybertek.attachmentservice.domain.enums.AttachmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    List<Attachment> findAllByRelatedIdAndRelatedTo(Integer relatedId, String relatedTo);

    List<Attachment> findAllByRelatedIdAndRelatedToAndType(Integer relatedId, String relatedTo, AttachmentType type);

    void deleteByUrl(String url);

}
