package io.papermc.papertrail;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;

@DefaultQualifier(NonNull.class)
final class Util {
    static final String EQUALS_LINE = "====================================================";
    static final boolean PAPER = hasClass("com.destroystokyo.paper.PaperConfig")
        || hasClass("io.papermc.paper.configuration.Configuration");

    private static boolean hasClass(final String className) {
        try {
            Class.forName(className);
            return true;
        } catch (final ClassNotFoundException e) {
            return false;
        }
    }
}
