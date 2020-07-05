# WorldTypeFixer
allow custom world types to be added


in the main initialzer:

`		WorldTypeRegistry.registerLevelType(<WorldType_Id>,<GeneratorOptionsSupplier(seed,properties)>);`

 - This is used to provide level type data to worlds being generated/loaded with the level-type setting.

in the client initializer:

`WorldTypeRegistry.registerWorldType(<WorldType_Id>, constructor/supplier for CustomGeneratorType);`
 - This provides the world type to the options screen on the single player new-game menu
 
for client implementations:
extend CustomGeneratorType 
```
@Override
    protected ChunkGenerator method_29076(long seed) { }
```
this is the chunk generator supplier you need to override for your world type.  This information is provided by levelType above as part of GeneratorOptions for server implementations.
