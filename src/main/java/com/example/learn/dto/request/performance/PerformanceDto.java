package com.example.learn.dto.request.performance;

import java.util.List;

public record PerformanceDto(
        Long eventId,
        String datetime,
        Long roomId,
        List<PriceDto> prices
) { }
