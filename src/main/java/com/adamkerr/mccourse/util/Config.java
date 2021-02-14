package com.adamkerr.mccourse.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import org.spongepowered.asm.mixin.struct.SourceMap;

import java.io.File;

public class Config
{
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue COPPERED_GLOW_DURATION;
    public static ForgeConfigSpec.IntValue WAND_LEVITATION_DURATION;
    public static ForgeConfigSpec.IntValue WAND_LEVITATION_SPEED;

    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        glowingDuration(SERVER_BUILDER, CLIENT_BUILDER);
        levitationDuration(SERVER_BUILDER, CLIENT_BUILDER);
        levitationSpeed(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }


    private static void glowingDuration(ForgeConfigSpec.Builder SERVER_BUILDER,
                                        ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        COPPERED_GLOW_DURATION = CLIENT_BUILDER.comment("How long the glowing lasts for Coppered Apples (in ticks)")
                .defineInRange("glow_duration", 600, 100, Integer.MAX_VALUE);
    }

    private static void levitationDuration(ForgeConfigSpec.Builder SERVER_BUILDER,
                                           ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
         WAND_LEVITATION_DURATION = CLIENT_BUILDER.comment("How long the levitation lasts for Coppered Wand (in ticks)")
                .defineInRange("levitation_duration", 40, 20, Integer.MAX_VALUE);
    }

    private static void levitationSpeed(ForgeConfigSpec.Builder SERVER_BUILDER,
                                           ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        WAND_LEVITATION_SPEED = CLIENT_BUILDER.comment("How quickly entities will fly from Coppered Wand (in ticks)")
                .defineInRange("levitation_speed", 20, 1, 100);
    }

    public static void loadConfigFile(ForgeConfigSpec config, String path)
    {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync().autosave().writingMode(WritingMode.REPLACE).build();

        file.load();
        config.setConfig(file);
    }
}
