package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GigaSlasher extends AttackSkill {
    public GigaSlasher() {
        this.setName("기가 슬래셔");
        this.setDamage(580.0 + 75);
        this.setAttackCount(9L + 1);    // 기가 슬래셔-보너스 어택
        this.setDelayByAttackSpeed(720L);
        this.setAddDamage(20L);     // 기가 슬래셔-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
