package net.mcreator.ars_technica.setup;

import com.hollingsworth.arsnouveau.common.items.ExperienceGem;
import com.hollingsworth.arsnouveau.common.items.ModItem;
import com.hollingsworth.arsnouveau.common.util.RegistryWrapper;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.mcreator.ars_technica.ArsTechnicaMod;
import net.mcreator.ars_technica.armor.IGoggleHelmet;
import net.mcreator.ars_technica.armor.TechnomancerArmor;
import net.mcreator.ars_technica.common.items.curios.TransmutationFocus;
import net.mcreator.ars_technica.common.items.equipment.RunicSpanner;
import net.mcreator.ars_technica.common.items.equipment.SpyMonocle;
import net.mcreator.ars_technica.common.items.ingredients.CalibratedPrecisionMechanism;
import net.mcreator.ars_technica.init.ArsTechnicaModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry.register;
import static com.simibubi.create.AllTags.forgeItemTag;
import static net.mcreator.ars_technica.ArsTechnicaMod.REGISTRATE;


public class ItemsRegistry {
  public static final ItemEntry<TechnomancerArmor> TECHNOMANCER_HELMET =
          REGISTRATE.item("technomancer_helmet", p -> new TechnomancerArmor(ArmorItem.Type.HELMET,".create_goggles_info"))
                  .tag(forgeItemTag("armors/helmet"))
                  .register();
  public static final ItemEntry<TechnomancerArmor> TECHNOMANCER_CHESTPLATE =
          REGISTRATE.item("technomancer_chestplate", p -> new TechnomancerArmor(ArmorItem.Type.CHESTPLATE, null))
                  .register();
  public static final ItemEntry<TechnomancerArmor> TECHNOMANCER_LEGGINGS =
          REGISTRATE.item("technomancer_leggings", p -> new TechnomancerArmor(ArmorItem.Type.LEGGINGS, null))
                  .register();
  public static final ItemEntry<TechnomancerArmor> TECHNOMANCER_BOOTS =
          REGISTRATE.item("technomancer_boots", p -> new TechnomancerArmor(ArmorItem.Type.BOOTS, null))
                  .register();

  public static final ItemEntry<ModItem> TRANSMUTATION_FOCUS =
          REGISTRATE.item("transmutation_focus", p -> new TransmutationFocus(p.stacksTo(1))
                          .withTooltip(Component.translatable("ars_technica.tooltip.transmutation_focus")))
                  .register();


  public static ItemEntry<CalibratedPrecisionMechanism> CALIBRATED_PRECISION_MECHANISM =
          REGISTRATE.item("calibrated_precision_mechanism", CalibratedPrecisionMechanism::new)
                  .properties(p -> p.stacksTo(64))
                  .register();

  public static ItemEntry<Item> AMETHYST_DUST =
          REGISTRATE.item("amethyst_dust", Item::new)
                  .properties(p -> p.stacksTo(64))
                  .register();
  public static ItemEntry<Item> QUARTZ_DUST =
          REGISTRATE.item("quartz_dust", Item::new)
                  .properties(p -> p.stacksTo(64))
                  .register();
  public static ItemEntry<RunicSpanner> RUNIC_SPANNER =
          REGISTRATE.item("runic_spanner", RunicSpanner::new)
                  .properties(p -> p.stacksTo(1))
                  .register();
  public static ItemEntry<SpyMonocle> SPY_MONOCLE =
          REGISTRATE.item("spy_monocle", SpyMonocle::new)
                  .properties(p -> p.stacksTo(1))
                  .register();


  public static int GREATER_EXPERIENCE_VALUE = 12;
  public static final ItemEntry<ModItem> GIANT_EXPERIENCE_GEM =
          REGISTRATE.item("giant_experience_gem", p -> new ExperienceGem() {
                    @Override
                    public int getValue() {
                      return GREATER_EXPERIENCE_VALUE * 4;
                    }
                  }.withTooltip(Component.translatable("ars_nouveau.tooltip.exp_gem")))
                  .register();


  public static final ItemEntry<ModItem> GARGANTUAN_EXPERIENCE_GEM =
          REGISTRATE.item("gargantuan_experience_gem", p -> new ExperienceGem() {
                    @Override
                    public int getValue() {
                      return GREATER_EXPERIENCE_VALUE * 4 * 4;
                    }
                  }.withTooltip(Component.translatable("ars_nouveau.tooltip.exp_gem")))
                  .register();


  public static ItemEntry<RecordItem> POCKET_FACTORY_DISC = REGISTRATE.item(
          "pocket_factory_disc",
          props -> new RecordItem(
                  3,
                  ArsTechnicaModSounds.POCKET_FACTORY_DISC::get,
                  props.stacksTo(1),
                  3072
          )
  ).register();


  public static ItemEntry<BlockItem> SOURCE_ENGINE =
         REGISTRATE.item("source_engine", props -> new BlockItem(BlockRegistry.SOURCE_ENGINE.get(), props.stacksTo(64)))
                  .register();


  public static void registerEventListeners(IEventBus eventBus) {
    ArsTechnicaMod.REGISTRATE.registerEventListeners(eventBus);
   GogglesItem.addIsWearingPredicate(IGoggleHelmet::isGoggleHelmet);
  }
  public static final List<ItemEntry<? extends Item>> ALL_ITEMS = List.of(
          TECHNOMANCER_HELMET,
          TECHNOMANCER_CHESTPLATE,
          TECHNOMANCER_LEGGINGS,
          TECHNOMANCER_BOOTS,
          TRANSMUTATION_FOCUS,
          RUNIC_SPANNER,
          SOURCE_ENGINE,
          SPY_MONOCLE,
          POCKET_FACTORY_DISC,
          CALIBRATED_PRECISION_MECHANISM,
          GIANT_EXPERIENCE_GEM,
          GARGANTUAN_EXPERIENCE_GEM
  );


  //public static Item.Properties defaultItemProperties() {
  //  return new Item.Properties();
  //}
}
