package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BattleKingBar2 extends AttackSkill {
    public BattleKingBar2() {
        this.setName("배틀킹 바2");
        this.setDamage(650.0);
        this.setAttackCount(5L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
