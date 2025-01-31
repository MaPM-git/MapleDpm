package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuriosCharge extends AttackSkill {
    public FuriosCharge() {
        this.setName("퓨리어스 차지(6스택)");
        this.setAttackCount(10L);
        this.setDamage(1320.0);
        this.setDelayByAttackSpeed(540L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(30L);
        this.addFinalDamage(1.6);
        this.setCooldown(48.0);
        this.setApplyCooldownReduction(false);
        //this.setRelatedSkill(new EnergyOrbDelay());
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(540L);
    }
}
