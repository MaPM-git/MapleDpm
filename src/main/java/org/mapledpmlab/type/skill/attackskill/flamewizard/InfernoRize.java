package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernoRize extends AttackSkill {
    public InfernoRize() {
        this.setName("인페르노라이즈");
        this.setDamage(1250.0);
        this.setDelay(120L);
        this.setAttackCount(12L);
        this.setCooldown(30.0);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
