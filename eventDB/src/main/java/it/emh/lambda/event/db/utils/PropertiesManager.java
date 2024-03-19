package it.emh.lambda.event.db.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static PropertiesManager _instance = null;
    private static Properties prop = new Properties();

    /**
     * Costruttore privato
     *
     * @throws Exception eccezione lanciata in caso di problemi di inizializzazione proprites
     */
    private PropertiesManager() throws Exception {
        ClassLoader classLoader = PropertiesManager.class.getClassLoader();
        try {
            InputStream is = classLoader.getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(is);
            PropertiesManager.prop = prop;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Metodo sincronizzato per accedere ad un istanza di classe
     *
     * @return an instance
     * @throws Exception quest'eccezione viene lanciata in caso di errore di reperimento file di properties
     */
    public static synchronized PropertiesManager getInstance() throws Exception {
        if (_instance == null) {
            _instance = new PropertiesManager();
        }

        return _instance;
    }

    /**
     * Metodo per prendere un valore da file di properties
     *
     * @param echiave Enum delle chiavi file di proprietà
     * @return valore
     */
    public synchronized String getProperties(EProperties echiave){
        return prop.getProperty(echiave.getChiave());
    }
}
