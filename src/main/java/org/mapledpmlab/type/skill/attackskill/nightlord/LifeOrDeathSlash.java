package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LifeOrDeathSlash extends AttackSkill {
    public LifeOrDeathSlash() {
        this.setName("생사여탈(참격)");
        this.setAttackCount(7L * 2);
        this.setCooldown(360.0);
        this.setDamage(1180.0);
        this.setDelay(3300L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new LifeOrDeathJavelin());
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.getMultiAttackInfo().add(1440L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(330L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
