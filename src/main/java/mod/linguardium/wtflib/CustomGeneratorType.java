package mod.linguardium.wtflib;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.world.GeneratorType;

public abstract class CustomGeneratorType extends GeneratorType {
    public CustomGeneratorType(String translationKey) {
        super(translationKey);
    }
}
