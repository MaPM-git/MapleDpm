package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MetalArmorFullBurst extends AttackSkill {
    public MetalArmorFullBurst() {
        this.setName("메탈아머 전탄발사");
        this.setDelay(9180L + 1800);
        this.setDotDuration(9180L);
        this.setInterval(180L);
        this.setLimitAttackCount(51L);
        this.setAttackCount(11L);
        this.setDamage(880.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
