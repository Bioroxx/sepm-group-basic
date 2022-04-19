package com.example.learn.dto.post.performance;

import java.util.List;

public record PerformanceDto(
        String datetime,
        Long roomId,
        List<PriceDto> prices
) { }
