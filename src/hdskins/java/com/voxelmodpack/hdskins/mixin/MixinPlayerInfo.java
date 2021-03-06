package com.voxelmodpack.hdskins.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.google.common.base.Optional;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import com.voxelmodpack.hdskins.HDSkinManager;

import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;

@Mixin(NetworkPlayerInfo.class)
public abstract class MixinPlayerInfo {

    @Shadow
    public abstract GameProfile getGameProfile();

    @Inject(
            method = "getLocationSkin",
            cancellable = true,
            at = @At("RETURN"))
    private void getLocationSkin(CallbackInfoReturnable<ResourceLocation> ci) {
        getTextureLocation(ci, Type.SKIN);
    }

    @Inject(
            method = "getLocationCape",
            cancellable = true,
            at = @At("RETURN"))
    private void getLocationCape(CallbackInfoReturnable<ResourceLocation> ci) {
        getTextureLocation(ci, Type.CAPE);
    }

    @Inject(
            method = "getLocationElytra",
            cancellable = true,
            at = @At("RETURN"))
    private void getLocationElytra(CallbackInfoReturnable<ResourceLocation> ci) {
        getTextureLocation(ci, Type.ELYTRA);
    }
    
    private void getTextureLocation(CallbackInfoReturnable<ResourceLocation> ci, Type type) {
        Optional<ResourceLocation> texture = HDSkinManager.INSTANCE.getSkinLocation(getGameProfile(), type, true);
        if (texture.isPresent()) {
            ci.setReturnValue(texture.get());
        }
    }

    @Inject(
            method = "getSkinType",
            cancellable = true,
            at = @At("RETURN"))
    private void getSkinType(CallbackInfoReturnable<String> ci) {
        MinecraftProfileTexture data = HDSkinManager.INSTANCE.getProfileData(getGameProfile()).get(Type.SKIN);
        if (data != null) {
            String type = data.getMetadata("model");
            boolean hasSkin = HDSkinManager.INSTANCE.getSkinLocation(getGameProfile(), Type.SKIN, false).isPresent();
            if (hasSkin) {
                if (type == null)
                    type = "default";
                ci.setReturnValue(type);
            }
        }
    }
}
