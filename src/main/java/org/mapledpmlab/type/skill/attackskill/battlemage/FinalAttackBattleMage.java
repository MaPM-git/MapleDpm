package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackBattleMage extends AttackSkill {
    public FinalAttackBattleMage() {
        this.setName("파이널 어택(다크 제네시스)");
        this.setAttackCount(1L);
        this.setDamage(254.0);      // 쓸컴뱃 기준
        this.setProp(62L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(500L);
    }
}
