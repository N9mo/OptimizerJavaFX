package optimizer.Controller;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.util.HashMap;

public class StorageController {
    public static HashMap run () throws IOException {
        HashMap<Integer, Pair<String, Pair<Long,Long>>> resulStorageMap = new HashMap<Integer, Pair<String, Pair<Long,Long>>>();
        int counter = 0;
        for (FileStore store : FileSystems.getDefault().getFileStores()) {
            long total = store.getTotalSpace() / 1048576;
            long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1048576;
            long avail = store.getUsableSpace() / 1048576;
            //The if statement eliminates any stores that have 0 total bytes of storage
            if(total!=0) {
                //System.out.format("%-20s %12d %12d %12d%n", store, total, used, avail);
                double percentage = (used/total)*100;
                //System.out.println(used);
                //System.out.println(total);
                //System.out.println(percentage+"% has been used");
            }
            counter++;
            Pair <Long, Long> storageValue = new Pair<>(total, used);
            Pair <String, Pair<Long,Long>> storageInfo = new Pair<>(store.toString(), storageValue);
            resulStorageMap.put(counter, storageInfo);
            //System.out.println(resulStorageMap);
        }
        return resulStorageMap;
    }
}