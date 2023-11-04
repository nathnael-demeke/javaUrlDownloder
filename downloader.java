import java.awt.Color;
import java.io.FileOutputStream;
import javax.swing.*;
import java.io.InputStream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class downloadFromUrl extends JFrame{
    private String url;
    private String fileName;
    
    public void start() {
        // try {
        //     URI uri = new URI(url);
        //     URL fileLink = uri.toURL();

        //     InputStream in = fileLink.openStream();
        //     // FileOutputStream downloadedFile = new FileOutputStream(fileNameString);
        //     int len;
        //     Files.copy(in, Paths.get(fileName.toString()));
        //     // byte[] bytes = new byte[1024];
        //     // while ((len = in.read(bytes)) != -1) {
        //     //     downloadedFile.write(bytes);
        //     // }
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.getMessage();
        // }
     
        JFrame window = new JFrame();
        window.setLayout(null);
        JTextField urlTextField = new JTextField();
        JTextField fileDestination = new JTextField();
        JButton downloadButton = new JButton();


        downloadButton.setBounds(10,100,100,20);
        urlTextField.setBounds(5,0,200,40);
        fileDestination.setBounds(5, 50, 200, 40);

        downloadButton.setText("Download");
        downloadButton.setBackground(Color.black);
        downloadButton.setForeground(Color.white);
        urlTextField.setText("URL");
        fileDestination.setText("Path");
       
        
        window.add(urlTextField);
        window.add(downloadButton);
        window.add(fileDestination);
        window.setSize(500,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
    }
    public void setUrl(String urlText) {
         this.url = urlText;
         
    }
    
    public void setFileName(String nameOfTheFile) {
        this.fileName = nameOfTheFile;
    }
    public static void main(String[] args) {
        downloadFromUrl app = new downloadFromUrl();
        // app.setUrl("https://ia801006.us.archive.org/13/items/OceanofPDF.comTheAlchemist/_OceanofPDF.com_The_Alchemist.pdf");
        // app.setFileName("The Alchemist.pdf");
        app.start();
    }
    
}