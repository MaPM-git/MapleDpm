package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MetalArmorFullBurst extends AttackSkill {
    public MetalArmorFullBurst() {
        this.setName("메탈아머 전탄발사");
        this.setDelay(7050L + 1800);
        this.setDotDuration(7050L);
        this.setInterval(150L);
        this.setLimitAttackCount(47L);
        this.setAttackCount(12L);
        this.setDamage(880.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
