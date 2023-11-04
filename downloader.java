import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class downloadFromUrl {
    public downloadFromUrl(String url, String fileNameString) {
        try {
            URI uri = new URI(url);
            URL fileLink = uri.toURL();

            InputStream in = fileLink.openStream();
            // FileOutputStream downloadedFile = new FileOutputStream(fileNameString);
            int len;
            Files.copy(in, Paths.get(fileNameString.toString()));
            // byte[] bytes = new byte[1024];
            // while ((len = in.read(bytes)) != -1) {
            //     downloadedFile.write(bytes);
            // }
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
     
    }
    public static void main(String[] args) {
        downloadFromUrl app = new downloadFromUrl("https://th.bing.com/th/id/R.48d98b81a5d9a0ab3c99b630183c48aa?rik=NrPHhZ5F0IaKRg&pid=ImgRaw&r=0", "ai.png");
    }
    
}