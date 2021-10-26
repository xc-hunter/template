package com.xc.standard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import java.time.Instant;

/**
 * 审计功能基类,其他实体类继承该类
 * 如果不起作用，建议在@Configuration类如主启动类上添加@EnableJpaAuditing
 */
@Data
@EntityListeners(value= AuditingEntityListener.class)
public  abstract class AbstractAuditBase {

    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    private Instant createdAt;

    @CreatedDate
    @JsonIgnore
    private Instant updatedAt;
}
