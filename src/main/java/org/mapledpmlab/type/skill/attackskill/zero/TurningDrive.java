package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TurningDrive extends AttackSkill implements BetaSkill {
    public TurningDrive() {
        this.setName("터닝 드라이브");
        this.setAttackCount(6L);
        this.setDamage(465.0);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
