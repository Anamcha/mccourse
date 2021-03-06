package com.adamkerr.mccourse.block;

import com.adamkerr.mccourse.MCCourseMod;
import com.adamkerr.mccourse.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.STONE)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> COPPER_STAIRS = register("copper_stairs",
            () -> new StairsBlock(() -> ModBlocks.COPPER_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON)));

    /* FENCES */

    public static final RegistryObject<Block> COPPER_FENCE = register("copper_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> COPPER_FENCE_GATE = register("copper_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    /* REDSTONE */

    public static final RegistryObject<Block> COPPER_BUTTON = register("copper_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).doesNotBlockMovement()));

    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE = register("copper_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS,
                    AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f)
                    .sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)));

    /* SLABS */

    public static final RegistryObject<Block> COPPER_SLAB = register("copper_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> IRON_SLAB = register("iron_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> GOLD_SLAB = register("gold_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> EMERALD_SLAB = register("emerald_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> DIAMOND_SLAB = register("diamond_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> REDSTONE_SLAB = register("redstone_slab",
            () -> new RedstoneSlab(AbstractBlock.Properties.create(Material.ROCK)));

    public static final RegistryObject<Block> LAPIS_SLAB = register("lapis_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)));

    /*CROPS*/

    public static final RegistryObject<Block> ZUCCINI_CROP =
            Registration.BLOCKS.register("zuccini_crop",
                    () -> new ZucciniCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));


    public static void register() { }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(MCCourseMod.COURSE_TAB)));
        return toReturn;
    }

}
