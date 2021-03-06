package com.brohoof.minelittlepony.forge;

public abstract class MLPCommonProxy {

    private static MLPCommonProxy instance;

    public static MLPCommonProxy getInstance() {
        return instance;
    }

    public MLPCommonProxy() {
        instance = this;
    }

    public abstract void setPonyArmors(IPonyArmor armors);
}
