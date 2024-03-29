package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArtsAstra extends AttackSkill implements ArtsSkill {
    public ArtsAstra() {
        this.setName("아츠 : 아스트라");
        this.setDamage(660.0);
        this.setAttackCount(6L + 1);
        this.setCooldown(14.0);
        this.setDotDuration(840L * 3);
        this.setInterval(840L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setAddDamage(20L);     // 아츠-리인포스
        this.setRelatedSkill(new ArtsAstraFinish());
    }
}
