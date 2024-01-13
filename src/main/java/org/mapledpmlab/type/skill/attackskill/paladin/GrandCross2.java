package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrandCross2 extends AttackSkill {
    public GrandCross2() {
        this.setName("그랜드 크로스(큰 십자가)");
        this.setAttackCount(12L);  // 큰 십자가 31
        this.setDamage(1150.0);
        this.setDotDuration(90L * 31);
        this.setLimitAttackCount(31L);
        this.setInterval(90L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new GrandCross2Delay());
        this.setApplyFinalAttack(true);
    }
}
