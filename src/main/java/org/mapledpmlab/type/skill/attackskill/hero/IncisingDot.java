package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.buffskill.hero.IncisingBuff;

public class IncisingDot extends DotAttackSkill {
    public IncisingDot() {
        this.setName("인사이징(도트)");
        this.setAttackCount(1L);
        this.setDamage(168.0);      // 쓸컴뱃 기준
        this.setDotDuration(60000L);
        this.setInterval(2000L);
        this.setRelatedSkill(new IncisingBuff());
    }
}
