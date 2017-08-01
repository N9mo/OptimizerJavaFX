package optimizer.Controller;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;

public class Storage {
    public static void run (String[] args) throws IOException {
        for (FileStore store : FileSystems.getDefault().getFileStores()) {
            long total = store.getTotalSpace() / 1024;
            long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
            long avail = store.getUsableSpace() / 1024;
            //The if statement eliminates any stores that have 0 total bytes of storage
            if(total!=0) {
                System.out.format("%-20s %12d %12d %12d%n", store, total, used, avail);
                double percentage = (used/total)*100;
                System.out.println(used);
                System.out.println(total);
                System.out.println(percentage+"% has been used");
            }
            //System.out.println(percentage);
        }
    }
}