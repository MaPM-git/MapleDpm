package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackBlaster extends AttackSkill {
    public FinalAttackBlaster() {
        this.setName("파이널 어택(블래스터)");
        this.setAttackCount(1L);
        this.setDamage(120.0 + 141);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setProp(100L);
    }
}
