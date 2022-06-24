package com.rebirth.rebirth_mod.Rebirth;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Rebirth");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
	}

	//Soul Bricks
	public static final Block SOUL_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f));
 
    @Override
    public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("rebirth", "soul_bricks"), SOUL_BRICKS);
    }

	//Soul Totem
	public static final Item SOUL_TOTEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));
 
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("rebirth", "soul_totem"), SOUL_TOTEM);
    }

	public static ToolItem SOUL_SCYTHE = new SwordItem(ScytheToolMaterial.INSTANCE, 1.8F, 0.0F, new Item.Settings().group(ItemGroup.COMBAT));
}

public class ScytheToolMaterial implements ToolMaterial {

	public static final ScytheToolMaterial INSTANCE = new ScytheToolMaterial();

	@Override
	public int getDurability() {
		return 1600;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 1.0F;
	}

	@Override
	public float getAttackDamage() {
		return 9.5F;
	}

	@Override
	public int getMiningLevel() {
		return 0;
	}

	@Override
	public int getEnchantability() {
		return 22;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.SOUL_SCYTHE);
	}
}
