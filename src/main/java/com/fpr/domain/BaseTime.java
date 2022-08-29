package com.fpr.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    @Column(name = "createdAt")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "modifiedAt")
    @LastModifiedDate
    private LocalDate modifiedAt;

}
