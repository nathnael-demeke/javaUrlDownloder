import java.awt.Color;

import java.lang.Thread;
import javax.swing.*;
import java.io.InputStream;
import java.net.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class downloader implements ActionListener{
    private String url;
    private String fileName;
    JButton downloadButton;
    JTextField urlTextField;
    JTextField fileDestination;
    JPanel statusPanel;
    JLabel statusText;
    
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
        statusText = new JLabel();
        urlTextField = new JTextField();
        fileDestination = new JTextField();
        downloadButton = new JButton();
        statusPanel = new JPanel();


        statusPanel.setBounds(15 , 120 , 500 ,100);
        
        downloadButton.setBounds(15,100,100,20);
        urlTextField.setBounds(10,0,200,40);
        fileDestination.setBounds(10, 50, 200, 40);

        downloadButton.setText("Download");
        statusPanel.setForeground(Color.white);
       
        downloadButton.setFocusable(false);
        downloadButton.setBackground(Color.black);

        downloadButton.addActionListener(this);
        downloadButton.setForeground(Color.white);
        urlTextField.setText("URL");
        fileDestination.setText("Path");
        
        
       
        
        window.add(urlTextField);
       
        window.add(statusPanel);
        statusPanel.add(statusText);
        window.add(downloadButton);
        window.add(fileDestination);
        statusPanel.setVisible(true);
        window.setSize(500,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setResizable(false);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == downloadButton) {
           
             this.url = urlTextField.getText();
             this.fileName = fileDestination.getText();
             statusText.setText("hey");
             
             try {
              
             statusText.setForeground(Color.black);
                System.out.println("downloading...");
                
                URI link = new URI(url);
                URL linkURL = link.toURL();
                System.out.println(fileName);
                InputStream in = linkURL.openStream();
                Files.copy(in, Paths.get(fileName));
                
            } catch (Exception e1) {
                // TODO Auto-generated catch block
               e1.getMessage();
               System.out.println("there is a problem with this app");
               statusText.setText("file was not downlaoded");
               statusText.setForeground(Color.red);
            } 
           
                System.out.println("finished downloading " + fileName);
            urlTextField.setText("");
            fileDestination.setText("");
            statusText.setText(fileName + " was downloaded succesfully...");
            statusText.setForeground(Color.green);
          


             
       }
    }
    
    public void setFileName(String nameOfTheFile) {
        this.fileName = nameOfTheFile;
    }
    public void setUrl(String urlText) {
         this.url = urlText;
         
    }
    
    public static void main(String[] args) {
        downloader app = new downloader();
        // app.setUrl("https://ia801006.us.archive.org/13/items/OceanofPDF.comTheAlchemist/_OceanofPDF.com_The_Alchemist.pdf");
        // app.setFileName("The Alchemist.pdf");
        app.start();
    }
   
    
}