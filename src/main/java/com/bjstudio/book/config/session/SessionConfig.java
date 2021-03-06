package com.bjstudio.book.config.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * SessionConfig
 */
@EnableRedisHttpSession
@Configuration
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

    
}