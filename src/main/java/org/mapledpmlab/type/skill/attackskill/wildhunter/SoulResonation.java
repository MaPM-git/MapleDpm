package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulResonation extends AttackSkill {
    public SoulResonation() {
        this.setName("영혼의 공명");
        this.setAttackCount(10L);
        this.setDamage(1950.0);
        this.setCooldown(2.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.getMultiAttackInfo().add(420L);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
