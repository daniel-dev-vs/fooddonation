package org.foodbank.fooddonation.core.usecase.product.dto;

import java.time.LocalDateTime;

public record CreateProductOuput(Long id, String name, String unity, LocalDateTime createAt) {
}
