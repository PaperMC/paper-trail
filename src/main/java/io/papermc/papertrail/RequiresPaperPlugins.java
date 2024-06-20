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
        this.getLogger().log(Level.SEVERE, String.join("\n", lines),
            new UnsupportedPlatformException("Unsupported platform"));
    }

    private void disable() {
        this.getServer().getPluginManager().disablePlugin(this);
    }

    private List<String> outdatedPaper() {
        final String pluginName = this.getDescription().getName();
        return Arrays.asList(
            " " + pluginName + " requires a newer version of Paper.",
            " You can often find a list of supported game versions",
            " at the webpage you obtained the plugin from. You could",
            " also contact the plugin author for assistance."
        );
    }

    private List<String> requiresPaper() {
        final String pluginName = this.getDescription().getName();
        return Arrays.asList(
            " " + pluginName + " is a Paper plugin, meaning it only supports",
            " Paper and derivatives, not Spigot or CraftBukkit.",
            "",
            " Paper offers significant performance improvements,",
            " bug fixes, security enhancements and optional",
            " features for server owners to enhance their server.",
            " And provides developers an improved and expanded plugin",
            " development API.",
            "",
            " All of your Bukkit and Spigot plugins should still work,",
            " on Paper, and the community will gladly help you fix any",
            " issues.",
            "",
            " Download Paper and join the community @ https://papermc.io"
        );
    }
}
