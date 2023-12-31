package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SmashSwing extends AttackSkill {
    public SmashSwing() {
        this.setName("스매쉬 스윙");
        this.setDamage(150.0 + 5 + 21 + 200 + 100 + 100 + 300);
        this.setAttackCount(2L);
        this.setDelayByAttackSpeed(360L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
