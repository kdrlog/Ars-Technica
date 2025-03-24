package net.mcreator.ars_technica.ponder;


import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.mcreator.ars_technica.ArsTechnicaMod;
import net.mcreator.ars_technica.setup.ItemsRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.registries.RegistryObject;


public class ArsTechnicaPonderScenes {
    public static final ResourceLocation ArsTechnica = ArsTechnicaMod.genRL("ars-technica");
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ArsTechnicaMod.MODID);
    public static void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {

        PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
        RegistryObject<BlockItem> sourceEngineRegistryObject = ItemsRegistry.SOURCE_ENGINE;
        HELPER.registerTag(ArsTechnica).
                addToIndex().
                item(new ItemProviderWrapper(REGISTRATE, sourceEngineRegistryObject), true, false).
                title("Test").
                description("Test Description")
                .register();

        HELPER.addToTag(AllCreatePonderTags.KINETIC_SOURCES)
                .add(new ItemProviderWrapper(REGISTRATE, sourceEngineRegistryObject));

        HELPER.addToTag(ArsTechnica)
                .add(new ItemProviderWrapper(REGISTRATE, sourceEngineRegistryObject));
    }

    public static void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
        RegistryObject<BlockItem> sourceEngineRegistryObject = ItemsRegistry.SOURCE_ENGINE;
        HELPER.forComponents(new ItemProviderWrapper(REGISTRATE, sourceEngineRegistryObject))
                .addStoryBoard("source_motor", SourceEngineScenes::usage, AllCreatePonderTags.KINETIC_SOURCES, ArsTechnica);
    }
}