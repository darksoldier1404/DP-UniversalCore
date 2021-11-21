package com.darksoldier1404.duc.utils;

import com.darksoldier1404.duc.UniversalCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class UpdateChecker {
    private static final UniversalCore core = UniversalCore.getInstance();
    private static final Logger log = core.getLogger();
    
    public static void check(JavaPlugin plugin) {
        String currentVersion = plugin.getDescription().getVersion();
        String pluginName = plugin.getDescription().getName();
        Bukkit.getScheduler().runTask(core, () -> {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL("https://raw.githubusercontent.com/darksoldier1404/" + pluginName + "/master/src/main/resources/plugin.yml").openConnection();
                connection.connect();
                String rr = new BufferedReader(new InputStreamReader(connection.getInputStream())).lines().toList().get(1).split(" ")[1];
                if (!currentVersion.equals(rr)) {
                    log.info("A new version of LegendaryCash is available! " + rr);
                    log.info("This plugin's version is " + currentVersion);
                    log.info("최신 버전이 존재합니다! " + rr);
                    log.info("이 플러그인의 버전은 " + currentVersion + " 입니다. 업데이트를 해주시기 바랍니다.");
                } else {
                    log.info("이 플러그인은 최신버전 입니다." + currentVersion);
                }
            } catch (IOException e) {
                log.info("업데이트 정보를 가져오는데 실패했습니다.");
            }
        });
    }

    public static void check(JavaPlugin plugin, Player p) {
        String currentVersion = plugin.getDescription().getVersion();
        String pluginName = plugin.getDescription().getName();
        Bukkit.getScheduler().runTask(core, () -> {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL("https://raw.githubusercontent.com/darksoldier1404/" + pluginName + "/master/src/main/resources/plugin.yml").openConnection();
                connection.connect();
                String rr = new BufferedReader(new InputStreamReader(connection.getInputStream())).lines().toList().get(1).split(" ")[1];
                if (!currentVersion.equals(rr)) {
                    p.sendMessage("[ " + pluginName + " Update Checker ] " + "최신 버전이 존재합니다! " + rr);
                    p.sendMessage("[ " + pluginName + " Update Checker ] " + "이 플러그인의 버전은 " + currentVersion + " 입니다. 업데이트를 해주시기 바랍니다.");
                    p.sendMessage("[ " + pluginName + " Update Checker ] " + "업데이트 다운로드 : https://github.com/darksoldier1404/" + pluginName + "/releases");
                } else {
                    p.sendMessage("[ " + pluginName + " Update Checker ] " + "이 플러그인은 최신버전 입니다." + currentVersion);
                }
            } catch (IOException e) {
                p.sendMessage("[ " + pluginName + " Update Checker ] " + "업데이트 정보를 가져오는데 실패했습니다.");
            }
        });
    }
}