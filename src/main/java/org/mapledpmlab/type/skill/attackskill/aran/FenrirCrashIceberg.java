package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FenrirCrashIceberg extends AttackSkill {
    public FenrirCrashIceberg() {
        this.setName("펜릴 크래시(빙산)");
        this.setDamage(650.0 + 100);
        this.setAttackCount(6L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
