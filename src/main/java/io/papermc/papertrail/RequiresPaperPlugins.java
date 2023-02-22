package io.papermc.papertrail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;

@SuppressWarnings("deprecation") // Must use deprecated methods to function on CB/Spigot
@DefaultQualifier(NonNull.class)
public class RequiresPaperPlugins extends JavaPlugin {
    @Override
    public void onEnable() {
        final List<String> message = new ArrayList<>(Collections.singletonList(""));
        if (!Util.PAPER) {
            message.addAll(this.requiresPaper());
        } else {
            message.addAll(this.outdatedPaper());
        }
        this.getLogger().log(Level.SEVERE, String.join("\n", message), new RuntimeException("Unsupported platform"));
        this.getServer().getPluginManager().disablePlugin(this);
    }

    private List<String> outdatedPaper() {
        final List<String> msg = new ArrayList<>();
        msg.add(Util.EQUALS_LINE);
        msg.add(" " + this.getDescription().getName() + " requires Paper 1.19.3 build #405 or newer.");
        msg.add(Util.EQUALS_LINE);
        return msg;
    }

    private List<String> requiresPaper() {
        final String pluginName = this.getDescription().getName();
        final List<String> msg = new ArrayList<>();
        msg.add(Util.EQUALS_LINE);
        msg.add(" " + pluginName + " only supports Paper and derivatives, not Spigot or CraftBukkit.");
        if (System.getProperty(Util.SHOWN_LONG_MESSAGE) == null) {
            System.setProperty(Util.SHOWN_LONG_MESSAGE, "1");
            msg.add("  ");
            msg.add(" Paper offers significant performance improvements,");
            msg.add(" bug fixes, security enhancements and optional");
            msg.add(" features for server owners to enhance their server.");
            msg.add("  ");
            msg.add(" Paper includes Timings v2, which is significantly");
            msg.add(" better at diagnosing lag problems over v1.");
            msg.add("  ");
            msg.add(" All of your plugins should still work, and the");
            msg.add(" Paper community will gladly help you fix any issues.");
            msg.add("  ");
            msg.add(" Join the Paper Community @ https://papermc.io");
        }
        msg.add(Util.EQUALS_LINE);
        return msg;
    }
}
