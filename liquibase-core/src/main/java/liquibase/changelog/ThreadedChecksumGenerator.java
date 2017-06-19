package liquibase.changelog;

import java.util.List;

/**
 * To improve performance when calculating checksums for large changelogs and
 * changelogs that have many external files, do the checksum calculations
 * on many threads at the same time. 
 * 
 */
public class ThreadedChecksumGenerator {

  public void generateChecksums(List<ChangeSet> changeSets) {
    // naive implementation to get started with. Make sure it works. 
    for (ChangeSet changeSet : changeSets) {
      changeSet.generateCheckSum();
    }
  }

}
