package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.bishop.HolyAdventBuff;

public class HolyAdvent2 extends AttackSkill {
    public HolyAdvent2() {
        this.setName("홀리 어드밴트(참격2)");
        this.setAttackCount(10L);
        this.setCooldown(360.0);
        this.setDamage(4020.0);
        this.setDotDuration(660L);
        this.setLimitAttackCount(5L);
        this.setInterval(132L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HolyAdventBuff());
    }
}
