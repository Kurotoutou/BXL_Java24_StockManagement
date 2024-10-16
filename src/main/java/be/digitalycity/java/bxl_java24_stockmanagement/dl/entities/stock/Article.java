package be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.BaseEntity;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.OrderLine;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.enums.VAT;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Article extends BaseEntity {

    @Column(nullable = false, length = 80)
    @Getter @Setter
    private String designation;

    @Column(nullable = false, length = 10)
    @Getter @Setter
    @Min(0L)
    private long unitPriceExcludingTax;

    @Column(nullable = false)
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private VAT vat;

    @Column(unique = true)
    @Getter @Setter
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Category category;

    @ManyToMany
    private final Set<StockMovement> movements = new HashSet<>();

    public Article(UUID id, String designation, long unitPriceExcludingTax, VAT vat, String picture, Stock stock, Category category) {
        super(id);
        this.designation = designation;
        this.unitPriceExcludingTax = unitPriceExcludingTax;
        this.vat = vat;
        this.picture = picture;
        this.category = category;
    }

    public long getUnitPriceIncludingTax() {
        return getUnitPriceExcludingTax() + getAddedValue();
    }

    public long getAddedValue() {
        BigDecimal vat = BigDecimal.valueOf(this.vat.value, 2);
        BigDecimal priceTTE = BigDecimal.valueOf(this.unitPriceExcludingTax, 2);
        BigDecimal addedValue = priceTTE.multiply(vat);
        return addedValue.setScale(0, RoundingMode.HALF_UP).longValue();
    }

    public Set<StockMovement> getMovements() {
        return Set.copyOf(movements);
    }

    public void addMovements(StockMovement stockMovement) {
        movements.add(stockMovement);
    }

    public void removeMovement(StockMovement movement) {
        movements.remove(movement);
    }
}
