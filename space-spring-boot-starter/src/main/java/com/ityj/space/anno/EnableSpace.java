package com.ityj.space.anno;

import com.ityj.space.config.SpaceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SpaceAutoConfiguration.class)
@Documented
public @interface EnableSpace {
}
