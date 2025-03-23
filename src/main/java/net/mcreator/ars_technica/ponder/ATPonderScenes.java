package net.mcreator.ars_technica.ponder;


import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.mcreator.ars_technica.ArsTechnicaMod;
import net.mcreator.ars_technica.setup.BlockRegistry;
import net.minecraft.resources.ResourceLocation;



public class ATPonderScenes {
    public static final ResourceLocation ATSource = ArsTechnicaMod.genRL("ars-technica");

    public static void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {

        PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
        HELPER.registerTag(ATSource).
                addToIndex().
                item(BlockRegistry.SOURCE_ENGINE.get(), true, false).
                title("Test").
                description("Test Description")
                .register();

        HELPER.addToTag(AllCreatePonderTags.KINETIC_SOURCES)
                .add(BlockRegistry.SOURCE_ENGINE);

        HELPER.addToTag(ATSource)
                .add(BlockRegistry.SOURCE_ENGINE);
    }

    public static void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.forComponents(BlockRegistry.SOURCE_ENGINE)
                .addStoryBoard("source_motor", SourceEngineScenes::usage, AllCreatePonderTags.KINETIC_SOURCES, ATSource);
    }
}