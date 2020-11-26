package program;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class ProjectClassLoader extends ClassLoader{
    public ProjectClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name, String path) throws ClassNotFoundException {
        String sep = System.getProperty("file.separator");
        String url = "file:" + path;

        System.out.println("Estou em LoadClass (no ClassLoader), usando o name: " + name);
        System.out.println("Estou usando o url: " + path);
        //String url = "file:" + System.getProperty("user.dir") + sep + "UnitConverter" + sep + "bin" + sep + 
        //"converters" + sep  + "CentimetreConverter.class";

        if(!("converters." + name).equals(name))
            return super.loadClass(name);
        
            try {   
                URL myUrl = new URL(url);
                URLConnection connection = myUrl.openConnection();
                InputStream input = connection.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int data = input.read();

                while(data != -1) {
                    buffer.write(data);
                    data = input.read();
                }

                input.close();

                byte[] classData = buffer.toByteArray();

                return defineClass(("converters." + name), classData, 0, classData.length); 
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return null;
    }
}

