package be.digitalycity.java.bxl_java24_stockmanagement.dl.entities;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.order.Order;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode @ToString
public class OrderLine {

    @EmbeddedId
    private OrderLineId id;

    @Column(nullable = false)
    @Min(0)
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("articleId")
    private Article article;

    public OrderLine(int quantity, Order order, Article article) {
        this.id = new OrderLineId(order.getId(), article.getId());
        this.quantity = quantity;
        this.order = order;
        this.article = article;
    }

    @Embeddable
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode @ToString
    public static class OrderLineId {

        private UUID orderId;
        private UUID articleId;
    }
}
