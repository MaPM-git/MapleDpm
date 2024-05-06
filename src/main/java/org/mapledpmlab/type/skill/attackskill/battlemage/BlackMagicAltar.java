package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackMagicAltar extends AttackSkill {
    public BlackMagicAltar() {
        this.setName("블랙 매직 알터");
        this.setDelay(690L);
        this.setInterval(1140L);
        this.setDotDuration(40000L);
        this.setDamage(1675.0);
        this.setAttackCount(8L);
        this.setCooldown(40.0);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyCooldownReduction(false);
    }
}
