package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HolyAdventCharity extends AttackSkill {
    public HolyAdventCharity() {
        this.setName("홀리 어드밴트(자애의 천사)");
        this.setAttackCount(12L);
        this.setDamage(500.0);
        this.setDotDuration(60000L - 1800);
        this.setInterval(4000L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setRelatedSkill(new HolyAdvent1());
    }
}
