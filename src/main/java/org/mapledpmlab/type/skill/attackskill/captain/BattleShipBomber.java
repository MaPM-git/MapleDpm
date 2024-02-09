package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BattleShipBomber extends AttackSkill {
    public BattleShipBomber() {
        this.setName("배틀쉽 봄버");
        this.setAttackCount(3L);
        this.setDamage(840.0);
        this.setDelay(780L);
        this.setCooldown(60.0);
        this.setDotDuration(60000L);
        this.setInterval(540L);         // 사인 오브 봄바드
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
