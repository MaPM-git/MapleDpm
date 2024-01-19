package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.hero.IncisingBuff;

public class IncisingDot extends AttackSkill {
    public IncisingDot() {
        this.setName("인사이징(도트)");
        this.setAttackCount(1L);
        this.setDamage(168.0);      // 쓸컴뱃 기준
        this.setFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setDotDuration(60000L);
        this.setInterval(2000L);
        this.setRelatedSkill(new IncisingBuff());
    }
}
