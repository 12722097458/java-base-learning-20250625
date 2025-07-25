package com.ityj.space.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "space")
@Data
public class SpaceProperties {
    private String name;
}
