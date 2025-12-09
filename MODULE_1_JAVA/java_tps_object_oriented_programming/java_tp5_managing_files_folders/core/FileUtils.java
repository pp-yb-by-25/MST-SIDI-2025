package MODULE_1_JAVA.java_tps_object_oriented_programming.java_tp5_managing_files_folders.core;
import java.io.*;

public class FileUtils {
    
    public static boolean exists(String path)
    {
        return (new File(path)).exists();
    }
    


}
