package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FistMethodButterflyDreamAttack extends AttackSkill {
    public FistMethodButterflyDreamAttack() {
        this.setName("권술 : 호접지몽");
        this.setDamage(300.0);
        this.setAttackCount(1L);
        this.setCooldown(1.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
