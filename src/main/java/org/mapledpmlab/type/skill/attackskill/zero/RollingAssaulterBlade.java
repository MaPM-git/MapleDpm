package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RollingAssaulterBlade extends AttackSkill implements AlphaSkill {
    public RollingAssaulterBlade() {
        this.setName("롤링 어썰터(검기)");
        this.setAttackCount(12L);
        this.setDamage(680.0);
        this.setDelayByAttackSpeed(30L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
