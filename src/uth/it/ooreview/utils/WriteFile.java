package uth.it.ooreview.utils;

import java.io.PrintWriter;
import java.util.List;

public class WriteFile<T> {
    private List<T> content;

    public WriteFile() {
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void writeListToFile(String filePath) {
        String dir = System.getProperty("user.dir") + "src\\uth\\it\\ooreview\\store";
        String path = dir + filePath;
        try {
            PrintWriter pr = new PrintWriter(path);
            for (Object v : this.content) {
                pr.println(v);
            }
            pr.close();
            System.out.println("Write to file " + path + " successfully");
        } catch (Exception e) {
            System.out.println("Write to file failed!");
        }
    }
}

