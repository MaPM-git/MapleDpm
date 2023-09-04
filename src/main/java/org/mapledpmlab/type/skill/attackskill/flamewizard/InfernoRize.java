package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernoRize extends AttackSkill {
    public InfernoRize() {
        this.setName("인페르노라이즈");
        this.setDamage(635.0);
        this.setDelay(120L);
        this.setAttackCount(6L);
        this.setCooldown(30.0);
        this.setRelatedSkill(new InfernoRizeFoxPrank());
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
    }
}
