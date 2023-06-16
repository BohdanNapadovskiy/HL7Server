package com.metagenics.plxHL7Server.service.amazon;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseChangeModel {
    private String type;
    private String action;
    private String createdBy;
}

