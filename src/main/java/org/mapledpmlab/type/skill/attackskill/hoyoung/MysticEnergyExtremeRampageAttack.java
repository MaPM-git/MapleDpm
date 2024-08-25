package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MysticEnergyExtremeRampageAttack extends AttackSkill {
    public MysticEnergyExtremeRampageAttack() {
        this.setName("선기 : 극대 분신난무");
        this.setDamage(60.0 + 60 + 112 + 800);
        this.setAttackCount(4L);
        this.setCooldown(1.5);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
