package service;

import service.file.IOEndPoint;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhil on 13/3/14.
 */

class FileServiceManager extends ServiceManager {

    private static FileService fileService;
    private static FileServiceManager fileServiceManager;
    private boolean fileServiceSet = false;

    public static FileServiceManager getInstance(String fileName, int portNo) {
        fileServiceManager = (FileServiceManager)ServiceManager.getInstance(FileServiceManager.class);
        if (null == fileServiceManager.getFileService()) {
            fileServiceManager.setFileService(new FileService(new File(fileName), portNo));
        }
        return fileServiceManager;
    }
    private FileServiceManager() {
    }
    public FileService getFileService() {
        return fileService;
    }
    public void setFileService(FileService fileService) {
        if (!fileServiceSet) {
            this.fileService = fileService;
            fileServiceSet = true;
        }
    }


    public static class FileService extends Thread implements IGenericService {

        private List<BufferedIn> endPoints;
        private ServerSocket socket;
        private static File base;
        private static int maxFileSockets = 5;
        private int portNo;
        private boolean running;
        private boolean toBeStopped;

        private FileService(File base, int portNo) {
            this.base = base;
            endPoints = new ArrayList<IOEndPoint>();
            this.portNo = portNo;
            running = true;
            toBeStopped = false;
        }

        public void onStop() {

        }

        public void onStart() throws Exception {
            socket = new ServerSocket(portNo);
            running = true;
            this.start();
        }

        public void run() {
            while (running && !toBeStopped) {

            }
        }
    }
}