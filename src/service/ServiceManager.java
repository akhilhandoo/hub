package service;

import service.file.IOEndPoint;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akhil on 11/3/14.
 */
public class ServiceManager {

    private static HashMap<String, Object> instanceMap = new HashMap<String, Object>();

    protected static Object getInstance(Class clazz) {
        if (instanceMap.containsKey(clazz.getCanonicalName()))
            return instanceMap.get(clazz.getCanonicalName());
        else {
            try {
                synchronized (ServiceManager.class) {
                    Object ob = clazz.newInstance();
                    instanceMap.put(clazz.getCanonicalName(), ob);
                    return ob;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    protected ServiceManager() {
    }
}

/*class VoiceServiceManager extends ServiceManager {

    public static VoiceServiceManager getInstance() {
        return (VoiceServiceManager)ServiceManager.getInstance(VoiceServiceManager.class);
    }
    private VoiceServiceManager() {
    }
}

class DataServiceManager extends ServiceManager {
    public static DataServiceManager getInstance() {
        return (DataServiceManager)ServiceManager.getInstance(DataServiceManager.class);
    }
    private DataServiceManager() {
    }
}*/
