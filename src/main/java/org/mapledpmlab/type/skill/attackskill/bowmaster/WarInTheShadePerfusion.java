package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WarInTheShadePerfusion extends AttackSkill {
    public WarInTheShadePerfusion() {
        this.setName("어센던트 셰이드(화살 세례)");
        this.setAttackCount(8L);
        this.setDamage(1543.0);
        this.setCooldown(3.0);
        this.setApplyCooldownReduction(false);
        this.setDotDuration(10L);
        this.setInterval(1L);
        this.setLimitAttackCount(7L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.getMultiAttackInfo().add(330L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
