package task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropOpener {
    static synchronized Properties getProperties(String propertiesName) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(propertiesName)) {
            properties.load(fileInputStream);
        }
        return properties;
    }
    public static void getValue(Properties properties, String key) throws KeyIsMissingException
    {
        if (properties.containsKey(key))
        {
            System.out.println(key + " : " + properties.getProperty(key));
        }
        else
        {
            throw new KeyIsMissingException("Ключ не найден!");
        }
    }
}