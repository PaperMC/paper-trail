package io.papermc.papertrail;

import java.util.ArrayList;
import java.util.Arrays;
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
        this.printInformation();
        this.disable();
    }

    private void printInformation() {
        final List<String> lines = new ArrayList<>(Arrays.asList("", Util.EQUALS_LINE));
        lines.addAll(Util.PAPER ? this.outdatedPaper() : this.requiresPaper());
        lines.add(Util.EQUALS_LINE);
        this.getLogger().log(Level.SEVERE, String.join("\n", lines), new UnsupportedPlatformException("Unsupported platform"));
    }

    private void disable() {
        this.getServer().getPluginManager().disablePlugin(this);
    }

    private List<String> outdatedPaper() {
        final String pluginName = this.getDescription().getName();
        return Arrays.asList(" " + pluginName + " requires Paper 1.19.3 build #405 or newer.");
    }

    private List<String> requiresPaper() {
        final String pluginName = this.getDescription().getName();
        return Arrays.asList(
            " " + pluginName + " only supports Paper and derivatives, not Spigot or CraftBukkit.",
            "",
            " Paper offers significant performance improvements,",
            " bug fixes, security enhancements and optional",
            " features for server owners to enhance their server.",
            "",
            " Paper includes Timings v2, which is significantly",
            " better at diagnosing lag problems over v1.",
            "",
            " All of your plugins should still work, and the",
            " Paper community will gladly help you fix any issues.",
            "",
            " Join the Paper Community @ https://papermc.io"
        );
    }
}
