package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShiningCrossAssault extends AttackSkill {
    public ShiningCrossAssault() {
        this.setName("샤이닝 크로스-어썰트");
        this.setApplyFinalAttack(true);
        this.setAttackCount(10L + 1);   // 샤이닝 크로스-보너스 어택
        this.setDamage(530.0);
        this.setDelayByAttackSpeed(720L);
        this.addIgnoreDefenseList(20L); // 샤이닝 크로스-이그노어 가드
        this.setAddDamage(20L);         // 샤이닝 크로스-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
