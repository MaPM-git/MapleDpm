package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FenrirCrash extends AttackSkill {
    public FenrirCrash() {
        this.setName("펜릴 크래시");
        this.setDamage(735.0 + 100);
        this.setAttackCount(7L);
        this.setDelay(420L);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
