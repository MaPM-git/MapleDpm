package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.bishop.HolyAdventBuff;

public class HolyAdventCharity extends AttackSkill {
    public HolyAdventCharity() {
        this.setName("홀리 어드밴트(자애의 천사)");
        this.setAttackCount(8L);
        this.setCooldown(360.0);
        this.setDamage(1500.0);
        this.setDotDuration(60000L);
        this.setInterval(4000L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HolyAdventDelay());
    }
}
