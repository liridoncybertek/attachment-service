package com.cybertek.attachmentservice.domain.entity;

import com.cybertek.attachmentservice.domain.enums.AttachmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private AttachmentType type;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "related_to", nullable = false)
    private String relatedTo;

    @Column(name = "related_id", nullable = false)
    private Integer relatedId;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(nullable = false)
    private String url;

    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;
}
