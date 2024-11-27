package org.mapledpmlab.type.skill.buffskill.wildhunter;

import org.mapledpmlab.type.skill.buffskill.BuffSkill;

public class JaguarStorm extends BuffSkill {
    public JaguarStorm() {
        this.setName("재규어 스톰");
        this.setDelay(840L);
        this.setDuration(40L);
        this.setApplyServerLag(true);
        this.setCooldown(120.0);
    }
}
