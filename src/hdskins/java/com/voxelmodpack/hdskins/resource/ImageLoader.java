package com.voxelmodpack.hdskins.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

import javax.annotation.Nullable;

import org.apache.commons.io.IOUtils;

import com.voxelmodpack.hdskins.DynamicTextureImage;
import com.voxelmodpack.hdskins.ImageBufferDownloadHD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

public class ImageLoader implements Callable<ResourceLocation> {

    private Minecraft mc = Minecraft.getMinecraft();

    private final ResourceLocation original;

    public ImageLoader(ResourceLocation loc) {
        this.original = loc;
    }

    @Override
    public ResourceLocation call() throws Exception {
        BufferedImage image = getImage(original);
        final BufferedImage updated = new ImageBufferDownloadHD().parseUserSkin(image);
        if (updated == null)
            return null;
        return this.mc.addScheduledTask(new Callable<ResourceLocation>() {

            @Override
            public ResourceLocation call() throws Exception {
                return loadSkin(updated);
            }

        }).get();
    }

    @Nullable
    private static BufferedImage getImage(ResourceLocation res) {
        try {
            InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream();
            try {
                return TextureUtil.readBufferedImage(in);
            } finally {
                IOUtils.closeQuietly(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResourceLocation loadSkin(BufferedImage image) {

        ResourceLocation conv = new ResourceLocation(original.getResourceDomain() + "-converted", original.getResourcePath());
        this.mc.getTextureManager().loadTexture(conv, new DynamicTextureImage(image));
        return conv;
    }

}
