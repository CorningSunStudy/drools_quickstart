package com.corning.drools.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {

    public void save(String name) {
        log.info("UserService.save({})", name);
    }

}
