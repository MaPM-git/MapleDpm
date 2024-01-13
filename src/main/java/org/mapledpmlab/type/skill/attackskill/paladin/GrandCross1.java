package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrandCross1 extends AttackSkill {
    public GrandCross1() {
        this.setName("그랜드 크로스(작은 십자가)");
        this.setAttackCount(12L);   // 작은 십자가 7
        this.setDamage(660.0);
        this.setDotDuration(180L * 7);
        this.setLimitAttackCount(7L);
        this.setInterval(180L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new GrandCross1Delay());
        this.setApplyFinalAttack(true);
    }
}
