package com.brohoof.minelittlepony.model.part;

import com.brohoof.minelittlepony.PonyData;
import com.brohoof.minelittlepony.model.AbstractPonyModel;
import com.brohoof.minelittlepony.model.BodyPart;
import com.brohoof.minelittlepony.model.PonyModelConstants;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class PegasusWings implements IPonyPart, PonyModelConstants {

    private final AbstractPonyModel pony;

    public ModelRenderer[] leftWing;
    public ModelRenderer[] rightWing;

    public ModelRenderer[] leftWingExt;
    public ModelRenderer[] rightWingExt;

    public PegasusWings(AbstractPonyModel pony) {
        this.pony = pony;
    }

    @Override
    public void init(float yOffset, float stretch) {
        this.leftWing = new ModelRenderer[3];
        this.rightWing = new ModelRenderer[3];
        this.leftWingExt = new ModelRenderer[6];
        this.rightWingExt = new ModelRenderer[6];

        for (int i = 0; i < leftWing.length; i++) {
            this.leftWing[i] = new ModelRenderer(pony, 56, 32);
            this.pony.boxList.remove(this.leftWing[i]);
        }
        for (int i = 0; i < rightWing.length; i++) {
            this.rightWing[i] = new ModelRenderer(pony, 56, 16);
            this.pony.boxList.remove(this.rightWing[i]);
        }
        for (int i = 0; i < leftWingExt.length; i++) {
            this.leftWingExt[i] = new ModelRenderer(pony, 56, 35);
            this.pony.boxList.remove(this.leftWingExt[i]);
        }
        for (int i = 0; i < rightWingExt.length; i++) {
            this.rightWingExt[i] = new ModelRenderer(pony, 56, 19);
            // this seems to hide the wings being a different size when folded
            this.rightWingExt[i].mirror = true;
            this.pony.boxList.remove(this.rightWingExt[i]);
        }

        initPositions(yOffset, stretch);
    }

    private void initPositions(float yOffset, float stretch) {
        this.leftWing[0].addBox(4.0F, 5.0F, 2.0F, 2, 6, 2, stretch);
        this.leftWing[0].setRotationPoint(HEAD_RP_X, WING_FOLDED_RP_Y + yOffset, WING_FOLDED_RP_Z);
        this.leftWing[0].rotateAngleX = ROTATE_90;
        this.leftWing[1].addBox(4.0F, 5.0F, 4.0F, 2, 8, 2, stretch);
        this.leftWing[1].setRotationPoint(HEAD_RP_X, WING_FOLDED_RP_Y + yOffset, WING_FOLDED_RP_Z);
        this.leftWing[1].rotateAngleX = ROTATE_90;
        this.leftWing[2].addBox(4.0F, 5.0F, 6.0F, 2, 6, 2, stretch);
        this.leftWing[2].setRotationPoint(HEAD_RP_X, WING_FOLDED_RP_Y + yOffset, WING_FOLDED_RP_Z);
        this.leftWing[2].rotateAngleX = ROTATE_90;
        this.rightWing[0].addBox(-6.0F, 5.0F, 2.0F, 2, 6, 2, stretch);
        this.rightWing[0].setRotationPoint(HEAD_RP_X, WING_FOLDED_RP_Y + yOffset, WING_FOLDED_RP_Z);
        this.rightWing[0].rotateAngleX = ROTATE_90;
        this.rightWing[1].addBox(-6.0F, 5.0F, 4.0F, 2, 8, 2, stretch);
        this.rightWing[1].setRotationPoint(HEAD_RP_X, WING_FOLDED_RP_Y + yOffset, WING_FOLDED_RP_Z);
        this.rightWing[1].rotateAngleX = ROTATE_90;
        this.rightWing[2].addBox(-6.0F, 5.0F, 6.0F, 2, 6, 2, stretch);
        this.rightWing[2].setRotationPoint(HEAD_RP_X, WING_FOLDED_RP_Y + yOffset, WING_FOLDED_RP_Z);
        this.rightWing[2].rotateAngleX = ROTATE_90;
        this.leftWingExt[0].addBox(0.0F, 6.0F, 0.0F, 1, 8, 2, stretch + 0.1F);
        this.leftWingExt[0].setRotationPoint(LEFT_WING_EXT_RP_X, LEFT_WING_EXT_RP_Y + yOffset, LEFT_WING_EXT_RP_Z);
        this.leftWingExt[1].addBox(0.0F, -1.2F, -0.2F, 1, 8, 2, stretch - 0.2F);
        this.leftWingExt[1].setRotationPoint(LEFT_WING_EXT_RP_X, LEFT_WING_EXT_RP_Y + yOffset, LEFT_WING_EXT_RP_Z);
        this.leftWingExt[2].addBox(0.0F, 1.8F, 1.3F, 1, 8, 2, stretch - 0.1F);
        this.leftWingExt[2].setRotationPoint(LEFT_WING_EXT_RP_X, LEFT_WING_EXT_RP_Y + yOffset, LEFT_WING_EXT_RP_Z);
        this.leftWingExt[3].addBox(0.0F, 5.0F, 2.0F, 1, 8, 2, stretch);
        this.leftWingExt[3].setRotationPoint(LEFT_WING_EXT_RP_X, LEFT_WING_EXT_RP_Y + yOffset, LEFT_WING_EXT_RP_Z);
        this.leftWingExt[4].addBox(0.0F, 0.0F, -0.2F, 1, 6, 2, stretch + 0.3F);
        this.leftWingExt[4].setRotationPoint(LEFT_WING_EXT_RP_X, LEFT_WING_EXT_RP_Y + yOffset, LEFT_WING_EXT_RP_Z);
        this.leftWingExt[5].addBox(0.0F, 0.0F, 0.2F, 1, 3, 2, stretch + 0.19F);
        this.leftWingExt[5].setRotationPoint(LEFT_WING_EXT_RP_X, LEFT_WING_EXT_RP_Y + yOffset, LEFT_WING_EXT_RP_Z);
        this.rightWingExt[0].addBox(0.0F, 6.0F, 0.0F, 1, 8, 2, stretch + 0.1F);
        this.rightWingExt[0].setRotationPoint(RIGHT_WING_EXT_RP_X, RIGHT_WING_EXT_RP_Y + yOffset, RIGHT_WING_EXT_RP_Z);
        this.rightWingExt[1].addBox(0.0F, -1.2F, -0.2F, 1, 8, 2, stretch - 0.2F);
        this.rightWingExt[1].setRotationPoint(RIGHT_WING_EXT_RP_X, RIGHT_WING_EXT_RP_Y + yOffset, RIGHT_WING_EXT_RP_Z);
        this.rightWingExt[2].addBox(0.0F, 1.8F, 1.3F, 1, 8, 2, stretch - 0.1F);
        this.rightWingExt[2].setRotationPoint(RIGHT_WING_EXT_RP_X, RIGHT_WING_EXT_RP_Y + yOffset, RIGHT_WING_EXT_RP_Z);
        this.rightWingExt[3].addBox(0.0F, 5.0F, 2.0F, 1, 8, 2, stretch);
        this.rightWingExt[3].setRotationPoint(RIGHT_WING_EXT_RP_X, RIGHT_WING_EXT_RP_Y + yOffset, RIGHT_WING_EXT_RP_Z);
        this.rightWingExt[4].addBox(0.0F, 0.0F, -0.2F, 1, 6, 2, stretch + 0.3F);
        this.rightWingExt[4].setRotationPoint(RIGHT_WING_EXT_RP_X, RIGHT_WING_EXT_RP_Y + yOffset, RIGHT_WING_EXT_RP_Z);
        this.rightWingExt[5].addBox(0.0F, 0.0F, 0.2F, 1, 3, 2, stretch + 0.19F);
        this.rightWingExt[5].setRotationPoint(RIGHT_WING_EXT_RP_X, RIGHT_WING_EXT_RP_Y + yOffset, RIGHT_WING_EXT_RP_Z);
    }

    @Override
    public void animate(PonyData metadata, float move, float swing, float tick, float horz, float vert) {

        float bodySwingRotation = 0.0F;
        if (pony.swingProgress > -9990.0F && !metadata.hasMagic()) {
            bodySwingRotation = MathHelper.sin(MathHelper.sqrt_float(pony.swingProgress) * 3.1415927F * 2.0F) * 0.2F;
        }
        for (int i = 0; i < this.leftWing.length; ++i) {
            this.leftWing[i].rotateAngleY = bodySwingRotation * 0.2F;
        }
        for (int i = 0; i < this.rightWing.length; ++i) {
            this.rightWing[i].rotateAngleY = bodySwingRotation * 0.2F;
        }
        if (pony.isSneak && !pony.isFlying) {
            this.sneak();
        } else {
            this.unsneak(tick);

        }

        float angle = ROTATE_90;

        for (int i = 0; i < this.leftWing.length; i++) {
            this.leftWing[i].rotateAngleX = angle;
        }
        for (int i = 0; i < this.rightWing.length; i++) {
            this.rightWing[i].rotateAngleX = angle;
        }
        // Special
        this.leftWingExt[1].rotateAngleX -= 0.85F;
        this.leftWingExt[2].rotateAngleX -= 0.75F;
        this.leftWingExt[3].rotateAngleX -= 0.5F;
        this.leftWingExt[5].rotateAngleX -= 0.85F;
        this.rightWingExt[1].rotateAngleX -= 0.85F;
        this.rightWingExt[2].rotateAngleX -= 0.75F;
        this.rightWingExt[3].rotateAngleX -= 0.5F;
        this.rightWingExt[5].rotateAngleX -= 0.85F;

    }

    @Override
    public void render(PonyData data, float scale) {
        pony.transform(BodyPart.BODY);
        pony.bipedBody.postRender(scale);
        if (data.getRace() != null && data.getRace().hasWings()) {
            if (!pony.isFlying && !pony.isSneak) {

                for (int k1 = 0; k1 < this.leftWing.length; ++k1) {
                    this.leftWing[k1].render(scale);
                }

                for (int k1 = 0; k1 < this.rightWing.length; ++k1) {
                    this.rightWing[k1].render(scale);
                }
            } else {

                for (int k1 = 0; k1 < this.leftWingExt.length; ++k1) {
                    this.leftWingExt[k1].render(scale);
                }

                for (int i = 0; i < this.rightWingExt.length; ++i) {
                    this.rightWingExt[i].render(scale);
                }
            }
        }
    }

    private void sneak() {
        for (int i = 0; i < this.leftWingExt.length; ++i) {
            this.leftWingExt[i].rotateAngleX = EXT_WING_ROTATE_ANGLE_X;
            this.leftWingExt[i].rotateAngleZ = LEFT_WING_ROTATE_ANGLE_Z_SNEAK;
        }

        for (int i = 0; i < this.leftWingExt.length; ++i) {
            this.rightWingExt[i].rotateAngleX = EXT_WING_ROTATE_ANGLE_X;
            this.rightWingExt[i].rotateAngleZ = RIGHT_WING_ROTATE_ANGLE_Z_SNEAK;
        }
    }

    private void unsneak(float tick) {
        if (pony.isFlying) {
            float WingRotateAngleZ = MathHelper.sin(tick * 0.536F) * 1.0F;

            for (int i = 0; i < this.leftWingExt.length; ++i) {
                this.leftWingExt[i].rotateAngleX = EXT_WING_ROTATE_ANGLE_X;
                this.leftWingExt[i].rotateAngleZ = -WingRotateAngleZ - ROTATE_270 - 0.4F;
            }

            for (int i = 0; i < this.rightWingExt.length; ++i) {
                this.rightWingExt[i].rotateAngleX = EXT_WING_ROTATE_ANGLE_X;
                this.rightWingExt[i].rotateAngleZ = WingRotateAngleZ + ROTATE_270 + 0.4F;
            }
        }
    }

}
