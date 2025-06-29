package org.foodbank.fooddonation.frameworksandrivers.product.api.request;

import java.time.LocalDateTime;

public record CreateProductResponse(Long id, String name, String unity, LocalDateTime LocalDateTime) {
}
