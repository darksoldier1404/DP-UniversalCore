package com.darksoldier1404.duc.api.entity;

import com.darksoldier1404.duc.UniversalCore;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("all")
public class TargetAPI {
    private static final UniversalCore plugin = UniversalCore.getInstance();

    @Nullable
    public static Entity getNearestTargetFromList(Entity center, double maxDistance) {
        if (center == null) return null;
        List<Entity> targets = center.getNearbyEntities(maxDistance, maxDistance, maxDistance);
        if (targets.isEmpty()) return null;
        Entity nearestTarget = null;
        double nearestDistance = maxDistance;
        for (Entity target : targets) {
            double distance = center.getLocation().distance(target.getLocation());
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestTarget = target;
            }
        }
        return nearestTarget;
    }

    @Nullable
    public static Entity getNearestTargetFromList(Entity center, double maxX, double maxY, double maxZ, double maxDistance) {
        if (center == null) return null;
        List<Entity> targets = center.getNearbyEntities(maxX, maxY, maxZ);
        if (targets.isEmpty()) return null;
        Entity nearestTarget = null;
        double nearestDistance = maxDistance;
        for (Entity target : targets) {
            double distance = center.getLocation().distance(target.getLocation());
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestTarget = target;
            }
        }
        return nearestTarget;
    }

    @Nullable
    public static Entity getNearestTargetFromList(Entity center, List<Entity> targets, double maxDistance) {
        if (center == null) return null;
        if (targets.isEmpty()) return null;
        Entity nearestTarget = null;
        double nearestDistance = maxDistance;
        for (Entity target : targets) {
            double distance = center.getLocation().distance(target.getLocation());
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestTarget = target;
            }
        }
        return nearestTarget;
    }

    public static double getDistanceBTAC(Entity center, Entity target) {
        if (center == null || target == null) return 0;
        return center.getLocation().distance(target.getLocation());
    }


}
