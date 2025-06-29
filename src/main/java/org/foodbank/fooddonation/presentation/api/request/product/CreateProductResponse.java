package org.foodbank.fooddonation.presentation.api.request.product;

import java.time.LocalDateTime;

public record CreateProductResponse(Long id, String name, String unity, LocalDateTime LocalDateTime) {
}
