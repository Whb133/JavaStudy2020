package ioPractice.lib;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilTest {
    public static void main(String[] args) {

        try {
            FileUtils.copyFile(new File("hello.txt"),new File("test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
