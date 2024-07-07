package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChronoTrigger1 extends AttackSkill {
    public ChronoTrigger1() {
        this.setName("크로노 트리거(참격)");
        this.setAttackCount(6L);
        this.setCooldown(360.0);
        this.setDamage(1400.0);
        this.setDelay(3150L);
        this.setRelatedSkill(new ChronoTrigger2());
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(900L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(660L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
