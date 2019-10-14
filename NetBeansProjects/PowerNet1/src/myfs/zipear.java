/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfs;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

/**
 *
 * @author root
 */
public class zipear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            // Create access to zip.
            FileSystemManager fsManager = VFS.getManager();
            FileObject zipFile = fsManager.resolveFile("file:/path/to/the/file.zip");
            zipFile.createFile();
            ZipOutputStream zos = new ZipOutputStream(zipFile.getContent().getOutputStream());
// add entry/-ies.
            ZipEntry zipEntry = new ZipEntry("name_inside_zip");
            FileObject entryFile = fsManager.resolveFile("file:/path/to/the/sourcefile.txt");
            InputStream is = entryFile.getContent().getInputStream();
// Write to zip.
            byte[] buf = new byte[1024];
            zos.putNextEntry(zipEntry);
            for (int readNum; (readNum = is.read(buf)) != -1;) {
                zos.write(buf, 0, readNum);
            }
        } catch (FileSystemException ex) {
            Logger.getLogger(zipear.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
