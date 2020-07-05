package mod.linguardium.wtflib;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "wtflib";
    public static final String MOD_NAME = "WorldTypeFixer";

    @Override
    public void onInitialize() {
        log(Level.INFO, "[W]orld [T]ype [F]ixer initialized");
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}