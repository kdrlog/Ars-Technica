package net.mcreator.ars_technica.common.kinetics;

import com.simibubi.create.api.stress.BlockStressValues;
import net.minecraft.world.level.block.Block;

public class CustomStressValueProvider {

    /**
     * Registers stress capacity and generated RPM for a block.
     *
     * @param block         The block to register the stress values for.
     * @param capacity      The stress capacity of the block.
     * @param generatedRPM  The generated RPM for the block.
     */
    public static void register(Block block, double capacity, int generatedRPM) {
        // Register the stress capacity of the block
        BlockStressValues.CAPACITIES.register(block, () -> capacity);

        // Register the generated RPM; used for tooltips and informational purposes
        BlockStressValues.RPM.register(block, new BlockStressValues.GeneratedRpm(generatedRPM, false));
    }

    /**
     * Registers only the stress capacity for a block.
     *
     * @param block    The block to register the stress capacity for.
     * @param capacity The stress capacity of the block.
     */
    public static void registerCapacity(Block block, double capacity) {
        BlockStressValues.CAPACITIES.register(block, () -> capacity);
    }

    /**
     * Registers only the generated RPM for a block.
     *
     * @param block         The block to register the RPM for.
     * @param generatedRPM  The generated RPM for the block.
     * @param mayGenerateLess If true, the block may generate less RPM under certain conditions.
     */
    public static void registerRPM(Block block, int generatedRPM, boolean mayGenerateLess) {
        BlockStressValues.RPM.register(block, new BlockStressValues.GeneratedRpm(generatedRPM, mayGenerateLess));
    }
}