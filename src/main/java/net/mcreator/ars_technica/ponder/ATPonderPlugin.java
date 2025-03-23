package net.mcreator.ars_technica.ponder;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.mcreator.ars_technica.ArsTechnicaMod;
import net.minecraft.resources.ResourceLocation;
import net.mcreator.ars_technica.ponder.ATPonderScenes;


public class ATPonderPlugin implements PonderPlugin {
    @Override
    public String getModId() {
        return ArsTechnicaMod.MODID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        ATPonderScenes.registerScenes(helper);
    }

    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        ATPonderScenes.registerTags(helper);
    }
}