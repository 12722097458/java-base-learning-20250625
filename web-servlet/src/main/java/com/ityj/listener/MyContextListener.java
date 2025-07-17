package com.ityj.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener("/helloServlet")
public class MyContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyContextListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyContextListener contextDestroyed");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("MyContextListener attributeAdded  " + scae.getName() + "  " + scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeRemoved(scae);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeReplaced(scae);
    }


}
