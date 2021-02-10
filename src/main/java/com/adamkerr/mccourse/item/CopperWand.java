package com.adamkerr.mccourse.item;

import com.adamkerr.mccourse.MCCourseMod;
import com.adamkerr.mccourse.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class CopperWand extends Item
{
    public CopperWand()
    {
        super(new Properties().group(MCCourseMod.COURSE_TAB));
    }
    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip,
                               ITooltipFlag flag)
    {
        if (KeyboardHelper.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("Hit your enemies to send them flying!"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT " + "\u00A77" + "for more information."));
        }

        super.addInformation(stack, world, tooltip, flag);
    }
}
