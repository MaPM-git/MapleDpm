package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernoRizeFoxPrank extends AttackSkill {
    public InfernoRizeFoxPrank() {
        this.setName("인페르노라이즈(여우의 장난)");
        this.setDamage(1835.0);
        this.setAttackCount(13L);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
    }
}
