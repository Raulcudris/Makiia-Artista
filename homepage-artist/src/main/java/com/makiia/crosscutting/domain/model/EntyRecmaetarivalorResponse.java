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
    private  String rspValue ="OK";
    private  String rspMessage ="OK";
    private  List<PaginationResponse> rspPagination;
    private  List<EntyRecmaetarivalorDto> rspData;
    //private String nextPageUrl;
    //private String previousPageUrl;

    //"currentPage": 1,
    //"totalPageSize": 3,
    //"totalResults": 3,
    //"totalPages": 1,
    //"hasNextPage": false,
    //"hasPreviousPage": false,
    //"nextPageUrl": "https://localhost:44354/api/EdtArtPrice",
    //"previousPageUrl": "https://localhost:44354/api/EdtArtPrice"
}

