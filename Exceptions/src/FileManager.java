public class FileManager {

    private boolean loggedIn;
    //private File file;
    private File[] fileCabinet = new File[10];


    public void login(){
        loggedIn = true;
    }
    public void logout(){
        loggedIn = false;
    }

    public File getFile (String name) throws FileException {
        if(loggedIn){
            File file = null;
            for (int i = 0; i < fileCabinet.length; i++){
                if(name == fileCabinet[i].getName()){
                    file = fileCabinet[i];
                    return file;
                }
            }
            throw new FileNotFoundException();
        }
        throw new NotEnoughPermissionsException();
       // return file;
    }

    public void createFile (String name) throws FileException {
        if (loggedIn) {
            File file = new File(name);
            for (int i = 0; i < fileCabinet.length; i++) {
                if (fileCabinet[i] == null) {
                    fileCabinet[i] = file;
                    return;
                }
            }
            throw new NotEnoughSpaceException();
        }
        throw new NotEnoughPermissionsException();
    }
}
