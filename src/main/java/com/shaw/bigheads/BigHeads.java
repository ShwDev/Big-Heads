package com.shaw.bigheads;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BigHeads implements ModInitializer {

	public static final Map<UUID, Float> headScales = new HashMap<>();

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("headscale")
					.then(Commands.argument("target", EntityArgument.player())
							.then(Commands.argument("scale", com.mojang.brigadier.arguments.FloatArgumentType.floatArg(0.1f, 5.0f))
									.executes(context -> {
										ServerPlayer target = EntityArgument.getPlayer(context, "target");
										float scale = com.mojang.brigadier.arguments.FloatArgumentType.getFloat(context, "scale");

										headScales.put(target.getUUID(), scale);

										context.getSource().sendSuccess(
												() -> Component.literal("Escala de cabeza de " + target.getName().getString() + " ajustada a " + scale),
												true
										);
										return 1;
									})
							)
					)
			);
		});
	}
}