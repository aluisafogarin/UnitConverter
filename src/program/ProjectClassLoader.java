package program;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * Custom ClassLoader to load classes dynamic.
 * 
 */
public class ProjectClassLoader extends ClassLoader{

    /**
     * Class constructor
     * 
     * @param parent
     */
    public ProjectClassLoader(ClassLoader parent) {
        super(parent);
    }

    
    /** 
     * Load every class when it's called.
     * 
     * @param name Name of the class
     * @param path Path to .class file
     * @return Class Control return
     * @throws ClassNotFoundException  In case dynamic class loader don't find a class.
     */
    public Class loadClass(String name, String path) throws ClassNotFoundException {
        //String sep = System.getProperty("file.separator");
        String url = "file:" + path;
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

