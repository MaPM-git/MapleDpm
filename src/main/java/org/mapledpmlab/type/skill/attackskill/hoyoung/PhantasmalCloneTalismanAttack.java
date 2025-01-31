package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhantasmalCloneTalismanAttack extends AttackSkill {
    public PhantasmalCloneTalismanAttack() {
        this.setName("환영 분신부");
        this.setDamage(386.0);
        this.setAttackCount(4L);
        this.setCooldown(1.5);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
