/*
 * $Header: /cvsroot/mvnforum/myvietnam/src/net/myvietnam/mvncore/security/FloodControl.java,v 1.15 2008/05/29 17:43:42 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.15 $
 * $Date: 2008/05/29 17:43:42 $
 *
 * ====================================================================
 *
 * Copyright (C) 2002-2007 by MyVietnam.net
 *
 * All copyright notices regarding MyVietnam and MyVietnam CoreLib
 * MUST remain intact in the scripts and source code.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Correspondence and Marketing Questions can be sent to:
 * info at MyVietnam net
 *
 * @author: Minh Nguyen  
 * @author: Mai  Nguyen  
 */
package net.myvietnam.mvncore.security;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.myvietnam.mvncore.exception.FloodException;
import net.myvietnam.mvncore.util.DateUtil;

/**
 * This class is used to control the number of actions per hour. This is usually
 * used to prevent the flood of any action. You should call FloodControl.setOption()
 * when your application is inited.
 * <p>
 * Note that the action id from 0 to 999 is belong to mvnCore, application used it
 * should not use the value in this range
 */
public class FloodControl {

    private static final Log log = LogFactory.getLog(FloodControl.class);

    /** The value from 0 to 999 should belong to mvnCore */
    public static final int MAX_MVNCORE_ACTION_ID = 999;

    public static final long REMOVE_INTERVAL = DateUtil.MINUTE * 2;//2 minutes

    private static Map actionControlMap = new TreeMap();

    private FloodControl() {
    }

    /**
     * To set the maximum number of actions per hour for an action.
     * If the caller does not call this method, the the action has no limit
     * @param action Integer the action that want to set the option
     * @param actionsPerHour int the maximum number of actions per hour
     */
    public static void setOption(Integer action, int actionsPerHour) {
        getControlledAction(action).setActionsPerHour(actionsPerHour);
    }

    public static int getActionsPerHour(Integer action) {
        return getControlledAction(action).getActionsPerHour();
    }

    /**
     * Check that an action of an IP has reach the maximum number of allowed times
     * @param action Integer the action to check
     * @param strIP String the IP to check
     * @return boolean true if it has reached the maximum
     */
    public static boolean reachMaximum(Integer action, String strIP) {
        return getControlledAction(action).reachMaximum(strIP);
    }

    /**
     * This is a utility method to ensure that the action has not reached the maximum.
     * It calls the method reachMaximum and throw an exception if it reached the maximum.
     * A program could use this method to use the default error message, otherwise
     * it has to use reachMaximum
     * @param action Integer the action to ensure
     * @param strIP String the IP to ensure
     * @throws FloodException if it reached the maximum
     * @see FloodControl#reachMaximum(Integer, String)
     */
    public static void ensureNotReachMaximum(Integer action, String strIP) throws FloodException {
        if (reachMaximum(action, strIP)) {
            log.info("Attempt to exceed the maximum number of actions: ActionID = " + action + " and IP = " + strIP);
            //@todo : localize me
            throw new FloodException("You have reached the maximum number of actions for this page (actionID = " + action + "). Please try this page later. This is to prevent forum from being flooded.");
        }
    }

    /**
     * Increase the number of action. This method should be called the the program
     * has done this action. Forget to call this method will void the reachMaximum method.
     * @param action Integer the action to increase the number of times
     * @param strIP String the IP to increase the number of times
     */
    public static void increaseCount(Integer action, String strIP) {
        getControlledAction(action).increaseCount(strIP);
    }

    /**
     * Reset the action history. This method is useful in such a case in the login
     * process that after login successfully, the value should be reset. Please note
     * that this is just an example and usually no need to use this method.
     * @param action Integer
     * @param strIP String
     */
    public static void resetActionHistory(Integer action, String strIP) {
        getControlledAction(action).resetActionHistory(strIP);
    }

    /**
     * Return the instance of ControlledAction for the action. It will create
     * new instance if no previous instance for this action exist.
     * @param action Integer
     * @return ControlledAction
     */
    private static synchronized ControlledAction getControlledAction(Integer action) {
        ControlledAction controlledAction = (ControlledAction)actionControlMap.get(action);
        if (controlledAction == null) {
            controlledAction = new ControlledAction();
            actionControlMap.put(action, controlledAction);
        }
        return controlledAction;
    }
}

/**
 * For one action that handles a list of all IP
 */
class ControlledAction {
    
    private int actionsPerHour = 0;
    private Map ipMap = new TreeMap();
    private long lastRemoveTime = 0;

    void setActionsPerHour(int actionsPerHour) {
        if (actionsPerHour >= 0) {
            this.actionsPerHour = actionsPerHour;
        }
    }

    int getActionsPerHour() {
        return actionsPerHour;
    }

    boolean reachMaximum(String strIP) {
        removeTimeoutControlledIP();
        return getControlledIP(strIP).reachMaximum();
    }

    void increaseCount(String strIP) {
        removeTimeoutControlledIP();
        getControlledIP(strIP).increaseCount();
    }

    void resetActionHistory(String strIP) {
        removeTimeoutControlledIP();
        getControlledIP(strIP).resetActionHistory();
    }

    private synchronized ControlledIP getControlledIP(String strIP) {
        ControlledIP controlledIP = (ControlledIP)ipMap.get(strIP);
        if (controlledIP == null) {
            controlledIP = new ControlledIP(actionsPerHour);
            ipMap.put(strIP, controlledIP);
        } else {
            // there is a ControlledIP, update the actionsPerHour
            controlledIP.setActionsPerHour(actionsPerHour);
        }
        return controlledIP;
    }

    private synchronized void removeTimeoutControlledIP() {
        long now = System.currentTimeMillis();
        if ((now - lastRemoveTime) > FloodControl.REMOVE_INTERVAL) {
            lastRemoveTime = now;
            Collection ipList = ipMap.values();
            for (Iterator iter = ipList.iterator(); iter.hasNext(); ) {
                ControlledIP currentControlledIP = (ControlledIP)iter.next();
                if (now - currentControlledIP.getLastIncrementTime() > DateUtil.HOUR) {
                    iter.remove();
                }
            }
        }
    }
}

/**
 * For one action per one IP
 */
class ControlledIP {
    private int actionsPerHour = 0;
    private long lastRemoveTime = 0;
    private long lastIncrementTime = 0;
    private ArrayList actionHistoryList = new ArrayList();

    ControlledIP(int actionsPerHour) {
        if (actionsPerHour >= 0) {
            this.actionsPerHour = actionsPerHour;
        }
    }

    void setActionsPerHour(int actionsPerHour) {
        if (actionsPerHour >= 0) {
            this.actionsPerHour = actionsPerHour;
        }
    }

    long getLastIncrementTime() {
        return lastIncrementTime;
    }

    void increaseCount() {
        long now = System.currentTimeMillis();
        lastIncrementTime = now;
        actionHistoryList.add(new Long(now));
    }

    void resetActionHistory() {
        lastRemoveTime = 0;
        lastIncrementTime = 0;
        actionHistoryList.clear();
    }

    boolean reachMaximum() {
        if (actionsPerHour == 0) {//unlimited
            return false;
        }

        if (actionHistoryList.size() < actionsPerHour) {
            return false;
        }

        // now try to remove timeout actions
        removeTimeoutActions();

        return (actionHistoryList.size() >= actionsPerHour);
    }

    private synchronized void removeTimeoutActions() {
        long now = System.currentTimeMillis();
        if (now - lastRemoveTime > FloodControl.REMOVE_INTERVAL) {
            lastRemoveTime = now;
            for (Iterator iter = actionHistoryList.iterator(); iter.hasNext(); ) {
                Long currentAction = (Long)iter.next();
                if ((now - currentAction.longValue()) > DateUtil.HOUR) {
                    iter.remove();
                }
            } //for
        }
    }
}
