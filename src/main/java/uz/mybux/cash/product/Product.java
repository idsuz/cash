package uz.mybux.cash.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import uz.mybux.cash.BaseEntity;
import uz.mybux.cash.config.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product{
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

    @Column(name = "name")
    public String name;
    @Column(name = "barcode")
    public String barCode;
    @Column(name = "label")
    public String label;
    @Column(name = "price")
    private Double price;
    @Column(name = "discount")
    public Double discount;
    @Column(name = "vat")
    public Double vat;
    @Column(name = "group_id")
    public Long groupId;
    @Column(name = "user_id")
    public Long user_id;
    @Column(name = "tin")
    public Long tin;
    @Column(name = "product_type")
    public Long productType;
    @Column(insertable = false,updatable = false)
    public String measureName;
    @OneToOne
    @JoinColumn(name = "product_type",insertable = false,updatable = false)
    private ProductType productTypeName;
    private String photo;

}
