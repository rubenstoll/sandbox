package io.crunchify.baeldung;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Test only work on windows. designed mostly for Pass-Starter
 */
@Ignore
public class FilesDirectoriesTest {

    private FilesDirectories filesDirectories;
    private String directoryToWalk;

    @Before
    public void setUp() throws Exception {

        this.filesDirectories = new FilesDirectories();
        this.directoryToWalk = Paths.get(System.getenv("LOCALAPPDATA"), "PassStarter", "passclients").toString();


    }

    @Ignore
    @Test
    public void listFilesUsingJavaIO() {
    }

    @Test
    public void listFilesUsingFileWalk() throws IOException {

        Set<String> foundFiles = filesDirectories.listFilesUsingFileWalk(this.directoryToWalk, 1);

        assertThat(foundFiles.size(), greaterThan(1));


    }

    @Test
    public void listFilesUsingFileWalkAndVisitor() throws IOException {

        Set<String> foundFiles = filesDirectories.listFilesUsingFileWalkAndVisitor(this.directoryToWalk);

        assertThat(foundFiles.size(), greaterThan(1));

    }


    @Test
    public void listFiles() {

        Map<String, Path> dirList = filesDirectories.fileList(this.directoryToWalk);

        assertThat(dirList.size(), greaterThan(1));

    }

    @Ignore
    @Test
    public void listFolders() {

        List<String> dirList = filesDirectories.listFolders(this.directoryToWalk);

        assertThat(dirList.size(), greaterThan(1));

    }
}