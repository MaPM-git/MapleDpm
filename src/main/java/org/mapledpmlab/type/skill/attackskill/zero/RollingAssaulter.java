package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RollingAssaulter extends AttackSkill implements AlphaSkill {
    public RollingAssaulter() {
        this.setName("롤링 어썰터");
        this.setAttackCount(12L);
        this.setDamage(680.0);
        this.setDelayByAttackSpeed(1260L);
        this.setRelatedSkill(new RollingAssaulterBlade());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
