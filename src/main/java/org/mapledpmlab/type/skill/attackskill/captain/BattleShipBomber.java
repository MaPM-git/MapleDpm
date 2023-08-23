package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BattleShipBomber extends AttackSkill {
    public BattleShipBomber() {
        this.setName("배틀쉽 봄버");
        this.setAttackCount(3L);
        this.setDamage(403.0);
        this.setInterval(1080L);        // 사인 오브 봄바드
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
