package liquibase.changelog;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * To improve performance when calculating checksums for large changelogs and
 * changelogs that have many external files, do the checksum calculations
 * on many threads at the same time. 
 * 
 */
public class ThreadedChecksumGenerator {

  public void generateChecksums(List<ChangeSet> changeSets) {

    int nThreads = Runtime.getRuntime().availableProcessors();
    ExecutorService exec = Executors.newFixedThreadPool(nThreads);

    for (final ChangeSet changeSet : changeSets) {
      exec.submit(new Runnable() {
        @Override
        public void run() {
          changeSet.generateCheckSum();
        }
      });
    }
    exec.shutdown();
  }

}
