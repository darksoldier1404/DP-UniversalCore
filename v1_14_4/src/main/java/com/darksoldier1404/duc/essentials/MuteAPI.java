package com.darksoldier1404.duc.essentials;

import com.darksoldier1404.duc.UniversalCore;
import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class MuteAPI {
    private final static UniversalCore plugin = UniversalCore.getInstance();
    private final static Essentials ess = plugin.ess;

    public static boolean isEnabled() {
        return ess != null;
    }

    public static boolean isMuted(Player p) {
        if(!isEnabled()) return false;
        return ess.getUser(p).isMuted();
    }

    public static void mute(Player p) {
        if(!isEnabled()) return;
        ess.getUser(p).setMuted(true);
    }

    public static void mute(Player p, String reason) {
        if(!isEnabled()) return;
        User u = ess.getUser(p);
        u.setMuted(true);
        u.setMuteReason(reason);
    }

    public static void mute(Player p, long time) {
        if(!isEnabled()) return;
        User u = ess.getUser(p);
        u.setMuted(true);
        u.setMuteTimeout(time);
    }

    public static void mute(Player p, long time, String reason) {
        if(!isEnabled()) return;
        User u = ess.getUser(p);
        u.setMuted(true);
        u.setMuteTimeout(time);
        u.setMuteReason(reason);
    }

    public static void unmute(Player p) {
        if(!isEnabled()) return;
        ess.getUser(p).setMuted(false);
    }

    public static String getMuteReason(Player p) {
        if(!isEnabled()) {
            return "";
        }
        return ess.getUser(p).getMuteReason();
    }

    public static long getMuteTimeLeft(Player p) {
        if(!isEnabled()) return 0;
        return ess.getUser(p).getMuteTimeout();
    }

    public static void setMuteReason(Player p, String reason) {
        if(!isEnabled()) return;
        ess.getUser(p).setMuteReason(reason);
    }

    public static void setMuteTimeLeft(Player p, long time) {
        if(!isEnabled()) return;
        ess.getUser(p).setMuteTimeout(time);
    }

    public static void setMuteTimeLeft(Player p, long time, String reason) {
        if(!isEnabled()) return;
        ess.getUser(p).setMuteTimeout(time);
        ess.getUser(p).setMuteReason(reason);
    }
}
