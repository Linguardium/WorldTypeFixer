package mod.linguardium.wtflib;

import com.mojang.datafixers.util.Function3;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.world.gen.GeneratorOptions;
import org.apache.logging.log4j.Level;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static mod.linguardium.wtflib.Main.log;


public class WorldTypeRegistry {
    public static HashMap<String, BiFunction<Long, Properties, GeneratorOptions>> levelTypes = new HashMap<>();
    @Environment(EnvType.CLIENT)
    public  static <T extends CustomGeneratorType> void registerWorldType(String translationKey, Function<String, T> generatorSupplier) {
        if (GeneratorType.VALUES.stream().noneMatch(value->value.getTranslationKey().toString().equalsIgnoreCase(translationKey))) {
            GeneratorType.VALUES.add(generatorSupplier.apply(translationKey));
            log(Level.INFO, "Registered World Type: " + translationKey);
        }else {
            log(Level.ERROR, "Attempted to register a duplicate World Type: " + translationKey);

        }
    }
    public static void registerLevelType(String translationKey, BiFunction<Long, Properties, GeneratorOptions> optionSupplier) {
        if (!levelTypes.containsKey(translationKey)) {
            levelTypes.put(translationKey, optionSupplier);
        }else{
            log(Level.WARN, "Attempted to register a duplicate level type: " + translationKey);
        }
    }

}
