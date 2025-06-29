package org.foodbank.fooddonation.presentation.api.request.product;

import java.time.LocalDateTime;

public record GetProductResponse(Long id, String name, String unity, LocalDateTime createAt) {
}
