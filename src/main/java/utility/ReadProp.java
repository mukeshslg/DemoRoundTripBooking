package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProp {

    private Properties prop;

    public  ReadProp(String path) {
        prop = new Properties();
        try {
            FileInputStream fs = new FileInputStream(path);
            prop.load(fs);
        }
        catch (Exception e) {
        }
    }

    /**
     *
     * @param key
     * @return
     * @author Mukesh
     */
    public String  getProperty(String key) {
        String value = prop.getProperty(key);
        return value;
    }


}
