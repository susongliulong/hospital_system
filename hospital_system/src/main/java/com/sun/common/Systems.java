package com.sun.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@Component
public class Systems {
    private long id;
    private String regionId;
    private String accessKeyId;
    private String secret;
    private String templateCode;

}
