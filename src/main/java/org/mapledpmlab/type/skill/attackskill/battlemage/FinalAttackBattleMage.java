package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackBattleMage extends AttackSkill {
    public FinalAttackBattleMage() {
        this.setName("파이널 어택(다크 제네시스)");
        this.setAttackCount(1L);
        this.setDamage(430.0);
        this.setAddDamage(20L);             // 다크 제네시스-리인포스
        this.setProp(80L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(500L);
    }
}
