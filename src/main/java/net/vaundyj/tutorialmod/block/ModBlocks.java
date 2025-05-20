package net.vaundyj.tutorialmod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.vaundyj.tutorialmod.TutorialMod;

public class ModBlocks {

    //REGISTER BLOCKS HERE
    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().strength(3.0F, 3.0F).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

    }
}
