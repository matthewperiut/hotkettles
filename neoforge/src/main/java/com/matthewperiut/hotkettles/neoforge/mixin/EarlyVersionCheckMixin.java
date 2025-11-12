package com.matthewperiut.hotkettles.neoforge.mixin;

import net.minecraft.client.MinecraftClient;
import net.neoforged.fml.loading.FMLLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.swing.*;

@Mixin(MinecraftClient.class)
public class EarlyVersionCheckMixin {
    private static boolean versionChecked = false;

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Util;getMeasuringTimeNano()J"))
    private static void checkVersionCompatibility(CallbackInfo ci) {
        if (!versionChecked) {
            versionChecked = true;

            try {
                String neoforgeVersion = FMLLoader.getCurrent().getVersionInfo().neoForgeVersion();
                String architecturyVersion = FMLLoader.getCurrent().getLoadingModList().getModFileById("architectury")
                        .getMods().get(0).getVersion().toString();

                if (isNeoForgeVersionTooHigh(neoforgeVersion) && isArchitecturyVersionTooLow(architecturyVersion)) {
                    String message = "This version of architectury api can only use NeoForge 21.10.34-beta or lower.\n\n" +
                            "Current NeoForge: " + neoforgeVersion + "\n" +
                            "Current Architectury: " + architecturyVersion + "\n\n" +
                            "If a newer version of architectury api exists, you can also update to that instead.";

                    showErrorDialog(message);
                    throw new RuntimeException("Incompatible mod versions: NeoForge " + neoforgeVersion +
                            " with Architectury " + architecturyVersion);
                }
            } catch (Exception e) {
                if (e instanceof RuntimeException && e.getMessage().contains("Incompatible mod versions")) {
                    throw e;
                }
                // If we can't check versions, log and continue
                System.err.println("[HotKettles] Failed to check version compatibility: " + e.getMessage());
            }
        }
    }

    private static boolean isNeoForgeVersionTooHigh(String version) {
        try {
            String[] parts = version.replace("-beta", "").split("\\.");
            if (parts.length < 3) return false;

            int major = Integer.parseInt(parts[0]);
            int minor = Integer.parseInt(parts[1]);
            int patch = Integer.parseInt(parts[2]);

            // Check if version > 21.10.34
            if (major > 21) return true;
            if (major < 21) return false;
            if (minor > 10) return true;
            if (minor < 10) return false;
            return patch > 34;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isArchitecturyVersionTooLow(String version) {
        try {
            String[] parts = version.split("\\.");
            if (parts.length < 3) return false;

            int major = Integer.parseInt(parts[0]);
            int minor = Integer.parseInt(parts[1]);
            int patch = Integer.parseInt(parts[2]);

            // Check if version <= 18.0.6
            if (major < 18) return true;
            if (major > 18) return false;
            if (minor < 0) return true;
            if (minor > 0) return false;
            return patch <= 6;
        } catch (Exception e) {
            return false;
        }
    }

    private static void showErrorDialog(String message) {
        try {
            // Show dialog synchronously on the EDT and wait for user to close it
            SwingUtilities.invokeAndWait(() -> {
                JOptionPane.showMessageDialog(null, message, "Mod Compatibility Error", JOptionPane.ERROR_MESSAGE);
            });

            // After user closes dialog, forcefully exit
            System.err.println("[HotKettles] " + message);
            System.err.println("[HotKettles] Exiting due to incompatible mod versions.");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("[HotKettles] Failed to show error dialog: " + e.getMessage());
            System.err.println("[HotKettles] " + message);
            System.exit(1);
        }
    }
}
