package ac.grim.grimac.manager.player.features.types;

import ac.grim.grimac.api.config.ConfigManager;
import ac.grim.grimac.api.feature.FeatureState;
import ac.grim.grimac.player.GrimPlayer;

/**
 * Whether Grim calls updateInventory() when its packet inventory desyncs from Bukkit.
 * Only toggled through the API (FeatureManager), there is no config option.
 */
public class InventoryResyncFeature implements GrimFeature {

    @Override
    public String getName() {
        return "InventoryResync";
    }

    @Override
    public void setState(GrimPlayer player, ConfigManager config, FeatureState state) {
        switch (state) {
            case ENABLED -> player.setInventoryResync(true);
            case DISABLED -> player.setInventoryResync(false);
            default -> player.setInventoryResync(isEnabledInConfig(player, config));
        }
    }

    @Override
    public boolean isEnabled(GrimPlayer player) {
        return player.isInventoryResync();
    }

    @Override
    public boolean isEnabledInConfig(GrimPlayer player, ConfigManager config) {
        return true;
    }

}
