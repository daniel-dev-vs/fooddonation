package org.foodbank.fooddonation.core.usecase.product.dto;

import java.time.LocalDateTime;

public record GetProductOutput(Long id, String name, String unity, LocalDateTime createAt) {
}
