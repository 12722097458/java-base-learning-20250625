package com.ityj.space.service;

import com.ityj.space.property.SpaceProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class SpaceService {

    @Autowired
    private SpaceProperties spaceProperties;


    public String launch() {
        return spaceProperties.getName() + " launched successfully!";
    }

}
