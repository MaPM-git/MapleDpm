package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Telekinesis extends AttackSkill {
    public Telekinesis() {
        this.setName("텔레키네시스");
        this.setDamage(350.0);
        this.setAttackCount(1L + 1);    // 텔레키네시스-보너스 어택
        this.setProp(70L + 30);         // 텔레키네시스-보너스 찬스
        this.setFinalAttack(true);
        this.setAddDamage(25L);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
