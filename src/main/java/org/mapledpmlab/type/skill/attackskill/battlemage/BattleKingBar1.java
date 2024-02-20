package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BattleKingBar1 extends AttackSkill {
    public BattleKingBar1() {
        this.setName("배틀킹 바1");
        this.setDamage(1300.0);
        this.setAttackCount(2L);
        this.setDelayByAttackSpeed(240L);
        this.setCooldown(13.0);
        this.setRelatedSkill(new BattleKingBar2());
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
