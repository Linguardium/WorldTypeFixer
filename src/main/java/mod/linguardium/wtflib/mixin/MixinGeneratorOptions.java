package mod.linguardium.wtflib.mixin;

import com.google.common.base.MoreObjects;
import mod.linguardium.wtflib.WorldTypeGenerator;
import net.minecraft.world.gen.GeneratorOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Properties;
import java.util.Random;

import static mod.linguardium.wtflib.WorldTypeRegistry.levelTypes;

@Mixin(GeneratorOptions.class)
public class MixinGeneratorOptions {
    @Inject(method = "fromProperties", at = @At("HEAD"), cancellable = true)
    private static void injectWorldTypes(Properties properties, CallbackInfoReturnable<GeneratorOptions> cir) {
        String levelType = properties.get("level-type").toString().trim().toLowerCase();
        if (levelTypes.containsKey(levelType)) {
            String seed = (String) MoreObjects.firstNonNull(properties.get("level-seed"), "");
            long lSeed = new Random().nextLong();
            if (!seed.isEmpty()) {
                try {
                    long m = Long.parseLong(seed);
                    if (m != 0L) {
                        lSeed = m;
                    }
                } catch (NumberFormatException var14) {
                    lSeed = seed.hashCode();
                }
            }
            cir.setReturnValue(levelTypes.get(levelType).apply(lSeed,properties));
        }
    }
}
