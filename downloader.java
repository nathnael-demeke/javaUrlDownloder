import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class downloadFromUrl {
    private String url;
    private String fileName;
    public void start() {
        try {
            URI uri = new URI(url);
            URL fileLink = uri.toURL();

            InputStream in = fileLink.openStream();
            // FileOutputStream downloadedFile = new FileOutputStream(fileNameString);
            int len;
            Files.copy(in, Paths.get(fileName.toString()));
            // byte[] bytes = new byte[1024];
            // while ((len = in.read(bytes)) != -1) {
            //     downloadedFile.write(bytes);
            // }
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
     
    }
    public void setUrl(String urlText) {
         this.url = urlText;
         System.out.println(this.fileName);
    }
    
    public void setFileName(String nameOfTheFile) {
        this.fileName = nameOfTheFile;
    }
    public static void main(String[] args) {
        downloadFromUrl app = new downloadFromUrl();
        app.setUrl("https://ia801006.us.archive.org/13/items/OceanofPDF.comTheAlchemist/_OceanofPDF.com_The_Alchemist.pdf");
        app.setFileName("The Alchemist.pdf");
        app.start();
    }
    
}