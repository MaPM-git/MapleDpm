package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BarrelRouletteSkull extends AttackSkill {
    public BarrelRouletteSkull() {
        this.setName("오크통 룰렛(해골)");
        this.setDamage(225.0);
        this.setAttackCount(1L);
        this.setDotDuration(15000L);
        this.setInterval(1000L);
    }
}
