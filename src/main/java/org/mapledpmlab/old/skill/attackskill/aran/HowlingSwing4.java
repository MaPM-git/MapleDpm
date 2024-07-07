package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingSwing4 extends AttackSkill {
    public HowlingSwing4() {
        this.setName("하울링 스윙(4타)");
        this.setAttackCount(14L + 1);
        this.setDamage(1680.0 + 100);
        this.setDelayByAttackSpeed(450L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
