package com.airline.controllers;

import javax.servlet.ServletContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import com.airline.models.Passenger;;

/**
 * Application Lifecycle Listener implementation class AirlineListener
 *
 */
@WebListener
public class AirlineListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AirlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         ServletContext sc = event.getServletContext();
         ArrayList<Passenger> passengerList = (ArrayList<Passenger>) sc.getAttribute("passengers");
         if(passengerList == null) {
        	 System.out.println("No passengers in the list");
        	 sc.setAttribute("passengers", new ArrayList<Passenger>());
         }
    }
	
}
