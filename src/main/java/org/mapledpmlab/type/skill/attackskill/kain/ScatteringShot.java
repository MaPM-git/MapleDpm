package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ScatteringShot extends AttackSkill {
    public ScatteringShot() {
        this.setName("스캐터링 샷");
        this.setDamage(448.0);
        this.setAttackCount(4L * 6);
        this.setDelayByAttackSpeed(630L);
        this.setCooldown(6.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
        this.addFinalDamage(3.5 / 6);
        this.setApplyCooldownReduction(false);
    }
}
