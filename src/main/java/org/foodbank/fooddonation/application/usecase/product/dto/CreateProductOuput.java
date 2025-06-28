package org.foodbank.fooddonation.application.usecase.product.dto;

import java.time.LocalDateTime;

public record CreateProductOuput(Long id, String name, String Unity, LocalDateTime createAt) {
}
