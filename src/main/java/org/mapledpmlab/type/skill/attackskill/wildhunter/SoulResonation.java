package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulResonation extends AttackSkill {
    public SoulResonation() {
        this.setName("영혼의 공명");
        this.setAttackCount(10L);
        this.setDamage(3900.0);
        this.setDotDuration(30000L);
        this.setInterval(2000L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
