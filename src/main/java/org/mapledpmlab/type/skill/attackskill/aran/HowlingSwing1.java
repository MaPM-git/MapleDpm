package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingSwing1 extends AttackSkill {
    public HowlingSwing1() {
        this.setName("하울링 스윙(1타)");
        this.setAttackCount(10L + 2);
        this.setDamage(1200.0 + 100 + 150);
        this.setDelayByAttackSpeed(270L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HowlingSwing2());
    }
}
