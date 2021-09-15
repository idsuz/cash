package uz.mybux.cash.config;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created",updatable = false)
    private Date created;
    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @LastModifiedDate
    @Column(name = "updated",insertable = false)
    private Date updated;
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status=Status.ACTIVE;


}