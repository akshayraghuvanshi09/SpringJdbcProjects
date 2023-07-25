package com.jdbc_hurix.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Step {
    private String title;

    private String refId;
    private int kitabooId;

    private String levelOfSupport;

    private String packageId;

    private String type;
}
