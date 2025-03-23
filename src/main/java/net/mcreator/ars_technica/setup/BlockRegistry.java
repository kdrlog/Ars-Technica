package net.mcreator.ars_technica.setup;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.mcreator.ars_technica.ArsTechnicaMod;
import net.mcreator.ars_technica.common.blocks.PreciseRelay;
import net.mcreator.ars_technica.common.blocks.turrets.EncasedTurretBlock;
import net.mcreator.ars_technica.common.blocks.SourceEngineBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.mcreator.ars_technica.ArsTechnicaMod.REGISTRATE;


public class BlockRegistry {

    public static final BlockEntry<SourceEngineBlock> SOURCE_ENGINE =
            REGISTRATE.block("source_engine", SourceEngineBlock::new)
                    .initialProperties(SharedProperties::stone)
                    .properties(p -> p.mapColor(MapColor.COLOR_PURPLE)
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .strength(1.5F, 6.0F)
                            .sound(SoundType.STONE))
                    .register();


    // TODO: deprecated, remove
    public static final BlockEntry<EncasedTurretBlock> ANDESITE_ENCASED_TURRET_BLOCK =
            REGISTRATE.block("encased_turret_block", p -> new EncasedTurretBlock(p, AllBlocks.ANDESITE_CASING::get))
                    .properties(p -> p.mapColor(MapColor.PODZOL)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(1.5F, 6.0F)
                            .sound(SoundType.WOOD))

                    .register();


    public static final BlockEntry<PreciseRelay> PRECISE_RELAY =
            REGISTRATE.block("precise_relay", PreciseRelay::new)
                    .properties(p -> p.mapColor(MapColor.COLOR_PURPLE)
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .strength(1.5F, 6.0F)
                            .sound(SoundType.STONE))
                    .register();



    public static void registerEventListeners(IEventBus eventBus) {
        ArsTechnicaMod.REGISTRATE.registerEventListeners(eventBus);
    }
}
