package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NightmareJudgement extends AttackSkill {
    public NightmareJudgement() {
        this.setName("나이트메어(명계의 심판)");
        this.setDotDuration(1230L);
        this.setLimitAttackCount(9L);
        this.setInterval(136L);
        this.setAttackCount(7L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(9000.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
        this.addFinalDamage(1.5);
        this.setRelatedSkill(new NightmareJudgementDelay());
    }
}
