/*
    AreaProtection:

    Copyright (C) 2019 SchdowNVIDIA
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

    Thanks to ZAP-Hosting.com and JetBrains!

    ZAP-Hosting.com gave me a Server for testing all plugins.
    If you're interested in a cheap VPS or strong Rootserver follow the links below:
    VPS: https://zap-hosting.com/schdowvserver
    Rootserver: https://zap-hosting.com/schdowroot
    Code (10% Discount Lifetime): schdow-10
 */

package net.llamagames.AreaProtection.utils;

import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;

public class Area {

    private String name;

    private Vector3 pos1;
    private Vector3 pos2;
    private Level world;

    private boolean pvp;
    private boolean god;
    private boolean breakAllowed;
    private boolean place;
    private boolean interact;
    private boolean mobSpawn;

    public Area(String name, Vector3 pos1, Vector3 pos2, Level world, boolean breakAllowed, boolean place, boolean interact, boolean pvp, boolean god, boolean mobSpawn) {
        this.name = name;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.world = world;
        this.breakAllowed = breakAllowed;
        this.place = place;
        this.interact = interact;
        this.pvp = pvp;
        this.god = god;
        this.mobSpawn = mobSpawn;
    }

    public String getName() {
        return name;
    }

    public boolean isInArea(Position check) {
        if(check.getLevel() != world) {
            return false;
        }
        double minX = Math.min(pos1.x, pos2.x);
        double maxX = Math.max(pos1.x, pos2.x);
        double minY = Math.min(pos1.y, pos2.y);
        double maxY = Math.max(pos1.y, pos2.y);
        double minZ = Math.min(pos1.z, pos2.z);
        double maxZ = Math.max(pos1.z, pos2.z);
        return check.x >= minX && check.x <= maxX && check.y >= minY && check.y <= maxY
                && check.z >= minZ && check.z <= maxZ;
    }

    public Vector3 getPos1() {
        return pos1;
    }

    public Vector3 getPos2() {
        return pos2;
    }

    public Level getWorld() {
        return world;
    }

    public boolean isBreakAllowed() {
        return breakAllowed;
    }

    public boolean isInteractAllowed() {
        return interact;
    }

    public boolean isPlaceAllowed() {
        return place;
    }

    public boolean isPvpAllowed() {
        return pvp;
    }

    public boolean isGod() {
        return god;
    }

    public void setBreakAllowed(boolean breakAllowed) {
        this.breakAllowed = breakAllowed;
    }

    public void setInteract(boolean interact) {
        this.interact = interact;
    }

    public void setPlace(boolean place) {
        this.place = place;
    }

    public void setPvp(boolean pvp) {
        this.pvp = pvp;
    }

    public void setGod(boolean god) {
        this.god = god;
    }

    public boolean isMobSpawnAllowed() {
        return mobSpawn;
    }

    public void setMobSpawn(boolean mobSpawn) {
        this.mobSpawn = mobSpawn;
    }
}
