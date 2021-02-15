package com.adamkerr.mccourse.item;

import com.adamkerr.mccourse.MCCourseMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;


public class Zuccini extends Item
{
    public Zuccini()
    {
        super(new Properties().group(MCCourseMod.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(1.5f)
                        .build()));
    }
}
