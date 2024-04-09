package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RollingCurve extends AttackSkill implements AlphaSkill {
    public RollingCurve() {
        this.setName("롤링 커브");
        this.setAttackCount(12L);
        this.setDamage(665.0);
        this.setDelayByAttackSpeed(1260L);
        this.setRelatedSkill(new RollingCurveBlade());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
