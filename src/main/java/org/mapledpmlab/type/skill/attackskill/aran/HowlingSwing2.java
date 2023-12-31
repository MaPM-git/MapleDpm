package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingSwing2 extends AttackSkill {
    public HowlingSwing2() {
        this.setName("하울링 스윙(2타)");
        this.setAttackCount(10L);
        this.setDamage(1320.0 + 100);
        this.setDelayByAttackSpeed(450L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HowlingSwing3());
    }
}
