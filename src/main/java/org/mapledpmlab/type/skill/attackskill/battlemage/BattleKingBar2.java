package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BattleKingBar2 extends AttackSkill {
    public BattleKingBar2() {
        this.setName("배틀킹 바2");
        this.setDamage(325.0);
        this.setDelayByAttackSpeed(300L);
        this.setAttackCount(5L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
