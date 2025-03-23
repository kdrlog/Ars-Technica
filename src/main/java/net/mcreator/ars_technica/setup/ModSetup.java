package net.mcreator.ars_technica.setup;

import net.mcreator.ars_technica.ArsTechnicaMod;
import net.mcreator.ars_technica.client.events.ModParticles;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModSetup {

  public static void registers(IEventBus modEventBus) {
    BlockRegistry.registerEventListeners(modEventBus);
    GlyphsRegistry.registerGlyphs();
    ItemsRegistry.registerEventListeners(modEventBus);
    CreativeTabRegistry.register(modEventBus);
    RecipeRegistry.register(modEventBus);
    EntityRegistry.register(modEventBus);
    ModParticles.PARTICLES.register(modEventBus);
  }
}
