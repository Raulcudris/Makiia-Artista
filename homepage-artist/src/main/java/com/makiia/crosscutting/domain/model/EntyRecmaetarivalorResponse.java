package com.makiia.crosscutting.domain.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntyRecmaetarivalorResponse {

    private int currentPage;
    private int totalPageSize;
    private long totalResults;
    private int totalPages;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private String nextPageUrl;
    private String previousPageUrl;
    private List<EntyRecmaetarivalorDto> rspData;

    //"currentPage": 1,
    //"totalPageSize": 3,
    //"totalResults": 3,
    //"totalPages": 1,
    //"hasNextPage": false,
    //"hasPreviousPage": false,
    //"nextPageUrl": "https://localhost:44354/api/EdtArtPrice",
    //"previousPageUrl": "https://localhost:44354/api/EdtArtPrice"
}
