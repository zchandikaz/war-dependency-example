package org.example;

import org.apache.catalina.loader.WebappClassLoaderBase;

import java.util.logging.Logger;

/**
 * @author : chandika
 * @since : 2022-10-08(Sat) 14:43
 **/
public class ContextClassLoader extends WebappClassLoaderBase {
    private static final Logger LOGGER = Logger.getLogger(ContextClassLoader.class.getName());

    public ContextClassLoader(ClassLoader parent) {
        super(new ProxyClassLoader(parent));
    }

    @Override
    public ClassLoader copyWithoutTransformers() {
        return this;
    }
}
