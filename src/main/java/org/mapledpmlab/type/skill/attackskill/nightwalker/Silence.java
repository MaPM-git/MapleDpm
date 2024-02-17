package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.nightwalker.SilenceBuff;

public class Silence extends AttackSkill implements DarkAttack {
    public Silence() {
        this.setName("사일런스");
        this.setAttackCount(12L);
        this.setDamage(945.0);
        this.setDelay(5100L);
        this.setCooldown(360.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setRelatedSkill(new SilenceBuff());
        this.getMultiAttackInfo().add(3180L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);     // 18
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(15L);     // 20
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
        this.getMultiAttackInfo().add(15L);
    }
}
