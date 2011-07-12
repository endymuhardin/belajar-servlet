package me.agung.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener 
{	
	private static Map<String, String> loginUser = new HashMap<String, String>();
	
    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sess) {    
    	// leave empty
    }
    
    public static void addLoginUser(String username, HttpSession session)
    {
    	loginUser.put(session.getId(), username);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent sess) 
    {
    	removeLoginUser(sess.getSession().getId());
    }
    
    public void removeLoginUser(String sessId)
    {
    	loginUser.remove(sessId);
    }
    
    public static boolean isUserLogin(String name)
    {
    	for(String sessId : loginUser.keySet()) 
    	{
    		if(loginUser.get(sessId).equalsIgnoreCase(name)) return true;
    	}
    	return false;
    }
	
}
