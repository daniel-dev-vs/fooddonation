package org.foodbank.fooddonation.frameworksandrivers.product.api.request;

import java.time.LocalDateTime;

public record GetProductResponse(Long id, String name, String unity, LocalDateTime createAt) {
}
