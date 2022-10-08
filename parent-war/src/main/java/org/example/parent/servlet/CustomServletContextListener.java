package org.example.parent.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author : chandika
 * @since : 2022-10-08(Sat) 15:14
 **/
public class CustomServletContextListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(CustomServletContextListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.example.ProxyClassLoader").getMethod("setForeignClassLoader", ClassLoader.class).invoke(null, this.getClass().getClassLoader());
            LOGGER.log(Level.INFO, "Classloader registration success!", new Object[]{  });
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "ClassLoader registration failed!");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
