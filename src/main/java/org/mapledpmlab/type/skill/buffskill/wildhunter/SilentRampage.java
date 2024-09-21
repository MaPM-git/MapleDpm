package org.mapledpmlab.type.skill.buffskill.wildhunter;

import org.mapledpmlab.type.skill.buffskill.BuffSkill;

public class SilentRampage extends BuffSkill {
    public SilentRampage() {
        this.setName("사일런트 램피지");
        this.setDelay(600L);
        this.setDuration(40L);
        this.setCooldown(120.0);
        this.addBuffDamage(40L);
        this.setApplyServerLag(true);
    }
}
